<template>

  <div>

    <div>
      <h1>정보 화면</h1>
    </div>

    <div>
      <p>전달받은 이름 : {{ name }}</p>
      <p>전달받은 나이 : {{ age }}</p>
    </div>

    <div>
      <button @click="goToHome()">홈 화면으로</button>
    </div>
    
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router';
const router = useRouter();
const route = useRoute();


const name = ref('');
const age = ref('')

onMounted(() => {
  console.log(`AboutView 화면의 onMounted 호출됨`)

  name.value = route.query.name;
  age.value = route.query.age;
})

function goToHome() {
  router.push('/');
}

</script>

<style scoped>



</style>