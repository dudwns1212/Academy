<template>
  
  <div class="px-10 py-5" style=" margin-bottom: 60px;">

  <div class="card">
    
    <div class="card-body">

      
      <div class="mb-10">
        <label class="form-label fw-bold">제목</label>
        <input type="text" class="form-control" v-model="postTitle" placeholder="제목 입력">
      </div>
      
      <div class="mb-10">
        <label class="form-label fw-bold">내용</label>
        <input type="text" class="form-control" rows="3" v-model="postContent" placeholder="내용 입력">
      </div>
      
      <div>
        <label class="form-label fw-bold">이미지</label>
        <div class="image-upload-wrap">
          <p class="text-muted m-0">이미지 선택</p>
          <input type="file" class="d-none">
        </div>
        <div class="image-preview">
          <img :src="imageReviewUri">
        </div>
      </div>
      
    </div>

    
    <div class="card-footer">
      
      <div class="d-flex justify-content-around">
        <button class="btn btn-light-primary w-45 px-20 py-5">
          <span class="fs-3 fw-bold">저장</span>
        </button>
        
        <button class="btn btn-light-danger w-45 px-20 py-5" @click="goToPost">
          <span class="fs-3 fw-bold">취소</span>
        </button>
      </div>
      
    </div>
  </div>

</div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter();

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);



onMounted(() => {
  console.log(`DocumentView : onMounted 호출됨`);

  title.value = '새 게시물 작성';

})

//게시물 목록으로
function goToPost() {
  router.push('/document')
}
</script>

<style scoped>

</style>