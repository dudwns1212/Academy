<template>
<div style="padding-top: 74px; text-align: center;">
        <div class="d-flex flex-column justify-content-center align-items-center" style="background-color: whitesmoke; height: 300px;width: 1300px;">
                <h1 class="display-4">내 정보 </h1>
                <br>
                <br>
                <h3 class="fw-normal">여기에서 개인정보를 수정하세요!</h3>
        </div>
</div>
<div class="d-flex flex-column justify-centent-center align-items-center mt-20" style="margin-bottom: 40px;">
        <h1 class="mb-4">정보 수정</h1>

        <div class="form-group mb-3">
                <span style="display: flex; align-items: center;">
                        <input v-model="name" type="text" class="form-control" style="margin-right: 10px; width: auto;" />
                        <button class="btn btn-pramary" @click="updateName()">변경</button>
                </span>       
        </div>

        <div class="form-group mb-3">
                <span style="display: flex; align-items: center;">
                        <input v-model="age" type="number" class="form-control" style="margin-right: 10px; width: auto;" />
                        <button class="btn btn-pramary" @click="updateAge()">변경</button>
                </span>       
        </div>

        <div class="form-group mb-3">
                <span style="display: flex; align-items: center;">
                        <input v-model="mobile" type="text" class="form-control" style="margin-right: 10px; width: auto;" />
                        <button class="btn btn-pramary" @click="updateMobile()">변경</button>
                </span>       
        </div>

        <div class="form-group mb-3">
                <span style="display: flex; align-items: center;">
                        <input v-model="password" type="text" class="form-control" placeholder="변경할 비밀번호를 입력하세요." style="margin-right: 10px; width: auto;" />
                        <button class="btn btn-pramary" @click="updatePassword()">변경</button>
                </span>       
        </div>

        <button @click="router.push('/')" class="btn btn-link">취소</button>

        <div class="mt-3 text-success" style="margin-top: 20px;" v-if="successMessage">{{ successMessage }}</div>
</div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import axios from 'axios'
import { useRouter, useRoute } from 'vue-router'
const route = useRoute();
const router = useRouter();

const email = route.query.email
console.log(`받은 이메일 ${email}`);

const name = ref('')
const age = ref('')
const mobile = ref('')
const password = ref('')

// localStroage에 저장되어있는 현재 나의 정보를 가져와서 input상자에 넣기(현재 나의 정보보기)
// 비밀번호는 보안이니까 제외
onMounted(() => {
        const saved = localStorage.getItem('user')
        if (saved) {
                const user = JSON.parse(saved)
                name.value = user.name
                age.value = user.age
                mobile.value = user.mobile
        }
})

const successMessage = ref('')
const errorMessage = ref('')

async function updateName() {
  successMessage.value = ''
  errorMessage.value = ''

  try {
    const rows = await axios.post(`http://localhost:7001/auth/updateName`, {
      name: name.value,
      email: email
    })

    successMessage.value = rows.data.message

    // 이름을 변경하면 상단 헤더의 username을 바꾸기위해 localStorge값을 바꿔줌
    let changeName = localStorage.getItem('user');
    changeName = JSON.parse(changeName)
    changeName.name = name.value
    localStorage.setItem('user', JSON.stringify(changeName))
    
    // 그리고 새로고침해야 적용
    window.location.reload();

    } catch (err) {
    if (err.response) {
      errorMessage.value = err.response.data.message
    } else {
      errorMessage.value = '정보수정 중 오류 발생'
    }
    alert(`정보수정 중 오류가 발생했습니다. -> ${errorMessage.value}`)
    return;
  }
}

async function updateAge() {
  successMessage.value = ''
  errorMessage.value = ''

  try {
    const rows = await axios.post(`http://localhost:7001/auth/updateAge`, {
      age: age.value,
      email: email
    })

    successMessage.value = rows.data.message


    } catch (err) {
    if (err.response) {
      errorMessage.value = err.response.data.message
    } else {
      errorMessage.value = '정보수정 중 오류 발생'
    }
    alert(`정보수정 중 오류가 발생했습니다. -> ${errorMessage.value}`)
    return;
  }
}

async function updateMobile() {
  successMessage.value = ''
  errorMessage.value = ''

  try {
    const rows = await axios.post(`http://localhost:7001/auth/updateMobile`, {
      mobile: mobile.value,
      email: email
    })

    successMessage.value = rows.data.message


    } catch (err) {
    if (err.response) {
      errorMessage.value = err.response.data.message
    } else {
      errorMessage.value = '정보수정 중 오류 발생'
    }
    alert(`정보수정 중 오류가 발생했습니다. -> ${errorMessage.value}`)
    return;
  }
}

async function updatePassword() {
  successMessage.value = ''
  errorMessage.value = ''

  try {
    const rows = await axios.post(`http://localhost:7001/auth/updatePassword`, {
      password: password.value,
      email: email
    })

    successMessage.value = rows.data.message


    } catch (err) {
    if (err.response) {
      errorMessage.value = err.response.data.message
    } else {
      errorMessage.value = '정보수정 중 오류 발생'
    }
    alert(`정보수정 중 오류가 발생했습니다. -> ${errorMessage.value}`)
    return;
  }
}
</script>

<style scoped>


</style>
