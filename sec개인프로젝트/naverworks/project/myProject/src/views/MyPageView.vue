<template>
<div style="padding-top: 74px; text-align: center;">
</div>
<div class="d-flex flex-column justify-centent-center align-items-center mt-20" style="margin-bottom: 40px;">
        <h1 class="mb-4">정보 수정</h1>

        <div class="form-group mb-3">
                <label>이메일</label>
                <input v-model="email" type="text" class="form-control" placeholder="아이디(이메일)를 입력하세요" required/>
        </div>

        <span>
                <button @click="check()" class="btn btn-link" style="margin-right: 70px;">확인</button>
                <button @click="router.push('/')" class="btn btn-link">취소</button>
        </span>
        <div v-if="errorMessage" class="text-danger text-center fw-bold">{{ errorMessage }}</div>
</div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

import { useLoginStore } from '@/stores/logined';
const loginStore = useLoginStore()
const { logined } = storeToRefs(loginStore)

const errorMessage = ref('')

onMounted(() => {
        title.value = '마이페이지'

        if(!logined.value){
                alert('로그인해주세요')
                router.push('/login')
        }
})

import { api } from '@/util/api';

async function check() {
        console.log('check함수 실행')

        if(!email.value) {
                alert('이메일을 입력해주세요')
                return;
        }

        try{
                const response = await api.post('/check', {
                        email: email.value
                })

                console.log(`응답 : ${JSON.stringify(response.data)}`)

                router.push(`/mypage2?email=${email.value}`)

        }catch(err){
                errorMessage.value = "이메일이 일치하지 않습니다."
        }
}

        


const router = useRouter();
const email = ref('')


</script>

<style scoped>


</style>
