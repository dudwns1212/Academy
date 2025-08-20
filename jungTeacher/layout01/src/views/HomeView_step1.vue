<template>
  
  <!-- Flex를 이용해 쌓기, d-flex: Flex를 사용함, 기본은 가로로 쌓기(flex-row), 세로로 쌓기(flex-column) -->
  <div class="d-flex flex-column">
    <!-- bg : 배경, gap : 안의 속성들 사이의 간격 -->
    <div class="bg-secondary my-border p-10">
      <button class="btn btn-primary">버튼 1</button>
      <button class="btn btn-primary">버튼 2</button>
      <button class="btn btn-primary">버튼 3</button>
    </div>

    <div class="d-flex flex-column bg-secondary my-border gap-2 p-10">
      <button class="btn btn-primary">버튼 1</button>
      <button class="btn btn-primary">버튼 2</button>
      <button class="btn btn-primary">버튼 3</button>
    </div>

  </div>

</template>

<script setup>

</script>

<style scoped>

.my-border {
  border: 2px dashed violet;
}

</style>