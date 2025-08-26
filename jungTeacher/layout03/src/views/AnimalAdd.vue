<template>
  
  <div>

    <div>
      <h1>추가 화면</h1>      
    </div>

    <div>
      <div>
        <label for="">구분</label>
        <input type="text" v-model="typeInput">
      </div>

      <div>
        <label for="">이름</label>
        <input type="text" v-model="nameInput">
      </div>

      <div>
        <label for="">나이</label>
        <input type="text" v-model="ageInput">
      </div>

      <div>
        <label for="">전화번호</label>
        <input type="text" v-model="mobileInput">
      </div>

      <div class="mt-4">
        <input type="file" id="uploadImage" hidden @change="getFilename($event.target.files)">
        <label for="uploadImage" class="d-flex justify-content-center">
          <img src="/images/dog1.jpg" alt="" id="preview" width="50%">
        </label>
      </div>

      <div>
        <label for="">이미지 경로</label>
        <input type="text" v-model="pathInput">
      </div>
    </div>

    <div style="margin-top: 2em;">
      <button @click="save()">저장</button>
      <button @click="cancle()">취소</button>
    </div>
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router'
const router = useRouter();

import { api } from '@/util/api';

/* 객체화를 util에 js파일을 하나 더 만들어서
    거기에 넣어버림 이러면 코드가 더 깔끔
const instance = axios.create({
  baseURL: 'http://localhost:8001/animal/v1',
  timeout: 5000, // 5 seconds
  headers: {
      'Content-Type': 'application/json',
  }
})
*/

//스토어(공통저장소)를 사용하기 위함
import { storeToRefs } from 'pinia';

import { useAnimalStore } from '@/stores/animal'
const animalStore = useAnimalStore()
const { animals, mode, selectedIndex} = storeToRefs(animalStore)

const typeInput = ref('')
const nameInput = ref('')
const ageInput = ref('')
const mobileInput = ref('')
const pathInput = ref('')

//업로드
import { useUpload } from '@/util/upload.js'
const { upload } = useUpload()

import { requestConfig } from '../../app.config';

//선택된 파일
const selectedFile = ref('')


onMounted(() => {
  console.log(`animalAdd : onMounted 호출됨`)

  //수정 모드인 경우, 입력상자에 선택된 아이템의 값을 넣어주기
  if(mode.value == 'modify') {
    const selected = animals.value[selectedIndex.value]

    typeInput.value = selected.type
    nameInput.value = selected.name
    ageInput.value = selected.age
    mobileInput.value = selected.mobile
    pathInput.value = selected.path
  }
  
})

async function getFilename(files) {
  console.log('선택된 파일들:', files);

  if (!files || files.length === 0) {
    console.error('파일이 선택되지 않았습니다.');
    return;
  }

  selectedFile.value = files[0]
  console.log('선택된 파일:', selectedFile.value);

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

function save() {
  console.log(`save 함수 호출됨`)

  const type = typeInput.value
  const name = nameInput.value
  const age = ageInput.value
  const mobile = mobileInput.value
  const path = pathInput.value

  const item = {
    //id: String(animals.length + 1),
    type: type,
    name: name,
    age: age,
    mobile: mobile,
    path: path
  }

  if(mode.value == 'add'){
    
    requestAnimalAdd(item)

  } else if (mode.value == 'modify') {
    
    item.id = animals.value[selectedIndex.value].id

    requestAnimalModify(item)
  }
}

async function requestAnimalAdd(item) {
  try{
    /*
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/add',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })
    */

    // 이미지 업로드
    let response = await upload(selectedFile.value, (progress) => {
      console.log(`업로드 진행률 : ${progress}`)
    })
    console.log(`업로드 응답 -> ${JSON.stringify(response)}`)
    item.path = `${requestConfig.baseUrl}${response.data.filename}`

    //복잡한 위의 코드를 axios 객체화를 통해 아래처럼 한 줄로 처리
    response = await api.post('/add', item)

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    goToList()

  } catch(err){
    console.error(`에러 -> ${err}`);
  }
}

async function requestAnimalModify(item) {
  try{
    /*
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/modify',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })
    */
    const response = await instance.post('/modify', item)

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    goToList()

  } catch(err){
    console.error(`에러 -> ${err}`);
  }
}

function goToList() {
  router.replace('/', {})
}

function cancle() {
  console.log(`cancle 함수 호출됨`)

  router.replace('/', {})
}

</script>

<style scoped>



</style>

