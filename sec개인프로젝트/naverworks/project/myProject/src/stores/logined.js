import { defineStore } from "pinia";
import { ref } from "vue";

export const useLoginStore = defineStore('logined', () => {
    const logined = ref(false) 


    function checkLogin() {
        const user = localStorage.getItem('user');

        if(user) {
            logined.value = true
        }
    }

    checkLogin()

    return { logined, checkLogin }
})
    
