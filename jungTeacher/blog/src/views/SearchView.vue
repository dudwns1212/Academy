<template>
  <div class="bg-light-primary">
    <h1>찾기 화면</h1>
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
  console.log(`SearchView : onMounted 호출됨`);

  title.value = '검색';

})
</script>

<style scoped>

</style>