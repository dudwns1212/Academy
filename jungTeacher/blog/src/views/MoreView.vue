<template>
  <div class="bg-light-success">
    <h1>더보기 화면</h1>
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
  console.log(`MoreView : onMounted 호출됨`);

  title.value = '더보기';

})
</script>

<style scoped>

</style>