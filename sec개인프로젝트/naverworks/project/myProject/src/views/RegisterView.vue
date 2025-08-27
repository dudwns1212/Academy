<template>
  <div style="padding-top: 74px; text-align: center;">
  </div>
  <div class="d-flex flex-column justify-centent-center align-items-center mt-20">
    <h1 class="mb-4">회원가입</h1>
    <form @submit.prevent="register()" class="text-center">
      <div class="form-group mb-3">
        <label>이름</label>
        <input v-model="name" type="text" class="form-control" placeholder="이름을 입력하세요" required/>
      </div>

      <div class="form-group mb-3">
        <label>나이</label>
        <input v-model="age" type="number" class="form-control" placeholder="나이를 입력하세요" required/>
      </div>

      <div class="form-group mb-3">
        <label>전화번호</label>
        <input v-model="mobile" type="text" class="form-control" placeholder="전화번호를 입력하세요" required/>
      </div>

      <div class="form-group mb-3">
        <label>아이디 (이메일)</label>
        <input v-model="email" type="email" class="form-control" placeholder="아이디(이메일)를 입력하세요" required/>
      </div>

      <div class="form-group mb-4">
        <label>비밀번호</label>
        <input v-model="password" type="password" class="form-control" placeholder="비밀번호를 입력하세요" required/>
      </div>
      <button type="submit" class="btn btn-link">회원가입</button>
      <button type="button" @click="router.push('/login')" class="btn btn-link ms-10">로그인</button>
    </form>
    <div class="mt-3 text-success" style="margin-top: 20px;" v-if="successMessage">{{ successMessage }}</div>
    <div class="mt-3 text-danger" style="margin-top: 20px;" v-if="errorMessage">{{ errorMessage }}</div>
      

    
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

// API 객체화를 사용하기 위해 import
import { api } from '@/util/api'

onMounted(() => {
  console.log(`RegisterView : onMounted 호출됨`);

  title.value = '회원가입';
})

const router = useRouter();
const name = ref('')
const age = ref('')
const mobile = ref('')
const email = ref('')
const password = ref('')

const successMessage = ref('')
const errorMessage = ref('')

async function register() {
  console.log('register 함수 실행 시작');
  
  successMessage.value = ''
  errorMessage.value = ''

  try {
    console.log('회원가입 API 호출 시작...');
    
    const response = await api.post('/register', {
      name: name.value,
      email: email.value,
      password: password.value,
      age: age.value,
      mobile: mobile.value
    });
    console.log(`응답 -> ${JSON.stringify(response.data)}`);
    
    // 성공 시 메시지 표시
    successMessage.value = "회원가입 성공!";

  } catch (err) {
      errorMessage.value = '회원가입 중 오류가 발생했습니다'
    }
}
</script>

<style scoped>

</style>