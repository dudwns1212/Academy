<template>
  <div class="bg-light-info">
    <h1>홈 화면</h1>
  </div>
</template>

<script setup>

import { ref, onMounted } from 'vue'

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

onMounted(() => {
  console.log(`HomeView : onMounted 호출됨`);

  title.value = '홈';

})

</script>

<style scoped>

</style>