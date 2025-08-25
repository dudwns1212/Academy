<template>

  <div>

    <div>
      <h1>고객 추가</h1>
    </div>

    <div>
      <label for="">이름 : </label><input type="text" v-model="name" placeholder="name">
      <br>
      <label for="">나이 : </label><input type="text" v-model="age" placeholder="age">
      <br>
      <label for="">전화번호 : </label><input type="text" v-model="mobile" placeholder="mobile">

    </div>

    <div>
      <button @click="addData()">확인</button>
      <button @click="goToHome()">취소</button>
    </div>
    
  </div>

</template>

<script setup>
import { useRouter, useRoute } from 'vue-router';
import axios from 'axios';
import { ref } from 'vue'

const router = useRouter();
const route = useRoute();

const name = ref('');
const age = ref('');
const mobile = ref('');

async function addData() {
  console.log(`addData 함수 실행됨`);

  try{
  
    const response = await axios({
      method: 'get',
      url: `http://localhost:7001/view/insert-data?name=${name.value}&age=${age.value}&mobile=${mobile.value}`,
      data: {}
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    persons.value = response.data.data;

    

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }

  router.push('/');

}


function goToHome() {
  router.push('/');
}

</script>

<style scoped>



</style>