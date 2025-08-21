<template>
<div style="padding-top: 74px; text-align: center;">
        <div class="d-flex flex-column justify-content-center align-items-center" style="background-color: whitesmoke; height: 300px;width: 1200px;">
                <h1 class="display-4">내 정보 </h1>
                <br>
                <br>
                <h3 class="fw-normal">여기에서 개인정보를 수정하세요!</h3>
        </div>
</div>
<div class="d-flex flex-column justify-centent-center align-items-center mt-20" style="margin-bottom: 40px;">
        <h1 class="mb-4">정보 수정</h1>

        <div class="form-group mb-3">
                <label>이메일</label>
                <input v-model="email" type="text" class="form-control" placeholder="아이디(이메일)를 입력하세요" />
        </div>

        <span>
                <button @click="check()" class="btn btn-link" style="margin-right: 70px;">확인</button>
                <button @click="router.push('/')" class="btn btn-link">취소</button>
        </span>
</div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter();
const email = ref('')

const savedEmail = JSON.parse(localStorage.getItem('user')); 
// email값이 웹에 저장되어있는(로그인된) email과 같다면 page2로 이동
function check() {
        console.log(savedEmail);
        if(savedEmail.email == email.value) {
                router.push(`/mypage2?email=${email.value}`);
        } else {
                alert('이메일이 일치하지 않습니다.');
        }
}

</script>

<style scoped>


</style>
