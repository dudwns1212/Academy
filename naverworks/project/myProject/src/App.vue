<template>

  <div class="d-flex flex-column flex-root app-root" id="kt_app_root">
    <RouterView />
    <HeaderView />
  </div>
  
</template>

<script setup>

import { RouterView } from 'vue-router'
import HeaderView from './views/HeaderView.vue';


</script>

<style scoped>



</style>
