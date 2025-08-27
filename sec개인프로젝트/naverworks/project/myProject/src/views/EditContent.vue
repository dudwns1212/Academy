<template>
<div style="padding-top: 85px; text-align: center;">
</div>
<!-- 너무 좁아서 좀 키우고싶은데 -->
<div class="d-flex flex-column justify-content-center align-items-center mt-20" style="margin-bottom: 40px;">
  <h1 class="mb-4">게시물 정보 수정</h1>

  <div class="form-group mb-3" style="width: 300px;">
          <label>제목</label>
          <span>
                  <input v-model="contentTitle" type="text" class="form-control" style="margin-right: 10px;" />
          </span>       
  </div>

  <div class="form-group mb-3" style="width: 300px;">
          <label>내용</label>
          <span>
                  <textarea v-model="coments" rows="5" class="form-control" style="margin-right: 10px;"></textarea>
          </span>       
  </div>

  <div class="form-group mb-3" style="width: 300px;">
          <select v-model="contentCategory">
              <option value="category1">카테고리 1</option>
              <option value="category2">카테고리 2</option>
              <option value="category3">카테고리 3</option>
          </select>       
  </div>
  <div v-if="path" class="form-group mb-3" style="width: 300px;">
          <label>사진</label>
          <input type="text" v-model="path" class="form-control" style="margin-right: 10px;" />
          <img :src="path" alt="" style="width: 100%; height: auto; margin-top: 10px;"/>
  </div>
  <div class="d-flex justify-content-center gap-20 mt-5">
    <button class="btn btn-light-primary" @click="updateContent()">수정하기</button>
    <button class="btn btn-light-secondary" @click="goBack()">돌아가기</button>
  </div>
</div>

</template>

<script setup>
import { ref, onMounted } from 'vue'

import { useRouter, useRoute } from 'vue-router';

//스토어에서 title랑 로그인 확인하는거 불러오기
//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

import { useTextStore } from '@/stores/text'
const textStore = useTextStore()
const { textList} = storeToRefs(textStore)

import { apiText } from '@/util/api_text';

import { useLoginStore } from '@/stores/logined';
const loginStore = useLoginStore()
const { logined } = storeToRefs(loginStore)

const router = useRouter();
const route = useRoute();

const id = route.query.id;

const contentTitle = ref('')
const coments = ref('')
const contentCategory = ref('')
const path = ref('')

onMounted(() => {
    title.value = "게시물 수정"
    if(!logined.value){
        alert('로그인 해주세요')
        router.push('/login');
    }

    requestSelectedContent();
})

async function requestSelectedContent() {
    console.log(`requestSelectedContent 호출됨`);
    
    try{
  
      const response = await apiText.post('/read',{
          id: id
      })
      const result = response.data.data.data[0]
      console.log(`응답 -> ${JSON.stringify(result)}`)

      contentTitle.value = result.title
      coments.value = result.coments
      contentCategory.value = result.category
      path.value = result.path

    } catch(err) {
      console.error(`에러발생 -> ${err}`)
    }
}

function goBack() {
    router.push('/call')
}

</script>

<style scoped>


</style>