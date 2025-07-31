<template>

  <div>

    <div>
      <h1>메뉴 화면</h1>
    </div>

    <div>
      <button @click="goToHome()">홈 화면으로</button>
    </div>
    
  </div>

</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

function goToHome() {
  router.push('/');
}

</script>

<style scoped>



</style>