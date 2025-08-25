import { ref } from 'vue'
import { defineStore } from 'pinia'

export const usePostStore = defineStore('post', () => {

    //전체화면 모드인지 여부 (전체화면 모드에서는 상단 타이틀과 하단 텝이 보이지 않음)
    const fullScreen = ref(false);


    return {
        fullScreen
    }

})

