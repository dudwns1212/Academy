<template>
<div style="padding-top: 85px; text-align: center;">
</div>
<div class="px-4 py-2" style="margin-bottom: 100px;">

    <div>
      
      <div v-for="(item, index) in textList" :key="item.id" class="card post-card">
        
        <div class="card-body m-0 p-0">
          <div class="mb-5">
            <h5 class="fw-bold fs-3 mx-2 my-2">{{ item.title }}</h5>
          </div>
          <div v-if="item.path">
            <img :src="item.path" style="height: 300px; object-fit: contain;">
          </div>
              
          <div class="card-footer d-flex justify-content-between align-items-center py-5">
            <span class="d-flex align-items-cneter text-gray-600 fs-2">
              <button @click="showDetail(item.id)" class="btn btn-light-primary">내용</button>
            </span>

            <span class="text-muted">{{ item.createDate }}</span>    
            <span class="badge badge-light-primary px-4 py-2 fs-7">{{ item.category }}</span>
          </div>    

      </div> 
    </div>   
    <div style="margin-top: 1em;">
      <Pagination :requestFunc="requestTextList" :pagination="pagination1" />
    </div> 
    
  </div>
  
  <div class="mb-10">
    <button class="btn btn-light-primary w-100 mt-3 fs-1" @click="goToPostWrite()">
      <i class="ki-duotone ki-plus fs-2x me-2">
      </i>
      <span>새 게시물 작성</span>
    </button>
  </div>

</div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

import { useRouter } from 'vue-router';

const router = useRouter()
//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

import { useTextStore } from '@/stores/text'
const textStore = useTextStore()
const { textList, mode, selectedIndex } = storeToRefs(textStore)

import { apiText } from '@/util/api_text';

//페이지네이션
import Pagination from '@/components/Pagination.vue'
import { usePagination } from '@/util/pagination'
const { makePagination } = usePagination()

//업로드
import { useUpload } from '@/util/upload.js'
const { upload } = useUpload()

//대화상자 객체를 담아 둘 변수상자
let myDialog;

//선택된 파일
const selectedFile = ref('')

const pagination1 = ref({})

onMounted(() => {
  console.log(`CallView : onMounted 호출됨`);

  title.value = "게시판"

  requestTextList(1,2);

})

async function requestTextList(page, perPage) {
  console.log(`requestTextList 호출됨`);
  
  try{

    const response = await apiText.post('/list',{
        page: page,
        perPage: perPage
    }) 

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    textList.value = response.data.data.data;

    pagination1.value = makePagination(response.data.data.header)


  } catch(err){
    console.error(`에러 -> ${err}`);
  }
}

function goToPostWrite() {

  mode.value = 'add'

  router.push('/postwrite')
}

function showDetail(index) {
  console.log(`showDetail 함수 실행됨`)
  
  selectedIndex.value = index

  console.log('index : ' + index)

  title.value = '상세정보'

  router.replace('/detail', {})
}

</script>

<style scoped>

  .post-card {
    border: none;
    border-radius: 0.75rem;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
    margin-bottom: 2rem;
    transition: transform 0.2s;
  }

  .post-card:hover {
    transform: translateY(-5px);
  }

  .post-card img {
    border-radius: 0.5rem;
    object-fit: cover;
    height: 300px;
    width: 100%;
  }

</style>