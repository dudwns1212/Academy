<template>
  
  <div>

    <div>
      <h1>추가 화면</h1>      
    </div>

    <div>
      <div>
        <label for="">구분</label>
        <input type="text" v-model="typeInput">
      </div>

      <div>
        <label for="">이름</label>
        <input type="text" v-model="nameInput">
      </div>

      <div>
        <label for="">나이</label>
        <input type="text" v-model="ageInput">
      </div>

      <div>
        <label for="">전화번호</label>
        <input type="text" v-model="mobileInput">
      </div>

      <div>
        <label for="">이미지 경로</label>
        <input type="text" v-model="pathInput">
      </div>
    </div>

    <div style="margin-top: 2em;">
      <button @click="save()">저장</button>
      <button @click="cancle()">취소</button>
    </div>
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router'
const router = useRouter();

import axios from 'axios'

//스토어(공통저장소)를 사용하기 위함
import { storeToRefs } from 'pinia';

import { useAnimalStore } from '@/stores/animal'
const animalStore = useAnimalStore()
const { animals, mode, selectedIndex } = storeToRefs(animalStore)

const typeInput = ref('')
const nameInput = ref('')
const ageInput = ref('')
const mobileInput = ref('')
const pathInput = ref('')

onMounted(() => {
  console.log(`animalAdd : onMounted 호출됨`)

  //수정 모드인 경우, 입력상자에 선택된 아이템의 값을 넣어주기
  if(mode.value == 'modify') {
    const selected = animals.value[selectedIndex.value]

    typeInput.value = selected.type
    nameInput.value = selected.name
    ageInput.value = selected.age
    mobileInput.value = selected.mobile
    pathInput.value = selected.path
  }
  
})

function save() {
  console.log(`save 함수 호출됨`)

  const type = typeInput.value
  const name = nameInput.value
  const age = ageInput.value
  const mobile = mobileInput.value
  const path = pathInput.value

  const item = {
    //id: String(animals.length + 1),
    type: type,
    name: name,
    age: age,
    mobile: mobile,
    path: path
  }

  if(mode.value == 'add'){
    
    requestAnimalAdd(item)

  } else if (mode.value == 'modify') {
    
    item.id = animals.value[selectedIndex.value].id

    requestAnimalModify(item)
  }
}

async function requestAnimalAdd(item) {
  try{
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/add',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    goToList()

  } catch(err){
    console.error(`에러 -> ${err}`);
  }
}

async function requestAnimalModify(item) {
  try{
    const response = await axios({
      method: 'post',
      baseURL: 'http://localhost:8001',
      url: '/animal/v1/modify',
      data: item,
      timeout: 5000,
      responseType: 'json'
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    goToList()

  } catch(err){
    console.error(`에러 -> ${err}`);
  }
}

function goToList() {
  router.replace('/', {})
}

function cancle() {
  console.log(`cancle 함수 호출됨`)

  router.replace('/', {})
}

</script>

<style scoped>



</style>

