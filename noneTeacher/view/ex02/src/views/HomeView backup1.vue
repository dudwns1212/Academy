<template>

  <div>
    <h1>홈 화면</h1>

    <div>
      <p>안녕 클레오파트라!</p>
      <img src="@/assets/images/cat2.jpg" alt="">
    </div>

    <div>
      <label>이름 : </label><input type="text" id="input1">
      <br>
      <label for="">나이 : </label><input type="text" id="input2">
      <br>
      <label for="">전화번호 : </label><input type="text" id="input3">
      <br>
      <button @click="show()">확인</button>
    </div>

    <div id="output1">



    </div>

  </div>

</template>

<script setup>

function show() {
  console.log(`show 함수 호출됨`);

  const input1 = document.querySelector('#input1')
  const name = input1.value;

  const output1 = document.querySelector('#output1');
  output1.innerHTML = `<p>입력된 값 : ${name}</p>`
}

</script>

<style scoped>



</style>


