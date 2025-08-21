import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useAppStore = defineStore('app', () => {

    //상단 제목 
    const title = ref('');
    

    return {
        title
    }

})

