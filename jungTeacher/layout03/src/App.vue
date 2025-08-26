<template>  
  <!-- 상단 타이틀 추가하기 -->
  <div class="d-flex flex-column h-100">

    <div v-if="!fullScreen" class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">

      <button class="btn btn-icon btn-light" id="kt_app_sidebar_mobile_toggle">
        <i class="ki-duotone ki-abstract-14 fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

      <span class="fs-2 fw-bold">{{ title }}</span>

      <button class="btn btn-icon btn-light" @click="goToLogin()">
        <i class="ki-duotone ki-setting-2 fs-2x text-primary">
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
    <div v-if="!fullScreen" class="fixed-bottom d-md-none bg-white border-top h-10">

      <div class="menu menu-row d-flex justify-content-around py-2 fs-6 fw-bold cursor-pointer">

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'home') ? 'active' : ''"
             @click="tabButtonClicked('home')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-home fs-2x">
              </i>
          </span>
          <span class="menu-title">홈</span>
        </div>

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
            :class="(activeTab == 'search') ? 'active' : ''"
             @click="tabButtonClicked('search')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-parcel-tracking fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
              </i>
          </span>
          <span class="menu-title">찾기</span>
        </div>

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
            :class="(activeTab == 'document') ? 'active' : ''"
             @click="tabButtonClicked('document')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-document fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
          </span>
          <span class="menu-title">문서</span>
        </div>

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
            :class="(activeTab == 'more') ? 'active' : ''"
             @click="tabButtonClicked('more')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-dots-circle fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
                <span class="path4"></span>
              </i>
          </span>
          <span class="menu-title">더보기</span>
        </div>

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

        <div class="menu-item">
          <div class="menu-link bg-light-primary text-primary px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-home fs-2x text-primary">
              </i>
            </span>
            <span class="menu-title m-2">홈</span>
          </div>
        </div>

        <div class="menu-item">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-parcel-tracking fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
              </i>
            </span>
            <span class="menu-title m-2">찾기</span>
          </div>
        </div>

        <div class="menu-item">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-document fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">문서</span>
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


// 전체화면으로 보일 것인지의 여부
//const fullScreen = ref(false);

let drawer;

const activeTab = ref('home');


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

})
 

// 드로어 안에 있는 [닫기] 버튼을 눌렀을 때
function closeDrawer() {
  console.log(`closeDrawer 호출됨`);

  if (drawer) {
    drawer.hide();
  }

}

// 하단 탭의 버튼이 눌렸을 때
function tabButtonClicked(name) {
  console.log(`tabButtonClicked 호출됨`);

  activeTab.value = name;

  // 메인 영역의 화면 전환하기
  if (name == 'home') {
    goToHome();
  } else if (name == 'search') {
    goToSearch();
  } else if (name == 'document') {
    goToDocument();
  } else if (name == 'more') {
    goToMore();
  }

}


function goToHome() {
  router.push('/');
}

function goToSearch() {
  router.push('/search');
}

function goToDocument() {
  router.push('/document');
}

function goToMore() {
  router.push('/more');
}

function goToLogin() {
  fullScreen.value = true;

  router.push('/login');
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


</style>
