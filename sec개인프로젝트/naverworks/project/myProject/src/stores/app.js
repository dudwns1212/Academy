import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useAppStore = defineStore('app', () => {

    //전체화면 모드인지 여부 (전체화면 모드에서는 상단 타이틀과 하단 텝이 보이지 않음)
    const fullScreen = ref(false);

    //상단 제목 
    const title = ref('');
    

    return {
        fullScreen, title
    }

})

