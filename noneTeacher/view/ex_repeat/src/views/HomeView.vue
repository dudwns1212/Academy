<template>
  <div>
    <h1>홈 화면</h1>
  </div>

  <div>
    <p>안녕 클레오파트라!</p>
    <img src="@/assets/images/cat2.jpg" alt="">
  </div>

  <div>
    <label for="">이름 : </label><input type="text" v-model="name">
    <br>
    <label for="">나이 : </label><input type="text" v-model="age">
    <br>
    <label for="">전화번호 : </label><input type="text" v-model="mobile">
    <br>
    <button @click="show()">확인</button>
  </div>

  <div>
    <p>{{ name }}</p>
    <p>{{ output1 }}</p>
  </div>

  <div>
    <input type="text" v-model="inputA">
    <br>
    <input type="text" v-model="inputB">
    <br>
    <button @click="add()">더하기</button>

    <p>더하기 결과 : {{ result }}</p>
  </div>

</template>

<script setup> 
import {ref} from 'vue'

const output1 = ref('결과 : ')
const name = ref('')

function show() {
  console.log('show 함수가 실행')
  
  output1.value = `결과 : ${name.value}`

}

const inputA = ref('');
const inputB = ref('');
const result = ref(0);

function add() {
  console.log('add 함수 실행')
  // inputA에 입력된 '값'을 받아 정수형태로 변수에 저장
  const a = Number(inputA.value);
  const b = Number(inputB.value);
  // result 반응형 변수의 '값'을 a + b로 지정
  result.value = a + b;

}

</script>

<style scoped>

</style>


