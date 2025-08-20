<template>
  
  <!-- 정렬하기 -->
  <div class="d-flex flex-column">
    
    <div class="d-flex justify-content-center bg-secondary my-border gap-2 p-10 w-400px h-200px">
      <button class="btn btn-primary">버튼 1</button>
      <button class="btn btn-primary">버튼 2</button>
      <button class="btn btn-primary">버튼 3</button>
    </div>

    <div class="d-flex justify-content-between bg-secondary my-border gap-2 p-10">
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