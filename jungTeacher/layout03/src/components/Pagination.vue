<template>

  <ul class="pagination pagination-circle pagination-outline">
      
    <li v-if="pagination.page == 1" class="page-item first m-1" disabled>
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-double-left fs-2"><span class="path1"></span><span class="path2"></span></i>
        </a>
    </li>
    <li v-else class="page-item first m-1" @click="requestFunc(1, pagination.perPage)">
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-double-left fs-2"><span class="path1"></span><span class="path2"></span></i>
        </a>
    </li>

    <li v-if="pagination.page == 1" class="page-item previous m-1" disabled>
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-left fs-2"></i>
        </a>
    </li>
    <li v-else="pagination.page == 1" class="page-item previous m-1" @click="requestFunc(pagination.page-1, pagination.perPage)">
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-left fs-2"></i>
        </a>
    </li>

    <li v-for="item in pagination.pages" :key="item.pageNo" class="page-item m-1" :class="(item.pageActive) ? 'active' : ''">
        <a v-if="item.pageActive" href="#" class="page-link">{{ item.pageNo }}</a>
        <a v-else @click="requestFunc(item.pageNo, pagination.perPage)" href="#" class="page-link">{{ item.pageNo }}</a>
    </li>
 
    <li v-if="pagination.page >= pagination.pageCount" class="page-item next m-1" disabled>
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-right fs-2"></i>
        </a>
    </li>
    <li v-else class="page-item next m-1" @click="requestFunc(pagination.page + 1, pagination.perPage)">
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-right fs-2"></i>
        </a>
    </li>

    <li v-if="pagination.page >= pagination.pageCount" class="page-item last m-1" disabled>
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-double-right fs-2"><span class="path1"></span><span class="path2"></span></i>
        </a>
    </li>
    <li v-else="pagination.page >= pagination.pageCount" class="page-item last m-1" @click="requestFunc(pagination.pageCount, pagination.perPage)">
        <a href="#" class="page-link px-0">
            <i class="ki-duotone ki-double-right fs-2"><span class="path1"></span><span class="path2"></span></i>
        </a>
    </li>

  </ul>

</template>

<script setup>
import { onMounted } from 'vue';

// 전달받은 request 함수
const props = defineProps(['requestFunc', 'pagination']);
 
onMounted(() => {
    console.log(`Pagination::onMounted 호출됨 -> pagination : ${JSON.stringify(props.pagination)}`);
 
})


</script>
 
<style scoped>

</style>
