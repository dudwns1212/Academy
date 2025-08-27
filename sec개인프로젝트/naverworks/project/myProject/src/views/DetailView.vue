<template>
<div style="padding-top: 85px; text-align: center;">
</div>
<div class="d-flex flex-column align-items-center">
    <!-- 안에 contentTitle이랑 contentCategory 양옆으로 하고싶은데 왜 between이 안먹지? -->
    <div class="d-flex justify-content-between mb-5" style="width: 330px;">
        <span class="fs-4 fw-bold">{{ contentTitle }}</span>
        <span class="badge badge-light-primary">{{ contentCategory }}</span>
    </div>
    <div class="mb-10">
        <img :src="path" style="width: 330px;">
    </div>
    <div>
        <!-- 안에 글씨가 너무 오른쪽 왼쪽 벽이랑 붙어있어서 이거 css로 수정해야됨 -->
        <textarea class="fs-2 fw-light" rows="8" style="width: 330px;">
            {{ coments }}
        </textarea>
    </div>
    <div class="d-flex gap-20">
        <button class="btn btn-light-primary" @click="editContent()">수정</button>
        <button class="btn btn-light-danger" @click="deleteContent()">삭제</button>
    </div>
    <button class="btn btn-light-secondary mt-10 mb-15" @click="router.push('/call')">뒤로가기</button>
</div>


</template>

<script setup>
import { ref, onMounted } from 'vue'

import { useRouter } from 'vue-router';

const router = useRouter()
//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

import { useTextStore } from '@/stores/text'
const textStore = useTextStore()
const { selectedIndex, mode } = storeToRefs(textStore)

import { apiText } from '@/util/api_text';

const contentTitle = ref('')
const coments = ref('')
const path = ref('')
const contentCategory = ref('')

onMounted(() => {
  console.log(`CallView : onMounted 호출됨`);

  title.value = "상세정보"
  
  requestSelectedContent();

})



async function requestSelectedContent() {
    console.log(`requestSelectedContent 함수 호출됨`)

    try {

        const response = await apiText.post('/read', {
            id: selectedIndex.value
        })

        console.log(`응답 -> ${JSON.stringify(response.data)}`)

        const result = response.data.data.data[0]

        console.log('이건 : ' + JSON.stringify(result.title))

        
        contentTitle.value = result.title
        coments.value = result.coments
        path.value = result.path
        contentCategory.value = result.category



    }catch(err) {
        console.log(`에러발생 -> ${err}`)
    }
}
//edit으로 넘어갈때 selectedIndex값을 가지고 가야함
async function editContent() {
    mode.value = 'edit'
    router.replace(`/postwrite?id=${selectedIndex.value}`, {})
}

async function deleteContent() {
    console.log('deleteContent 함수 실행')

    try {

        const response = await apiText.post('/remove', {
            id: selectedIndex.value
        })

        console.log(`응답 -> ${JSON.stringify(response.data)}`)

        router.push('/call')
    } catch (error) {
        console.error('deleteContent 함수 에러:', error)
    }
}
</script>

<style scoped>


</style>