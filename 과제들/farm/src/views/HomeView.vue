<template>
  <!-- 메인 영역, flex-grow-1: 남아있는 여유공간을 모두 차지함, overflow-auto: 내용물이 화면 영역을 넘어가는 경우 스크롤이 자동으로 생김 -->
  <div class="flex-grow-1 overflow-auto p-10 h-90">
      
      <!-- 이미지 섹션 h - 200px 영역 할당 경계선 색 추가 / 넘어가는 부분 지움 / 둥글게 만듦-->
      <div class="d-flex flex-column border-2 h-200px mb-3" style="overflow: hidden; border:solid green; border-radius: 10px;">
          <div class="flex-fill">
              <img src="/assets/media/logos/farmback.png" alt="" class="w-100 h-100">
          </div>
      </div>
      
      
      <!-- 메뉴 그리드 (2x2) -->
      <div class="flex-grow-1 overflow-auto">
        <div class="d-flex h-300px mt-10 mb-3">

          <div class="d-flex flex-column" style="flex: 2; margin-right: 10px;">

            <div class="d-flex h-150px mb-2" style="gap: 5px;">
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center border-2 w-150px shadow" style="border: solid #eeeeee; border-radius: 10px;">
                <div class="fs-1">💬</div>
                <div class="fs-4 fw-bold">땅 검색</div>
              </div>
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center border-2 w-200px shadow" style="border: solid #eeeeee; border-radius: 10px;">
                <div class="fs-1">📊</div>
                <div class="fs-4 fw-bold">건강수치 확인</div>
              </div>
            </div>
            
            <div class="d-flex h-150px" style="gap: 5px;">
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center border-2 w-150px shadow" style="border: solid #eeeeee; border-radius: 10px;">
                <div class="fs-1">📋</div>
                <div class="fs-4 fw-bold">거래내역</div>
              </div>
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center border-2 w-200px shadow" style="border: solid #eeeeee; border-radius: 10px;">
                <div class="fs-1">🌱</div>
                <div class="fs-4 fw-bold">내 땅 확인</div>
              </div>
            </div>
            
          </div>

          <div class="d-flex flex-column align-items-center justify-content-center border-2 bg-light-success shadow" style="flex: 1; border: solid green; border-radius: 10px;">
            <p>
              <i class="ki-duotone ki-geolocation fs-1">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </p>
            <div class="fs-4 fw-bold">내 주변</div>
          </div>

        </div>
      </div>
      
        <!-- 전체 농장 타이틀 -->
        <div class="d-flex flex-column h-50px mb-3">
          <div class="flex-fill d-flex align-items-center justify-content-between px-3">
            <h5 class="mb-0">전체 농장</h5>
              
              <span>
                <a href="" class="text-primary">더보기</a>
                <i class="ki-duotone ki-right">
                </i>
              </span>
          </div>
      </div>
      
      <!-- 상품 그리드 (3열) -->
      <div class="d-flex h-250px mb-10">
          <div class="flex-fill bg-light d-flex flex-column align-items-center justify-content-center m-1">
              <div class="h-150px text-white w-100 d-flex align-items-center justify-content-center mb-2 border-2 shadow" style="overflow: hidden; border: solid #eeeeee; border-radius: 20px;">
                  <img src="/assets/b.jpg" class="w-100 h-100 ">
              </div>
              <div class="flex-grow-1 bg-white w-100 d-flex flex-column align-items-center justify-content-center p-2">
                  <button class="btn btn-success btn-sm" style="border-radius: 30px;" @click="goT()">
                    버섯
                  </button>
                  <label class="small">⭐ 3.5 (0)</label>
                  <label class="small">전주B</label> <!-- 글자 작게 / 색상 연한 회색 -->
              </div>
          </div>
          <div class="flex-fill bg-light d-flex flex-column align-items-center justify-content-center border-end m-1">
              <div class="h-150px text-white w-100 d-flex align-items-center justify-content-center mb-2 border-2 shadow" style="overflow: hidden; border: solid #eeeeee; border-radius: 20px;">
                  <img src="/assets/y.jpg" class="w-100 h-100">
              </div>
              <div class="flex-grow-1 bg-white w-100 d-flex flex-column align-items-center justify-content-center p-2">
                  <button class="btn btn-success btn-sm" style="border-radius: 30px;" @click="goT()">
                    양배추
                  </button>
                  <label class="small">⭐ 2 (0)</label>
                  <label class="small">창원첫</label>
              </div>
          </div>
          <div class="flex-fill bg-light d-flex flex-column align-items-center justify-content-center m-1">
              <div class="h-150px text-white w-100 d-flex align-items-center justify-content-center mb-2 border-2 shadow" style="overflow: hidden; border: solid #eeeeee; border-radius: 20px;">
                  <img src="/assets/t.jpg" class="w-100 h-100">
              </div>
              <div class="flex-grow-1 bg-white w-100 d-flex flex-column align-items-center justify-content-center p-2">
                  <button class="btn btn-success btn-sm" style="border-radius: 30px;" @click="goT()">
                    토마토
                  </button>
                  <label class="small">⭐ 0 (0)</label>
                  <label class="small">경기도</label>
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
  console.log(`HomeView : onMounted 호출됨`);

  title.value = '홈';

})

function goT() {
  router.push('/about');
}

</script>

<style scoped>

</style>