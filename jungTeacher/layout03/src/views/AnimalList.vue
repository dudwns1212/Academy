<template>
  
  <div>

    <div>
      <h1>홈 화면</h1>
            
    </div>
    
    <div class="">
      <div  v-if="nameVisible">
        <label>이름 : </label>
        <span>{{ name }}</span>
      </div>

      <div v-else>
        <label>나이</label>
        <label for="">21</label>
      </div>

      <div>
        <label for="">이름 입력 : </label>
        <input type="text" v-model="nameInput">
      </div>

      <div>
        <button class="btn btn-sm" @click="show()">확인</button>
      </div>

      <div class="">
        <div style="margin-top: 2em; margin-bottom: 2em;">
          <span>동물들 </span>
          <button class="btn btn-sm btn-light-primary" @click="addAnimal()">추가</button>

          <button class="btn btn-sm btn-primary ms-4" @click="showDialog()">대화상자 띄우기</button>
        </div>

        <div v-for="(item, index) in animals" :key="item.id" :class="(item.type == 'dog') ? 'dog-style' : 'cat-style'">
          <div style="margin-top: 1em;">
            <label for="">구분 : </label>
            <span>{{ (item.type == 'dog') ? '강아지' : (item.type == 'cat') ? '고양이' : '' }}</span>
          </div>

        
          <div>
            <label for="">이름 : </label>
            <span>{{ item.name }}</span>
          </div>

          <div>
            <label for="">나이 : </label>
            <span>{{ item.age }}</span>
          </div>

          <div>
            <label for="">전화번호 : </label>
            <span>{{ item.mobile }}</span>
          </div>

          <div>
            <label for="">사진 : </label>
            <img :src="item.path" style="width: 50px;">
          </div>

          <div>
            <button class="btn btn-sm" @click="modifyAnimal(index)">수정</button>
            <button class="btn btn-sm" @click="deleteAnimal(index)">삭제</button>
          </div>  
        </div>
        <div style="margin-top: 1em;">
          <Pagination :requestFunc="requestAnimalList" :pagination="pagination1" />
        </div>
        
      </div>
    </div>
  </div>

  <!-- begin::대화상자 -->
  <div class="modal fade" id="myDialog">
    <div class="modal-dialog modal-dialog-centered">

      <div class="modal-content rounded">

        <div class="modal-header">
          <span class="fs-1 fw-bold">파일 업로드</span>
        </div>

        <div class="modal-body p-10">

          <div>
            <label for="">이름</label>
            <input type="text" class="form-control form-control-solid">
          </div>

          <div class="mt-4">
            <input type="file" id="uploadImage" hidden @change="getFilename($event.target.files)">
            <label for="uploadImage" class="d-flex justify-content-center">
              <img src="/images/dog1.jpg" alt="" id="preview" width="50%">
            </label>
          </div>

          <div class="mt-10">
            <button class="btn btn-primary" @click="uploadFile()">업로드</button>
          </div>

        </div>

      </div>

    </div>
  </div>
  <!-- end::대화상자 -->

</template>

<script setup>

import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router'
const router = useRouter();

//스토어(공통저장소)를 사용하기 위함
import { storeToRefs } from 'pinia';

import { useAnimalStore } from '@/stores/animal'
const animalStore = useAnimalStore()
const { animals, mode, selectedIndex } = storeToRefs(animalStore)

//웹서버로 요청하기 위한 모듈
import axios from 'axios'

import { api } from '@/util/api';


//페이지네이션
import Pagination from '@/components/Pagination.vue'
import { usePagination } from '@/util/pagination'
const { makePagination } = usePagination()

const pagination1 = ref({})

//부트스트랩
import { Modal } from 'bootstrap'

//업로드
import { useUpload } from '@/util/upload.js'
const { upload } = useUpload()



//감시할 수 있는 변수상자, ref 함수를 이용해서 만듦, 봉지를 씌운 것과 같다
//자바스크립트 코드에서는 변수상자의 값을 바꿀 때 name, value를 사용해야 한다.
//<template> 안에 있는 태그에서 값을 감시할 때는 {{ name }}을 사용해야 한다.
const name = ref('홍길동1')

const nameInput = ref('')

const nameVisible = ref(true)

//대화상자 객체를 담아 둘 변수상자
let myDialog;

//선택된 파일
const selectedFile = ref('')


//화면이 보이기 전에 한 번 실행됨
//목적 : 화면이 보이기 전에 초기화 or 실행해야 하는 것들을 실행
onMounted(() => {
  console.log(`HomeView : onMounted 호출됨`)
  
  requestAnimalList(1, 2)

})

async function requestAnimalList(page, perPage) {
  try{
    /*
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/list',
      data: {
        page: page,
        perPage: perPage
      },
      timeout: 5000,
      responseType: 'json'
    })
    */
    const response = await api.post('/list', {
        page: page,
        perPage: perPage
      })



    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    animals.value = response.data.data.data

    pagination1.value = makePagination(response.data.data.header)

  } catch(err){
    console.error(`에러 -> ${err}`);
  }
}

//대화상자 띄우기
function showDialog() {
  console.log(`showDialog 함수 호출됨`)

  const elem = document.querySelector('#myDialog')
  myDialog = new Modal(elem)
  myDialog.show()

}

async function getFilename(files) {
  selectedFile.value = files[0]
  await base64()
}
//파일리더가 무언가를 읽음, 다 읽으면 읽은 결과가 result에 들어감
//e.target.result -> 이미지를 로딩
//로딩한 걸 previewImage src값에 넣는다?
function base64() {
  return new Promise((resolve, reject) => {
    let reader = new FileReader()
    reader.onload = e => {
      resolve(e.target.result)
      
      const previewImage = document.querySelector('#preview')
      previewImage.src = e.target.result
    }

    reader.readAsDataURL(selectedFile.value)
  })
}

async function uploadFile() {
  console.log(`uploadFile 함수 호출됨 -> ${selectedFile.value.name}`)
  try{
    const response = await upload(selectedFile.value, (progress) => {
      console.log(`업로드 진행률 : ${progress}`)
    })
  
    console.log(`업로드 응답 -> ${JSON.stringify(response)}`)
  } catch(err) {
    console.error(`업로드 중 에러 -> ${err}`)
  }

  }

function show() {
  console.log(`show함수 호출됨`)

  name.value = nameInput.value

  nameVisible.value = false

  //name.value = '홍길동2'
}

function addAnimal() {
  console.log(`addAnimal 함수 호출됨`)

  mode.value = 'add'
  router.replace('/add', {})
}

//목록 : 해당 값을 확인할 id를 가져가야됨 
//삭제 : 그냥 버튼 누르면 객체가 사라지게 하기 
//수정 : onMounted로 해당 객체의 값들을 먼저 화면에 보여주고 수정한 후 버튼을 누르면 기존의 add 처럼 객체에 적용
function deleteAnimal(index) {
  console.log(`deleteAnimal 함수 호출됨 -> ${index}`)

  const item = {
    id: animals.value[index].id
  }

  requestAnimalRemove(item)
}

async function requestAnimalRemove(item) {
  
  try{
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/remove',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    requestAnimalList(1,10)

  } catch(err){
    console.error(`에러 -> ${err}`);
  } 
}

function modifyAnimal(index) {
  console.log(`modifyAnimal 함수 호출됨 -> ${index}`)

  mode.value = 'modify'
  selectedIndex.value = index
  
  router.replace(`/add`, {})
}

</script>

<style scoped>

.dog-style {
  background-color: rgb(220, 163, 87);
  margin-bottom: 1em;

}

.cat-style {
  background-color: gainsboro;
  margin-bottom: 1em;
}

</style>

