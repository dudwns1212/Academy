<template>
  <div class="d-flex justify-content-center align-items-center h-100 bg-light-danger">
    <h1>로그인 화면</h1>

    <div>
      <button class="btn btn-primary" @click="login()">로그인</button>
    </div>
  </div>
</template>

<script setup>

import { useRouter } from 'vue-router'
const router = useRouter();

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { fullScreen } = storeToRefs(appStore);

function login() {
  goToHome();
}

function goToHome() {
  //전체화면 모드로 변경하기
  fullScreen.value = false;

  router.push('/')
}
</script>

<style scoped>

</style>