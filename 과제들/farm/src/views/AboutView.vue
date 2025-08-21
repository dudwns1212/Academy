<template>
  <div class="flex-grow-1 overflow-auto p-10 h-90">
      
      <!-- 상품 이미지 섹션 -->
      <div class="d-flex flex-column border-2 h-200px mb-3" style="overflow: hidden; border:solid green; border-radius: 10px;">
          <div class="flex-fill">
              <img src="/assets/y.jpg" alt="" class="w-100 h-100">
          </div>
      </div>
      
      <!-- 상품 정보 입력 영역 -->
      <div class="d-flex flex-column bg-white border-2 mb-3 p-4" style="border: solid #eeeeee; border-radius: 10px;">
          <div class="mb-3">
              <label class="fw-bold mb-2">상품명</label>
              <input type="text" class="form-control" placeholder="복숭아 밭" style="border-radius: 10px;">
          </div>
          
          <div class="mb-3">
              <label class="fw-bold mb-2">가격</label>
              <div class="d-flex align-items-center">
                  <input type="text" class="form-control me-2" placeholder="15000" style="border-radius: 10px; width: 200px;">
                  <span class="fs-5 fw-bold text-danger">원</span>
              </div>
          </div>
          
          <div class="mb-3">
              <div class="d-flex align-items-center justify-content-between">
                  <span class="small text-muted">등록일: 2024. 11. 14.</span>
                  <div class="d-flex align-items-center">
                      <span class="text-warning me-1">⭐⭐⭐⭐⭐</span>
                      <span class="small text-muted">4.8점</span>
                  </div>
              </div>
          </div>
          <div class="d-flex justify-content-between gap-2">

            <button class="btn btn-light-primary w-100 py-3 fw-bold " style="border-radius: 10px;" @click="goHome()">
              등록하기
            </button>
            <button class="btn btn-light-danger w-100 py-3 fw-bold" style="border-radius: 10px;" @click="goHome()">
              취소
            </button>
          </div>
      </div>
      
      <!-- 차트 영역 -->
      <div class="d-flex flex-column bg-white border-2 h-150px mb-3 p-3" style="border: solid #eeeeee; border-radius: 10px;">
          <div class="d-flex justify-content-between mb-2" >
              <span class="text-success fw-bold">월별현황</span>
              <span class="small text-muted">판매(원)</span>
          </div>
              <div class="d-flex flex-column" style="overflow: auto; border-radius: 20px;">
                <img src="/assets/c.png" class="w-100 h-100">
              </div>
          
      </div>
      
      <!-- 상세 정보 타이틀 -->
      <div class="d-flex flex-column h-50px mb-3">
          <div class="flex-fill d-flex align-items-center justify-content-between px-3">
              <h5 class="mb-0">상품 상세정보</h5>
          </div>
      </div>
      
      <!-- 상세 정보 섹션 -->
      <div class="d-flex flex-column bg-white border-2 mb-10 p-4" style="border: solid #eeeeee; border-radius: 10px;">
          <div class="h-150px text-white w-100 d-flex align-items-center justify-content-center mb-3 border-2 shadow" style="overflow: hidden; border: solid #eeeeee; border-radius: 20px;">
              <img src="/assets/t.jpg" class="w-100 h-100">
          </div>
          
          <div class="mb-3">
              <textarea class="form-control" rows="3" placeholder="토마토 팝니다. 많은 관심 잘 부탁 
              합니다! 많은 연락 부탁드려요~~~~" style="border-radius: 10px;"></textarea>
          </div>
          
          <div class="text-center">
              <label class="small text-muted">문의 사항: 010-1111-1111 # 주시와요</label>
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
  console.log(`AboutView : onMounted 호출됨`);

  title.value = '상품 등록';

})

function goHome() {
  router.push('/')
}
</script>

<style scoped>

</style>