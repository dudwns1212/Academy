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

function login() {
  goToHome();
}

function goToHome() {
  router.push('/')
}
</script>

<style scoped>

</style>