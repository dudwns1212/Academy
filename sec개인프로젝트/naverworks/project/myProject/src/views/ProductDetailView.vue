<template>
<div style="padding-top: 85px; text-align: center;">
</div>
<div class="d-flex flex-column align-items-center">

    <h1 v-if="selectedIndex==-1">홈에서 제품을 선택해주세요</h1>

    <div class="d-flex justify-content-between mb-5 shadow p-4" style="width: 330px; border-radius: 10px;">
        <span class="fs-4 fw-bold">{{ contentName }}</span>
        <span class="badge badge-light-primary">{{ contentGenre }}</span>
    </div>
    <div class="mb-10">
        <img :src="path" style="width: 330px; border-radius: 10px;">
        <div class="d-flex justify-content-between" style="width: 330px;">
            <div>
                <label class="fs-3 fw-bold">평점 : </label>
                <span class="fs-3 fw-bold" style="color: yellowgreen;">{{ contentLating }}</span>
            </div>
            <div>
                <span class="fs-4 fw-light">구매처 :  </span>
                <span class="fs-4 fw-light text-decoration-underline">LX도서관</span>
            </div>
    
        </div>
    </div>

    <button class="btn btn-light-primary  mb-15" @click="router.push('/')">뒤로가기</button>
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

import { useTextStore } from '@/stores/text'
const textStore = useTextStore()
const { selectedIndex } = storeToRefs(textStore)

import { apiProduct } from '@/util/api_product';

const router = useRouter()

const contentName = ref('')
const contentGenre = ref('')
const path = ref('') 
const contentLating = ref('')

onMounted(() => {
  console.log(`CallView : onMounted 호출됨`);

  title.value = "제품 상세"
  
  requestSelectedProduct();

})


async function requestSelectedProduct() {
    console.log(`requestSelectedContent 함수 호출됨`)

    try {

        const response = await apiProduct.post('/read', {
            id: selectedIndex.value
        })

        console.log(`응답 -> ${JSON.stringify(response.data)}`)

        const result = response.data.data.data[0]

        console.log('이건 : ' + JSON.stringify(result.title))

        
        contentName.value = result.name
        path.value = result.path
        contentGenre.value = result.genre
        contentLating.value = result.lating



    }catch(err) {
        console.log(`에러발생 -> ${err}`)
    }
}


</script>

<style scoped>


</style>
