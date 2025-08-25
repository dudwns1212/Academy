<template>

  <div>

    <div>
      <h1>고객 수정</h1>
    </div>

    <div>
      <input type="hidden" name="id" v-model="id">
      <label for="">이름 : </label><input type="text" name="name" v-model="name">
      <br>
      <label for="">나이 : </label><input type="text" name="age" v-model="age">
      <br>
      <label for="">전화번호 : </label><input type="text" name="mobile" v-model="mobile">

    </div>

    <div>
      <button @click="updateData()">확인</button>
      <button @click="goToHome()">취소</button>
    </div>
    
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios'; 

const router = useRouter();
const route = useRoute();

const name = ref('');
const age = ref('');
const mobile = ref('');
const id = ref('');

onMounted(() => {
  console.log(`UpdateView 화면의 onMounted 호출됨`)

  name.value = route.query.name;
  age.value = route.query.age;
  mobile.value = route.query.mobile;
  id.value = route.query.id;
})

async function updateData() {
  console.log(`updateData 실행됨`);

  try{
  
    const response = await axios({
      method: 'get',
      url: `http://localhost:7001/view/modify-data?id=${id.value}&name=${name.value}&age=${age.value}&mobile=${mobile.value}`,
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

  router.push({
    path: '/',
});
}

</script>

<style scoped>



</style>