<template>  
  <!-- 상단 타이틀 추가하기 -->
  <div class="d-flex flex-column h-100">

    <div v-if="!fullScreen" class="app-header fixed-top d-md-none d-flex align-items-center justify-content-between border-bottom bg-white p-2">
      <div>
        <button class="btn btn-sm mb-1" @click="goToHome()">
          <img alt="Logo" src="/assets/media/logos/NaverWorks.svg" class="h-40px h-lg-40px" />
        </button>
        <span class="fs-2 fw-bold">{{ title }}</span>
      </div>
      
      <button class="btn btn-icon btn-light bg-white" id="kt_app_sidebar_mobile_toggle">
        <i class="ki-duotone ki-abstract-14 fs-2x">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

    </div>
    
    <!-- 메인 영역 -->
    <div class="d-flex flex-column flex-root app-root" id="kt_app_root">
      <RouterView />
    </div>
  

    <!-- 하단 탭 -->
    <div v-if="!fullScreen" class=" d-md-none bg-none h-10" id="talk">      
      <div class="d-flex flex-column flex-fill mx-4 tab-btn" @click="tabButtonClicked('more')">
        <span class="menu-icon mb-1">
            <img src="/assets/talk.png" alt="" class="h-50px h-lg-50px">
        </span>
      </div>
    </div>

  </div>
 
  <!-- 드로어 -->
  <div id="kt_drawer_basic1"
    class="bg-white d-flex flex-column drawer-hidden"
    data-kt-drawer="true"
    data-kt-drawer-activate="true"
    data-kt-drawer-toggle="#kt_app_sidebar_mobile_toggle"
    data-kt-drawer-width="{default: '250px', 'md': '500px'}"
    data-kt-drawer-direction="start"
  >

    <div class="p-5 border-bottom">
      <h3>메뉴</h3>
    </div>

    <div class="p-5">

      <div class="menu menu-column fs-6 fw-bold">

        <div class="menu-item mb-3">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded" @click="goToProduct()">
            <span class="menu-icon">
              <i class="ki-duotone fs-2x">
              </i>
            </span>
            <span class="menu-title m-2">제품</span>
          </div>
        </div>

        <div class="menu-item mb-3">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded" @click="goToFee()">
            <span class="menu-icon">
              <i class="ki-duotone fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
              </i>
            </span>
            <span class="menu-title m-2">이용요금</span>
          </div>
        </div>

        <div class="menu-item mb-3">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded" @click="goToCall()">
            <span class="menu-icon">
              <i class="ki-duotone fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">게시판</span>
          </div>
        </div>

        <div v-if="!logined" class="menu-item mb-3">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded" @click="goToLogin()">
            <span class="menu-icon">
              <i class="ki-duotone fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">로그인</span>
          </div>
        </div>

        <div v-if="!logined" class="menu-item mb-3">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded" @click="goToRegister()">
            <span class="menu-icon">
              <i class="ki-duotone fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">회원가입</span>
          </div>
        </div>

        <div v-if="logined" class="menu-item mb-3">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded" @click="goToMyPage()">
            <span class="menu-icon">
              <i class="ki-duotone fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">마이페이지</span>
          </div>
        </div>

        <div v-if="logined" class="menu-item mb-3">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded" @click="logout()">
            <span class="menu-icon">
              <i class="ki-duotone fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">로그아웃</span>
          </div>
        </div>

      </div>

    </div>

    <div class="m-10">
      <button class="btn btn-sm btn-primary" @click="closeDrawer()">닫기</button>
    </div>

  </div>
</template>

<script setup>

import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter();

// 스토어 불러오기
import { storeToRefs } from 'pinia'
import { useAppStore } from '@/stores/app'
const appStore = useAppStore();
const { fullScreen, title } = storeToRefs(appStore);

let drawer;

// 화면이 보이기 전에 한 번 호출됨
onMounted(() => {
  console.log(`App::onMounted 호출됨.`);

  // Drawer 설정
  KTDrawer.createInstances();

  const drawerElem = document.querySelector('#kt_drawer_basic1');
  drawer = KTDrawer.getInstance(drawerElem);
  drawer.on('kt.drawer.shown', () => {
    console.log(`Drawer가 보여짐`);
    drawerElem.classList.remove('drawer-hidden');
  })
  drawer.on('kt.drawer.hidden', () => {
    console.log(`Drawer가 사라짐`);
    drawerElem.classList.add('drawer-hidden');
  })

  // loginStore.checkLogin()  // 새로고침 방지 안해도 됨

})

//로그인 체크
import { useLoginStore } from './stores/logined';
const loginStore = useLoginStore()
const { logined } = storeToRefs(loginStore)


// const login = ref(false)

// function checkLogin() {
//   const user = localStorage.getItem('user');

//   if(user) {
//     login.value = true
//   }
// }
 
// 드로어 안에 있는 [닫기] 버튼을 눌렀을 때
function closeDrawer() {
  console.log(`closeDrawer 호출됨`);
  if (drawer) {
    drawer.hide();
  }
}

function goToHome() {
  router.push('/');
  closeDrawer();
}

function goToProduct() {
  router.push('/product');
  closeDrawer();
}

function goToFee() {
  router.push('/fee');
  closeDrawer();
}

function goToCall() {
  router.push('/call');
  closeDrawer();
}

function goToLogin() {
  router.push('/login')
  closeDrawer();
}

function goToRegister() {
  router.push('/register');
  closeDrawer();
}

function goToMyPage() {
  router.push('/mypage')
  closeDrawer()
}

function logout() {
  localStorage.removeItem('user')
  closeDrawer()
  window.location.href = '/'
  
}

</script>

<style scoped> 

.my-border {
  border: 2px dashed violet;
}

/* 드로어 */
.drawer-hidden {
  transform: translateX(-100%);
  visibility: hidden;
}

.drawer-shown {
  visibility: visible;
}

/* 탭버튼 */
.tab-btn {
  padding: 4px 8px;
  border-radius: 8px;
  transition: all 0.25s ease-in-out;
}

.tab-btn.active {
  background-color: rgba(15, 110, 253, 0.1);
  color: var(--bs-primary) !important;
  border-radius: 8px;
  transform: scale(1.1);
}

.tab-btn .menu-icon {
  transition: color 0.25s ease-in-out;
}

.tab-btn.active .menu-icon i {
  color: var(--bs-primary) !important;
}

#talk {
  position: fixed;
  right: 0px;
  bottom: 0px;
  background-color: whitesmoke;
  border-radius: 40%;
  margin-bottom: 30px;
}

</style>