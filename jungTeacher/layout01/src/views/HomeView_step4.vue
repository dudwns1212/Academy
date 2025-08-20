<template>
  
  <!-- 상단 타이틀 추가하기 -->
  <div class="d-flex flex-column h-100">

    <div class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">
      
      <button class="btn btn-icon btn-light">
        <i class="ki-duotone ki-arrow-right fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

      <span class="fs-2 fw-bold">제목</span>

       <button>
        <i class="ki-duotone ki-double-left fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
       </button>

    </div>

    <!-- 메인 영역, flex-grow-1: 남아있는 여유공간을 모두 차지함, overflow-auto: 내용물이 화면 영역을 넘어가는 경우 스크롤이 자동으로 생김
                     -->
    <div class="flex-grow-1 overflow-auto bg-secondary p-10 h-90">

      <h1>메인 영역</h1>

      <div class="d-flex flex-column flex-fill border h-100px">

        <div class="flex-fill bg-primary text-white">첫 번째</div>

      </div>

      <div class="d-flex flex-column border h-200px">

        <div class="flex-fill bg-primary text-white">첫 번째</div>
        <div class="flex-fill bg-info text-white">두 번째</div>

      </div>

      <div class="d-flex flex-row border h-200px">

        <div class="flex-fill bg-primary text-white">첫 번째</div>
        <div class="flex-fill bg-info text-white">두 번째</div>
        <div class="flex-fill bg-success text-white">세 번째</div>

      </div>

      <div class="d-flex flex-column border h-200px">

        <div class="h-50px bg-primary text-white">첫 번째</div>
        <div class="flex-grow-1 bg-info text-white">두 번째</div>
        <div class="h-50px bg-success text-white">세 번째</div>

      </div>

    </div>

    <!-- 하단 텝, fixed-bottom: 화면 맨 아래에 고정시킴, 
                  justify-content-around: 버튼을 가로 방향으로 균등 배치함 
                  md : 반응형-->
    <div class="fixed-bottom d-md-none bg-white border-top h-10">

      <div class="d-flex justify-content-around align-itmes-center py-5">

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>홈</span>
        </button>

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>찾기</span>
        </button>

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>문서</span>
        </button>

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>더보기</span>
        </button>

      </div>

    </div>

  </div>

</template>

<script setup>

</script>

<style scoped>

.my-border {
  border: 2px dashed violet;
}

</style>