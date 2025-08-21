<template>
  <div style="padding-top: 74px; text-align: center;">
	  <div class="d-flex flex-column justify-content-center align-items-center" style="background-color: whitesmoke; height: 300px;width: 1200px;">
			  <h1 class="display-4">회원가입</h1>
			  <br>
			  <br>
		  	<h3 class="fw-normal">회원가입 페이지 입니다.</h3>
	  </div>
  </div>
  <div class="d-flex flex-column justify-centent-center align-items-center mt-20" style="margin-bottom: 40px;">
    <h1 class="mb-4">회원가입</h1>

    <div class="form-group mb-3">
      <label>이름</label>
      <input v-model="name" type="text" class="form-control" placeholder="이름을 입력하세요" />
    </div>

    <div class="form-group mb-3">
      <label>나이</label>
      <input v-model.number="age" type="number" class="form-control" placeholder="나이를 입력하세요" />
    </div>

    <div class="form-group mb-3">
      <label>전화번호</label>
      <input v-model="mobile" type="text" class="form-control" placeholder="전화번호를 입력하세요" />
    </div>

    <div class="form-group mb-3">
      <label>아이디 (이메일)</label>
      <input v-model="email" type="email" class="form-control" placeholder="아이디(이메일)를 입력하세요" />
    </div>

    <div class="form-group mb-4">
      <label>비밀번호</label>
      <input v-model="password" type="password" class="form-control" placeholder="비밀번호를 입력하세요" />
    </div>

    <span>
      <button @click="router.push('/login')" class="btn btn-link" style="margin-right: 50px;">로그인</button>
      <button @click="register()" class="btn btn-link">회원가입</button>
    </span>

    <div class="mt-3 text-success" style="margin-top: 20px;" v-if="successMessage">{{ successMessage }}</div>
    
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const router = useRouter();
const name = ref('')
const age = ref(null)
const mobile = ref(null)
const email = ref('')
const password = ref('')

const successMessage = ref('')
const errorMessage = ref('')

async function register() {
  successMessage.value = ''
  errorMessage.value = ''

  try {
    const res = await axios.post('http://localhost:7001/auth/register', {
      name: name.value,
      email: email.value,
      password: password.value,
      age: age.value,
      mobile: mobile.value
    })
    //오류 없이 성공하면 데이터가 데이터베이스에 저장되고 화면에 성공메세지 나타냄
    successMessage.value = res.data.message

  // 벡에서 에러가 발생하면 err메세지를 리턴받아 alert함수로 경고창 띄움
  } catch (err) {
    if (err.response) {
      errorMessage.value = err.response.data.message
    } else {
      errorMessage.value = '회원가입 중 오류 발생'
    }
    alert(`회원가입 중 오류가 발생했습니다. -> ${errorMessage.value}`)
    return;
  }
}
</script>

<style scoped>

</style>
