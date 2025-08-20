<template>
    <!-- 상단 타이틀 추가하기 1 상단 타이틀-->
    <div class="d-flex flex-column h-100">
        <div class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">
            <button class="btn btn-icon btn-light" id="kt_app_sidebar_mobile_toggle"> 
                <i class="ki-duotone ki-menu fs-2x text-primary">
                  <span class="path1"></span>
                  <span class="path2"></span>
                  <span class="path3"></span>
                  <span class="path4"></span>
                </i>
            </button>
            
            <span class="fs-2 fw-bold">메인 화면</span>
            
            <button>
                <i class="ki-duotone ki-double-left fs-2x text-primary">
                    <span class="path1"></span>
                    <span class="path2"></span>
                </i>
            </button>
        </div>
        
        <!-- 메인 영역, flex-grow-1: 남아있는 여유공간을 모두 차지함, overflow-auto: 내용물이 화면 영역을 넘어가는 경우 스크롤이 자동으로 생김 -->
        <div class="flex-grow-1 overflow-auto bg-secondary p-10 h-90">
            
            <!-- 히어로 이미지 섹션 -->
            <div class="d-flex flex-column border-2 h-200px mb-3" style="overflow: hidden; border:solid green; border-radius: 10px;">
                <div class="flex-fill bg-success text-white d-flex align-items-center justify-content-center">
                    <img src="/assets/media/logos/farmback.png" alt="" class="w-100 h-100" style="object-fit: cover;">
                </div>
            </div>
            
            <!-- 검색바 -->
            <div class="d-flex flex-column border h-100px mb-3">
                <div class="flex-fill bg-light d-flex align-items-center px-3">
                    <input type="text" class="form-control" placeholder="검색어를 입력하세요">
                </div>
            </div>
            
            <!-- 메뉴 그리드 (2x2) -->
            <div class="d-flex flex-row border h-200px mb-3">
                <div class="flex-fill bg-primary text-white d-flex flex-column align-items-center justify-content-center border-end">
                    <div class="fs-1">📊</div>
                    <div>병 질객</div>
                </div>
                <div class="flex-fill bg-info text-white d-flex flex-column align-items-center justify-content-center">
                    <div class="fs-1">📋</div>
                    <div>진단수치 확인</div>
                </div>
            </div>
            
            <div class="d-flex flex-row border h-200px mb-3">
                <div class="flex-fill bg-warning text-white d-flex flex-column align-items-center justify-content-center border-end">
                    <div class="fs-1">🏪</div>
                    <div>가게내역</div>
                </div>
                <div class="flex-fill bg-success text-white d-flex flex-column align-items-center justify-content-center">
                    <div class="fs-1">👤</div>
                    <div>내 정 확인</div>
                </div>
            </div>
            
            <!-- 전체 농장 타이틀 -->
            <div class="d-flex flex-column border h-100px mb-3">
                <div class="flex-fill bg-white d-flex align-items-center px-3">
                    <h5 class="mb-0">전체 농장</h5>
                </div>
            </div>
            
            <!-- 상품 그리드 (3열) -->
            <div class="d-flex flex-row border h-200px mb-3">
                <div class="flex-fill bg-light d-flex flex-column align-items-center justify-content-center border-end m-1">
                    <div class="h-50px bg-primary text-white w-100 d-flex align-items-center justify-content-center mb-2">
                        🥔
                    </div>
                    <div class="flex-grow-1 bg-white w-100 d-flex flex-column align-items-center justify-content-center p-2">
                        <div class="fw-bold">감자</div>
                        <div class="text-success">₩ 5,000</div>
                        <div class="small text-muted">⭐ 5.0 (12)</div>
                    </div>
                </div>
                <div class="flex-fill bg-light d-flex flex-column align-items-center justify-content-center border-end m-1">
                    <div class="h-50px bg-info text-white w-100 d-flex align-items-center justify-content-center mb-2">
                        🥬
                    </div>
                    <div class="flex-grow-1 bg-white w-100 d-flex flex-column align-items-center justify-content-center p-2">
                        <div class="fw-bold">양배추</div>
                        <div class="text-success">₩ 3,000</div>
                        <div class="small text-muted">⭐ 5.0 (8)</div>
                    </div>
                </div>
                <div class="flex-fill bg-light d-flex flex-column align-items-center justify-content-center m-1">
                    <div class="h-50px bg-danger text-white w-100 d-flex align-items-center justify-content-center mb-2">
                        🍅
                    </div>
                    <div class="flex-grow-1 bg-white w-100 d-flex flex-column align-items-center justify-content-center p-2">
                        <div class="fw-bold">토마토</div>
                        <div class="text-success">₩ 4,500</div>
                        <div class="small text-muted">⭐ 5.0 (15)</div>
                    </div>
                </div>
            </div>
            
        </div>
        
        <!-- 하단 텝, fixed-bottom: 화면 맨 아래에 고정시킴, justify-content-around: 버튼을 가로 방향으로 균등 배치함 md : 반응형-->
      <div class="fixed-bottom d-md-none bg-white border-top h-10">

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
    data-kt-drawer-width="{default: '250px', 'md' : '500px'}"
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

      <div class="m-10">

        <button class="btn btn-sm btn-primary" @click="closeDrawer()">닫기</button>

      </div>

    </div>

   </div>

</template>

<script setup>

import {ref, onMounted} from 'vue'

let drawer

const activeTab = ref('home');

//화면이 보이기 전에 한 번 호출됨
onMounted(() => {
  console.log('onMounted 호출됨');

  KTDrawer.createInstances();

  // Drawer 설정
  const drawerElem = document.querySelector('#kt_drawer_basic1');
  drawer = KTDrawer.getInstance(drawerElem);
  drawer.on('kt.drawer.shown', ()=>{
    console.log('Drawer가 보여짐')
    drawerElem.classList.remove('drawer-hidden');
  });

  drawer.on('kt.drawer.hidden', ()=>{
    console.log('Drawer가 사라짐');
    drawerElem.classList.add('drawer-hidden');
  })
});

//드로어 안에 있는 닫기 버튼을 눌렀을 때, 함수 실행
function closeDrawer() {
  console.log('closeDrawer 호출됨')

  if(drawer) {
    drawer.hide();
  }

}

//하단 탭의 버튼이 눌렸을 때
function tabButtonClicked(name){
  console.log('tabButtonClicked 호출됨');

  activeTab.value = name;

}

</script>

<style scoped>

.my-border {
  border: 2px dashed violet;
}

.drawer-hidden {
  transform: translateX(-100%);
  visibility: hidden;
}

.drawer-shown {
  visibility: visible;
}

.tab-btn {
  padding: 4px 8px;
  border-radius: 8px;
  transition: all 0.25s ease-in-out;
}

.tab-btn.active {
  background-color: rgba(15, 110, 253, 0.1);
  color: var(--bs-primary) !important;
  border-radius: 8px;
  transform: scale(1.18);
}

.tab-btn .menu-icon {
  transition: color 0.25s ease-in-out;
}

.tab-btn.active .menu-icon i {
  color: var(--bs-primary) !important;
}

</style>