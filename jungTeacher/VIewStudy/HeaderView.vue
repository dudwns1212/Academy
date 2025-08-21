<template>
  <!-- 헤더 전체 배경색 약간 회색 적용 -->
  <div id="kt_app_header" class="app-header" style="background-color: whitesmoke;">
    <div class="app-container container-xxl d-flex align-items-stretch justify-content-between">
      <!-- 로고 / 누르면 홈으로 다시 돌아가게 설정 -->
      <div class="d-flex align-items-center flex-grow-1 flex-lg-grow-0 me-lg-15">
        <button @click="router.push('/')" style="background-color: whitesmoke; border: none;">
          <img alt="Logo" src="/assets/media/logos/NaverWorks.svg" class="h-20px h-lg-40px" />
          <span class="ms- fs-5 fw-bold text-dark"> NAVER WORKS</span>
        </button>
      </div>
      
      <!-- 메뉴 metronic 사용 -->
      <div class="d-flex align-items-stretch justify-content-between flex-lg-grow-1">
        <div class="d-flex align-items-stretch">
          <nav class="menu menu-rounded menu-lg-row fw-semibold px-2 px-lg-0 d-flex align-items-center">
            <!-- bootstrap의 dropdown 사용
             제품 -->
            <div class="dropdown me-3">
                <span class="btn fs-4 fw-midium dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                제품
                </span>
                <ul class="dropdown-menu">
                <li><a class="dropdown-item" href='http://localhost:5173/product1'>제품 정보</a></li>
                <li><a class="dropdown-item" href="http://localhost:5173/product2">사용 방법</a></li>
                </ul>
            </div>
            <!-- 솔루션 -->
            <div class="dropdown me-3">
                <span class="btn fs-4 fw-midium dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                솔루션
                </span>
                <ul class="dropdown-menu">
                <li><a class="dropdown-item" href='http://localhost:5173/solution1'>lesson1</a></li>
                <li><a class="dropdown-item" href="http://localhost:5173/solution2">lesson2</a></li>
                </ul>
            </div>
            <div class="dropdown me-3">
                <span class="btn fs-4 fw-midium" @click="router.push('/fee')" type="button">
                이용요금
                </span>
            </div>
            <div class="dropdown me-3">
                <span class="btn fs-4 fw-midium" @click="router.push('/doip')" type="button">
                도입사례
                </span>
            </div>
            <div class="dropdown me-3">
                <span class="btn fs-4 fw-midium" @click="router.push('/info')" type="button">
                유용한 자료
                </span>
            </div>
            <div class="dropdown me-3">
                <span class="btn fs-4 fw-midium" @click="router.push('/call')" type="button">
                고객지원
                </span>
            </div>
          </nav>
        </div>

        <!-- 로그인 / 회원가입 
        v-if=!isLogin - 로그인 x/ v-else = 로그인 o 으로 로그인을 했을 때와 로그인이 안됐을 때를 차이를 줌 -->
        <div class="d-flex align-items-center ms-3" v-if="!isLogin">
          <a href="http://localhost:5173/login" class="menu-link fs-4 fw-medium me-3" style="color: gray;">로그인</a>
          <a href="http://localhost:5173/register" class="menu-link fs-4 fw-medium" style="color: gray;">회원가입</a>
        </div>
        <div class="d-flex align-items-center ms-3" v-else>
          <span class="me-3 fs-5 fw-bold text-dark">👤 {{ user.name }}님</span>
          <button @click="router.push('/mypage')" class="menu-link fs-4 fw-medium me-3" style="color: gray; border: none;">마이페이지</button>
          <span class="menu-link fs-4 fw-medium" style="color: gray; cursor:pointer;" @click="logout">로그아웃</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()

// 현재 로그인된 사용자 정보를 담을 수 있는 user
import { ref, computed, onMounted } from 'vue'
const user = ref(null)

// 로그인 여부 확인
// !!으로 값이 null이면 false , 있으면 true 변환 
// uservalue의 값이 변하면 isLogin의 값도 자동으로 변환 - computed의 역할
const isLogin = computed(() => !!user.value)

// localstorage에 저장된 user라는 키값의 유저의 정보를 기억 / 새로고침이나 껏다 켜도 저장되도록
// 화면에 나타난 직후 실행하도록 onMounted 즉 키자마자 - 로그인 로그아웃 여부 판단 
onMounted(() => {
  const saved = localStorage.getItem('user')
  if (saved) {
    user.value = JSON.parse(saved)
  }
})

// 로그아웃을 누르면 함수가 실행되면서 user의 정보가 삭제되면서 홈으로 백 -> 상단 툴바도 로그아웃 상태로 변경
function logout() {
  localStorage.removeItem('user')
  user.value = null
  router.push('/')
}
</script>

<style scoped>


.btn{
  cursor: pointer;
  transition: color 0.2s;
}
.btn:hover {
  color: #009ef7 !important;
}
.dropdown-menu {
    background-color: whitesmoke;
}
</style>
