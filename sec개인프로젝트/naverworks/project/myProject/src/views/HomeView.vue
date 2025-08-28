<template>
<div class="flex-grow-1 d-flex flex-column justify-content-center align-items-center text-center overflow-auto">
		
	<!-- 자동으로 넘어가는 슬라이드 -->
	<div class="overlay" style="overflow: hidden;">

		<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel" style="margin-top: 100px;">
		
			<!-- Slide 1 -->
			<div class="carousel-item active">
				<div class="d-flex flex-column px-5 py-5">
				<!-- 텍스트 -->
				<div class="d-flex flex-column justify-content-center text-center" style="width: auto;">
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
	<div class="d-flex gap-5 px-5 mt-5" style="overflow-x: auto;">
		<div v-for="(item, index) in productList" :key="item.id" class="d-flex text-center gap-5 px-5 mt-5" >
			<div class="d-flex flex-column shadow">
				<div>
					<img :src="item.path" class="w-100 h-100" @click="showDetailProduct(item.id)">
				</div>
				<div class="d-flex justify-content-between" style="width: 220px;">
					<span class="fw-bold">{{ item.name }}</span>
					<span class="fw-bold">{{ item.genre }}</span>
					<span>
						<img src="/images/star.png" class="w-15px">
						<span class="fw-bold" style="color: gold;">{{ item.lating }}</span>
					</span>
	
				</div>
			</div>
		</div>

	</div>
	<div class="flex-grow-1 px-5">
        <div class="d-flex h-1000px mt-10 mb-3">

          <div class="flex-fill d-flex flex-column">

            <div class="d-flex text-center h-500px mb-2" style="gap: 5px;">
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center shadow" style="border-radius: 10px;">
				<img src="/assets/media/books/1.png" class="w-100 h-100">
              </div>
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center shadow" style="border-radius: 10px;">
                <img src="/assets/media/books/6.png" class="w-100 h-100">
              </div>
            </div>
            
            <div class="d-flex h-500px" style="gap: 5px;">
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center shadow" style="border-radius: 10px;">
                <img src="/assets/media/books/10.png" class="w-100 h-100">
              </div>
              <div class="flex-fill d-flex flex-column align-items-center justify-content-center shadow" style="border-radius: 10px;">
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

import { apiProduct } from '@/util/api_product';

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);
const router = useRouter()

import { useTextStore } from '@/stores/text'
const textStore = useTextStore()
const { selectedIndex } = storeToRefs(textStore)

const productList = ref([])


onMounted(() => {
  console.log(`HomeView : onMounted 호출됨`);

  title.value = 'NAVER WORKS';

  requestProductList()

})

async function requestProductList() {
	console.log(`requestProductList 함수 호출`)

	try{

		const response = await apiProduct.post('/list-all',{})

		console.log(`응답 : ${JSON.stringify(response.data)}`)

		productList.value = response.data.data.data

	}catch(err) {
		console.error(`에러 -> ${err}`)
	}

	
}

function showDetailProduct(index) {

	selectedIndex.value = index
	
	router.push('/product',{})
}



</script>

<style scoped>
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
