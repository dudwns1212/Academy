<template>
<div style="padding-top: 74px; text-align: center;">
        <div class="d-flex flex-column justify-content-center align-items-center">
                <h1 class="display-4">제품 정보</h1>
                <br>
                <br>
                <h3 class="fw-normal">제품을 손쉽게 사용하도록 정보를 드립니다.</h3>
        </div>
        <br>
        <a href="https://www.flaticon.com/kr/free-icons/-" title="채팅 거품 아이콘">채팅 거품 아이콘 제작자: Freepik - Flaticon</a>
</div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);
const router = useRouter()


onMounted(() => {
  console.log(`ProductView : onMounted 호출됨`);

  title.value = '제품';

})

</script>

<style scoped>


</style>
