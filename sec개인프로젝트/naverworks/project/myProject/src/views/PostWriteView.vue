<template>
<div style="padding-top: 85px; text-align: center;">
</div>
  
<div class="px-10 py-5" style=" margin-bottom: 60px;">

<div class="card">

<div class="card-body">

    <div class="mb-10">
    <label class="form-label fw-bold">제목</label>
    <input type="text" class="form-control" v-model="postTitle" placeholder="제목 입력">
    </div>
    
    <div class="mb-10">
    <label class="form-label fw-bold">내용</label>
    <textarea v-model="postContents" rows="5" class="form-control" style="margin-right: 10px;"></textarea>
    </div>
    
    <div class="mb-10">
        <label class="form-label fw-bold">카테고리</label>
        <select class="form-control" v-model="selectedCategory">
            <option value="">카테고리 선택</option>
            <option value="제품후기">제품후기</option>
            <option value="문의사항">문의사항</option>
            <option value="자유글">자유글</option>
        </select>
    </div>
    
    
    <div>
    <label class="form-label fw-bold">이미지</label>
    <div class="image-upload-wrap">
        <p class="text-muted m-0">이미지 선택</p>
        <button type="button" @click="showDialog()">파일 선택</button>
    </div>
    <div v-if="uploadedImagePath">
        <img :src="uploadedImagePath" id="Preview" style="width: 100%; height: auto;" @click="showDialog()">
    </div>
    </div>
    
</div>

<!-- begin::대화상자 -->
  <div class="modal fade" id="myDialog">
    <div class="modal-dialog modal-dialog-centered">

      <div class="modal-content rounded">

        <div class="modal-header">
          <span class="fs-1 fw-bold">이미지 업로드</span>
        </div>

        <div class="modal-body p-10">

          <div class="mt-4">
            <input type="file" id="uploadImage" hidden @change="getFilename($event.target.files)">
            <label for="uploadImage" class="d-flex justify-content-center">
              <button class="btn btn-light-primary h-50">클릭 =></button>    
              <img src="/assets/media/books/1.png" alt="" id="preview" width="50%">
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


<div class="card-footer">
    
    <div class="d-flex justify-content-between">
    <button v-if="mode=='add'" class="btn btn-light-primary px-10 py-5" @click="addPost()">
        <span class="fs-3 fw-bold">추가</span>
    </button>

    <button v-if="mode=='edit'" class="btn btn-light-primary px-10 py-5" @click="editPost()">
        <span class="fs-3 fw-bold">수정</span>
    </button>
    
    <button class="btn btn-light-danger px-10 py-5" @click="goToPost">
        <span class="fs-3 fw-bold">취소</span>
    </button>
    </div>
    
</div>
</div>

</div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
const router = useRouter();
const route = useRoute();

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

import { useTextStore } from '@/stores/text'
const textStore = useTextStore()
const { mode } = storeToRefs(textStore)

import { apiText } from '@/util/api_text';

//부트스트랩
import { Modal } from 'bootstrap'

//업로드
import { useUpload } from '@/util/upload.js'
const { upload } = useUpload()

const uploadedImagePath = ref('');
const postTitle = ref('');
const postContents = ref('');
const selectedCategory = ref('');

//날짜
import { format } from 'date-fns'

const todayString = format(new Date(), 'yyyy-MM-dd')


let myDialog;

//선택된 파일
const selectedFile = ref('')

import { useLoginStore } from '@/stores/logined';
const loginStore = useLoginStore()
const { logined } = storeToRefs(loginStore)

onMounted(() => {
  console.log(`PostWriteView : onMounted 호출됨`);

  if(mode.value == 'edit') {
    title.value = '게시물 수정';
    requestSelectedContent();
  } else {
    title.value = '게시물 작성';
  }

  if(!logined.value){
    alert('로그인 해주세요')
    router.push('/login')
  }

})

const id = route.query.id;
//수정화면일 때 실행됨
async function requestSelectedContent() {
    console.log(`requestSelectedContent 호출됨`);
    
    try{
  
      const response = await apiText.post('/read',{
          id: id
      })
      const result = response.data.data.data[0]
      console.log(`응답 -> ${JSON.stringify(result)}`)

      postTitle.value = result.title
      postContents.value = result.coments
      selectedCategory.value = result.category
      uploadedImagePath.value = result.path

    } catch(err) {
      console.error(`에러발생 -> ${err}`)
    }
}

//게시물 목록으로
function goToPost() {

  router.push('/call')

}

// const params = {
//     title: postTitle.value,
//     coments: postContents.value,
//     category: selectedCategory.value,
//     path: uploadedImagePath.value,
//     createDate: todayString
//   }

async function addPost() {

  const params = {
    title: postTitle.value,
    coments: postContents.value,
    category: selectedCategory.value,
    path: uploadedImagePath.value,
    createDate: todayString
  }

  console.log(`addPost 호출됨`);
  
  try{

    const response = await apiText.post('/add', params)

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    goToPost();

  } catch(err){
    console.error(`에러 -> ${err}`);
  }

}

async function editPost() {

  const params = {
    id: id,
    title: postTitle.value,
    coments: postContents.value,
    category: selectedCategory.value,
    path: uploadedImagePath.value,
    createDate: todayString
  }

  console.log(`editPost 호출됨`);

  try{

    const response = await apiText.post('/modify', params)

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    goToPost();

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

//파일선택하면 실행되는 함수
async function getFilename(files) {
  selectedFile.value = files[0]
  await base64()
}

//그냥 미리보기 해주는거 e.target.result -> 화면에 이미지를 표시
function base64() {
  return new Promise((resolve, reject) => {
    let reader = new FileReader()
    reader.onload = e => {
      resolve(e.target.result)
      
      const previewImage = document.querySelector('#preview')
      previewImage.src = e.target.result
    }
    //먼저실행
    reader.readAsDataURL(selectedFile.value)
  })
}

const url = 'http://localhost:8001'

//업로드 버튼 누르면 실행 진짜 업로드
async function uploadFile() {
  console.log(`uploadFile 함수 호출됨 -> ${selectedFile.value.name}`)
  try{
    //upload 함수 호출(실제 서버에 파일 전송)
    const response = await upload(selectedFile.value, (progress) => {
      console.log(`업로드 진행률 : ${progress}`)
    })
    
    console.log(`업로드 응답 -> ${JSON.stringify(response)}`)

    uploadedImagePath.value = url + response.data.filename

  } catch(err) {
    console.error(`업로드 중 에러 -> ${err}`)
  }

  }

</script>

<style scoped>

</style>