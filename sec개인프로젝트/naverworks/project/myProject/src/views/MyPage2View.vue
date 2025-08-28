<template>
<div style="padding-top: 74px; text-align: center;">
</div>
<div class="d-flex flex-column justify-content-center align-items-center mt-20" style="margin-bottom: 40px;">
  <h1 class="mb-4">정보 수정</h1>

  <div class="form-group mb-3">
          <label>이름</label>
          <span style="display: flex; align-items: center;">
                  <input v-model="name" type="text" class="form-control" style="margin-right: 10px; width: auto;" />
          </span>       
  </div>

  <div class="form-group mb-3">
          <label>나이</label>
          <span style="display: flex; align-items: center;">
                  <input v-model="age" type="number" class="form-control" style="margin-right: 10px; width: auto;" />
          </span>       
  </div>

  <div class="form-group mb-3">
          <label>연락처</label>
          <span style="display: flex; align-items: center;">
                  <input v-model="mobile" type="text" class="form-control" style="margin-right: 10px; width: auto;" />
          </span>       
  </div>

  <div class="form-group mb-3">
          <label>비밀번호</label>
          <span style="display: flex; align-items: center;">
                  <input v-model="password" type="password" class="form-control" placeholder="변경할 비밀번호를 입력하세요." style="margin-right: 10px; width: auto;" />
          </span>       
  </div>
  <div v-if="successMessage" class="text-success">{{ successMessage }}</div>
</div>
<div class="d-flex justify-content-center align-items-center gap-20">
  <button @click="updateUserInfo()" class="btn btn-light-primary ">저장</button>
  <button @click="router.push('/')" class="btn btn-light-danger">취소</button>
</div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'

const route = useRoute()
const router = useRouter()

//전에 마이페이지에서 이메일 받아오기
const email = route.query.email

import { storeToRefs } from 'pinia'

import { useAppStore } from '@/stores/app'
const appStore = useAppStore()
const { title } = storeToRefs(appStore)

import { useLoginStore } from '@/stores/logined'
const loginStore = useLoginStore()
const { logined } = storeToRefs(loginStore)

import { api } from '@/util/api'

const name = ref('')
const age = ref('')
const mobile = ref('')
const password = ref('')

onMounted(() => {
  title.value = '정보 수정'

  requestUserInfo()

})

async function requestUserInfo() {
  try {
    const response = await api.post('/check', {
        email: email
      })

    const user = response.data.data.data[0]
    console.log('사용자 정보: ', user)
    
    name.value = user.name
    age.value = user.age
    mobile.value = user.mobile
    password.value = user.password

  } catch (error) {
    console.error('사용자 정보 요청 실패:', error)
  }
}

const successMessage = ref('')

async function updateUserInfo() {
  try {
    const response = await api.post('/modify', {
      email: email,
      name: name.value,
      age: age.value,
      mobile: mobile.value,
      password: password.value
    })

    console.log('사용자 정보 수정 결과: ', response.data)

    localStorage.setItem('user', JSON.stringify(response.data.data))
    
    //지금 문제가 성공 메세지가 새로고침되면 사라짐 너무 빨리 사라짐
    successMessage.value = '사용자 정보가 성공적으로 수정되었습니다.'

    window.location.reload()

  } catch (error) {
    console.error('사용자 정보 수정 실패:', error)
  }
}

</script>

<style scoped>
</style>