<template>
  	<div class="app-page flex-column flex-column-fluid" id="kt_app_page">
		<!--begin::Wrapper-->
		<div class="app-wrapper flex-column flex-row-fluid" id="kt_app_wrapper">
			<!--begin::Main-->
			<div class="app-main flex-column flex-row-fluid" id="kt_app_main">
				<!--begin::Content wrapper-->
				<div class="d-flex flex-column flex-column-fluid">
					<!--begin::Content-->
					<div id="kt_app_content" class="app-content flex-column-fluid">
						<!--begin::Content container-->
						<div id="kt_app_content_container" class="app-container container-fluid">
							<!--begin::About card-->
							<div class="">
								<!--begin::Body-->
								<div class="card-body p-lg-17" style="padding: 0;">
									<!--begin::About-->
									<div class="mb-18">
										<!--begin::Wrapper-->
										<div class="mb-10">
											<!--begin::Top-->
											
											<!-- 자동으로 넘어가는 슬라이드 -->
											<div class="overlay" style="width: 1410px; margin-left: 400px; height: 610px;">

												<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
													<div class="carousel-inner">

													<!-- Slide 1 -->
													<div class="carousel-item active">
														<div class="d-flex align-items-center justify-content-between px-5 py-5">
														<!-- 텍스트 -->
														<div class="w-100">
															<h2 class="display-4 fw-bold">일이 쉬워진다<br>네이버웍스</h2>
															<p class="lead text-muted mt-4">
															네이버웍스는 네이버의 편리함과 기술, 일하는 방식을 담은 통합 업무 플랫폼입니다.
															소통과 협업, 경영지원을 하나의 플랫폼에서 활용하여 생산성을 높여보세요.
															</p>
															<div class="mt-4">
															<a class="btn btn-dark btn-lg me-3" href="http://localhost:5173/login">무료로 시작하기</a>
															<a class="btn btn-outline-dark btn-lg" href="http://localhost:5173/login">도입 문의하기</a>
															</div>
														</div>
														<!-- 이미지 -->
														<div class="w-100 text-end">
															<img src="/assets/media/illustrations/dozzy-1/4.png" class="d-block" style="max-height: 500px;" />
														</div>
														</div>
													</div>

													<!-- Slide 2 -->
													<div class="carousel-item">
														<div class="d-flex align-items-center justify-content-between px-5 py-5">
														<div class="w-100">
															<h2 class="display-4 fw-bold">도입부터 기술지원까지<br>파트너 찾기</h2>
															<p class="lead text-muted mt-4">
															네이버웍스는 도입 컨설팅부터 교육, 시스템 연동, 기술 지원 등을 지원하는<br>
															파트너 프로그램을 운영하고 있습니다. 파트너사와 함께 네이버웍스를 시작해보세요.
															</p>
															<div class="mt-4">
															<a class="btn btn-dark btn-lg me-3" href="http://localhost:5173/login">프로그램 보기</a>
															<a class="btn btn-outline-dark btn-lg" href="http://localhost:5173/login">파트너 찾기</a>
															</div>
														</div>
														<div class="w-100 text-end">
															<img src="/assets/media/illustrations/sigma-1/16.png" class="d-block" style="max-height: 500px;" />
														</div>
														</div>
													</div>

													</div>													
												</div>                                                                       
																		
											</div>

											<!-- 자동으로 움직이는 로고들 애니메이션 -->
											<div class="logo-slider" style="width: 1920px; margin-bottom: 100px;">
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


											<div>
												<h2 class="display-4 fw-bold text-center"><br>네이버웍스의<br>다양한 제품을 만나보세요</h2>
											</div>

										</div>

										<!--end::Description-->
									</div>
									<!--end::About-->
									<!-- 책 사진 -->
									<div class="card bg-light mb-18">
										<!--begin::Body-->
										<div class="card-body py-15">
											<!--begin::Wrapper-->
											<div class="d-flex flex-center">
												<!--begin::Items-->
												<div class="d-flex flex-center flex-wrap mb-10 mx-auto gap-5">
												<span>
													<img src="/assets/media/books/1.png" alt="" style="margin-right: 20px;">
													<img src="/assets/media/books/6.png" alt="" style="margin-right: 20px;">
													<img src="/assets/media/books/10.png" alt="">
												</span>
												</div>

											</div>
											<!--end::Wrapper-->

										</div>
										<!--end::Body-->
									</div>

								</div>
								<!--end::Body-->
							</div>
							<!--end::About card-->
						</div>
						<!--end::Content container-->
					</div>
					<!--end::Content-->
				</div>
				<!--end::Content wrapper-->
			</div>
			<!--end:::Main-->
		</div>
		<!--end::Wrapper-->
	</div>

</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()


</script>

<style scoped>

#kt_app_page {
	margin-left: -525px;
	

	
}
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
