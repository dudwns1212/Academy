<template>

  <div>
    <h1>홈 화면</h1>

    <div>
      <p>안녕 클레오파트라!</p>
      <img src="@/assets/images/cat2.jpg" alt="">
    </div>

    <div>
      <label>이름 : </label><input type="text" v-model="name">
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

      <p>더하기 결과 : {{ result1 }}</p>
    </div>

  </div>

</template>

<script setup>

import {ref} from 'vue';

const output1 = ref(`결과 : `);
const name = ref(``);


const inputA = ref(``);
const inputB = ref(``);
const result1 = ref(0);

function add() {
  const a = Number(inputA.value);
  const b = Number(inputB.value);

  result1.value = a + b;

}

function show() {
  console.log(`show 함수 호출됨`);

  const input1 = document.querySelector('#input1')
  const nameResult = name.value;

  output1.value = `결과 : ${nameResult}`;
}

</script>

<style scoped>



</style>


