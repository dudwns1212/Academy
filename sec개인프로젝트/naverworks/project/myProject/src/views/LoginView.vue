<template>
<div style="padding-top: 74px; text-align: center;">
	<div class="d-flex flex-column justify-content-center align-items-center">
			<h1 class="display-4">로그인</h1>
			<br>
			<br>
			<h3 class="fw-normal">로그인 페이지 입니다.</h3>
	</div>
</div>
<!-- metronic 로그인 페이지 부분 -->
<body id="kt_body" class="app-blank bgi-size-cover bgi-attachment-fixed bgi-position-center">
		<!--begin::Root-->
		<div class="d-flex flex-column flex-root" id="kt_app_root">
			<!--begin::Authentication - Sign-in -->
			<div class="d-flex flex-column flex-lg-row flex-column-fluid">
				<!--begin::Aside-->
				<div class="d-flex flex-lg-row-fluid">
					<!--begin::Content-->
					<div class="d-flex flex-column flex-center pb-0 pb-lg-10 p-10 w-100">
						
					</div>
					<!--end::Content-->
				</div>
				<!--begin::Aside-->
				<!--begin::Body-->
				<div class="d-flex flex-column-fluid flex-lg-row-auto justify-content-center justify-content-lg-end p-20">
					<!--begin::Wrapper-->
					<div class="bg-body d-flex flex-column flex-center rounded-4 w-md-600px p-10">
						<!--begin::Content-->
						<div class="d-flex flex-center flex-column align-items-stretch h-lg-100 w-md-400px">
							<!--begin::Wrapper-->
							<div class="d-flex flex-center flex-column flex-column-fluid pb-15 pb-lg-20">
								<!--begin::Form-->
								<form class="form w-100" style="margin-top: -120px;" novalidate="novalidate" id="kt_sign_in_form" data-kt-redirect-url="index.html" action="#" @submit.prevent="handleLogin">
									<!--begin::Heading-->
									<div class="text-center mb-11">
										<!--begin::Title-->
										<h1 class="text-gray-900 fw-bolder mb-3">Sign In</h1>
										<!--end::Title-->
									</div>
									<!--begin::Heading-->
									<!--begin::Login options-->
									<div class="row g-3 mb-9">
										<!--begin::Col-->
										<div class="col-md-6">
											<!--begin::Google link=-->
											<a href="#" class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
											<img alt="Logo" src="/assets/media/svg/brand-logos/google-icon.svg" class="h-15px me-3" />Sign in with Google</a>
											<!--end::Google link=-->
										</div>
										<!--end::Col-->
										<!--begin::Col-->
										<div class="col-md-6">
											<!--begin::Google link=-->
											<a href="#" class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
											<img alt="Logo" src="/assets/media/svg/brand-logos/apple-black.svg" class="theme-light-show h-15px me-3" />
											<img alt="Logo" src="/assets/media/svg/brand-logos/apple-black-dark.svg" class="theme-dark-show h-15px me-3" />Sign in with Apple</a>
											<!--end::Google link=-->
										</div>
										<!--end::Col-->
									</div>
									<!--end::Login options-->
									<!--begin::Separator-->
									<div class="separator separator-content my-14">
										<span class="w-125px text-gray-500 fw-semibold fs-7">Or with email</span>
									</div>
									<!--end::Separator-->
									<!--begin::Input group=-->
									
                                    <div class="fv-row mb-8">
                                    <input v-model="email" type="text" placeholder="Email" class="form-control bg-transparent" required/>
                                    </div>

                                    <div class="fv-row mb-3">
                                    <input v-model="password" type="password" placeholder="Password" class="form-control bg-transparent" required/>
                                    </div>

                                    <div class="d-grid mb-10">
                                    <button type="submit" class="btn btn-primary">
                                        <span class="indicator-label">로그인</span>
                                    </button>
                                    </div>

                                    <div v-if="errorMessage" class="text-danger text-center fw-bold">{{ errorMessage }}</div>

                                    <div class="text-gray-500 text-center fw-semibold fs-6">
                                    계정이 없으신가요? <a href="/register" class="link-primary">회원가입</a>
                                    </div>
                                    
								</form>
								<!--end::Form-->
							</div>
							<!--end::Wrapper-->

						</div>
						<!--end::Content-->
					</div>
					<!--end::Wrapper-->
				</div>
				<!--end::Body-->
			</div>
			<!--end::Authentication - Sign-in-->
		</div>
		<!--end::Javascript-->
	</body>
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
  console.log(`LoginView : onMounted 호출됨`);

  title.value = '로그인';

})

// API 객체화를 사용하기 위해 import
import { api } from '@/util/api'

const email = ref('')
const password = ref('')
const errorMessage = ref('')

async function handleLogin() {
  errorMessage.value = ''  // 로그인 실패시 남아있는 에러 메시지를 초기화
  // 안하면 오류가 쌓여서 오류 발생함
  try {
    const response = await api.post('/login', {
      email: email.value,
      password: password.value
    });

	console.log(`응답 -> ${JSON.stringify(response.data)}`);

    // 로그인 성공 시 사용자 정보를 localStorge에 user라는 키값으로 저장하고 홈으로 이동
    // user는 객체이므로 문자열로 변환하여 저장
    // 나중에 get으로 불러올 때는 JSON.parse로 복원
    // 로그인 시 새로고침이 되어야 정보가 기억돼서 window.location을 사용
    localStorage.setItem('user', JSON.stringify(response.data.user));
    window.location.href = '/'
    
  } catch (error) {
    // 서버가 401 상태 코드를 보내면 여기로 옴
    if (error.response.status == 401) {
      errorMessage.value = '잘못된 아이디 또는 비밀번호입니다'; 
    } else {
		errorMessage.value = '서버 오류입니다'
	}
  }
}
</script>

<style scoped>


</style>