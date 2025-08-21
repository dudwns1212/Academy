<template>
  
  <div class="px-4 py-2" style="background-color: #eeeeee; margin-bottom: 60px;">

    <div>
      
      <div v-for="(item, index) in posts" :key="item.id" class="card post-card">
        
        <div class="card-body m-0 p-0">
          <img :src="item.thumbnail">
          <div class="p-4">
            <h5 class="fw-bold fs-3">{{ item.title }}</h5>
            <span class="text-muted">{{ item.contents}}</span>
          </div>
          
          <div class="card-footer d-flex justify-content-between align-items-center py-5">
            <span class="d-flex align-items-cneter text-gray-600 fs-5">
              <i class="ki-duotone ki-like text-primary fs-2x me-2">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            <span>{{item.likes}}</span>
          </span>
          
          <span class="d-flex align-items-cneter text-gray-600 fs-5">
            <i class="ki-duotone ki-message-notif">
              <span class="path1"></span>
              <span class="path2"></span>
              <span class="path3"></span>
              <span class="path4"></span>
              <span class="path5"></span>
            </i>
            <span>{{item.coments}}</span>
          </span>
          
          <span class="badge badge-light-primary px-4 py-2 fs-7">{{ item.category }}</span>
          <span class="text-muted">{{ item.createDate }}</span>
          
        </div>
        
      </div>
      
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
import { useRouter } from 'vue-router'
const router = useRouter();

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

//게시글 목록을 위한 변수
const posts = ref([
  {
    id: 1,
    title: '게시물 1번',
    contents: '게시물 내용입니다.',
    category: 'gang',
    createDate: '30분 전',
    likes: 22,
    coments: 2,
    thumbnail: '/assets/media/books/5.png'
  },
  {
    id: 2,
    title: '게시물 2번',
    contents: '게시물 내용입니다.',
    category: 'ganggang',
    createDate: '1시간 전',
    likes: 121,
    coments: 14,
    thumbnail: '/assets/media/books/11.png'
  },
  {
    id: 3,
    title: '게시물 3번',
    contents: '게시물 내용입니다.',
    category: 'gangganggang',
    createDate: '3시간 전',
    likes: '1.1k',
    coments: 198,
    thumbnail: '/assets/media/books/4.png'
  }

])

onMounted(() => {
  console.log(`DocumentView : onMounted 호출됨`);

  title.value = '게시물';

})

function goToPostWrite() {
  router.push('/postwrite')
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