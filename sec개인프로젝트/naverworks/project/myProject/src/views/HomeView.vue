<template>
<div class="flex-grow-1 overflow-auto">
		
	<!-- 자동으로 넘어가는 슬라이드 -->
	<div class="overlay d-flex text-center" style="overflow: hidden;">

		<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel" style="margin-top: 100px;">
		
			<!-- Slide 1 -->
			<div class="carousel-item active">
				<div class="d-flex flex-column px-5 py-5">
				<!-- 텍스트 -->
				<div class="d-flex flex-column justify-content-center text-center">
					<h2 class="display-4 fw-bold">일이 쉬워진다<br>네이버웍스</h2>
					<p class="lead text-muted mt-4" style="">
					네이버웍스는 네이버의 편리함과 기술, 일하는 방식을 담은 통합 업무<br> 
					플랫폼 입니다. 소통과 협업, 경영지원을 하나의 플랫폼에서 활용하여 
					<br>생산성을 높여보세요.
					</p>
					<div class="mt-4">
					<a class="btn btn-dark btn-lg me-3" href="http://localhost:5173/login">무료로 시작하기</a>
					<a class="btn btn-light-dark btn-lg" href="http://localhost:5173/login">도입 문의하기</a>
					</div>
				</div>
				<!-- 이미지 -->
				<div class="w-100 text-end">
					<img src="/assets/media/illustrations/dozzy-1/4.png" class="d-block" style="max-height: 500px; max-width: 470px;" />
				</div>
				</div>
			</div>

			<!-- Slide 2 -->
			<div class="carousel-item">
				<div class="d-flex flex-column px-5 py-5">
				<div class="d-flex flex-column justify-content-center text-center">
					<h2 class="display-4 fw-bold ">도입부터 기술지원까지<br>파트너 찾기</h2>
					<p class="lead text-muted mt-4">
					네이버웍스는 도입 컨설팅부터 교육, 시스템 연동,<br>기술 지원 등을 지원하는
					파트너 프로그램을 운영하고 있습니다.<br>파트너사와 함께 네이버웍스를 시작해보세요.
					</p>
					<div class="mt-4">
					<a class="btn btn-dark btn-lg me-3" href="http://localhost:5173/login">프로그램 보기</a>
					<a class="btn btn-light-dark btn-lg" href="http://localhost:5173/login">파트너 찾기</a>
					</div>
				</div>
				<div class="w-100 text-end">
					<img src="/assets/media/illustrations/sigma-1/16.png" class="d-block" style="max-height: 500px; max-width: 470px;" />
				</div>
			</div>

			</div>													
		</div>                                                                       
								
	</div>

	<!-- 자동으로 움직이는 로고들 애니메이션 -->
	<div class="logo-slider">
		<div class="logo-track">
			<img src="/assets/media/logos/custom-1.png" />
			<img src="/assets/media/logos/custom-2.svg" />
			<img src="/assets/media/logos/custom-3.svg" />
			<img src="/assets/media/logos/default.svg" />
			<img src="/assets/media/logos/mail.svg" />
			<img src="/assets/media/logos/NaverWorks.svg"/>
			<img src="/assets/media/logos/landing.svg" />
			<img src="/assets/media/cat/cat.png" alt="">
			<img src="/assets/media/cat/dog.jpg" alt="">
			<img src="/assets/media/cat/라쿤.jpg" alt="">
			<img src="/assets/media/cat/pig.jpg" alt="">
			<img src="/assets/media/cat/cat2.jpg" alt="">
			<img src="/assets/media/cat/mi.jpg" alt="">
		</div>
	</div>

	<div class="d-flex justify-content-center text-center">
		<h2 class="display-4 fw-bold"><br>네이버웍스의<br>다양한 제품을 만나보세요</h2>
	</div>
	
	<!-- 책 사진 -->
	<div class="flex-grow-1 overflow-auto text-center">
		<div class="d-flex mb-10 mx-auto px-5 gap-10">
			<img src="/assets/media/books/2.png" class="w-100 h-300px">
			<img src="/assets/media/books/3.png" class="w-100 h-300px">
			<img src="/assets/media/books/4.png" class="w-100 h-300px">
			<img src="/assets/media/books/5.png" class="w-100 h-300px">
			<img src="/assets/media/books/12.png" class="w-100 h-300px">
			<img src="/assets/media/books/7.png" class="w-100 h-300px">
			<img src="/assets/media/books/8.png" class="w-100 h-300px">
		</div>
	
	
	</div>
	<div class="flex-grow-1 overflow-auto px-5">
        <div class="d-flex h-600px mt-10 mb-3">

          <div class="flex-fill d-flex flex-column">

            <div class="d-flex h-300px mb-2" style="gap: 5px;">
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center w-150px shadow" style="border-radius: 10px;">
				<img src="/assets/media/books/1.png" class="w-100 h-100">
              </div>
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center w-150px shadow" style="border-radius: 10px;">
                <img src="/assets/media/books/6.png" class="w-100 h-100">
              </div>
            </div>
            
            <div class="d-flex h-300px" style="gap: 5px;">
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center w-150px shadow" style="border-radius: 10px;">
                <img src="/assets/media/books/10.png" class="w-100 h-100">
              </div>
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center w-150px shadow" style="border-radius: 10px;">
                <img src="/assets/media/books/11.png" class="w-100 h-100">
              </div>
            </div>
            
          </div>

        </div>
	</div>
	
</div>


</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);
const router = useRouter()


onMounted(() => {
  console.log(`HomeView : onMounted 호출됨`);

  title.value = 'NAVER WORKS';

})



</script>

<style scoped>
.menu-link {
  transition: color 0.2s;
}
.menu-link:hover, .menu-link:focus {
  color: #009ef7 !important; /* 기존 메뉴의 파란색 */
}

.logo-slider {
  overflow: hidden;
  white-space: nowrap;
  position: relative;
}

.logo-track {
  display: inline-block;
  animation: scroll 20s linear infinite;
}

.logo-track img {
  height: 50px;
  margin: 0 40px;
}

@keyframes scroll {
  0% {
    transform: translateX(0%);
  }
  100% {
    transform: translateX(-50%);
  }
}
</style>
