<template>
  
  <div>

    <div>
      <h1>홈 화면</h1>
            
    </div>
    
    <div>
      <div  v-if="nameVisible">
        <label for="">이름 : </label>
        <span>{{ name }}</span>
      </div>

      <div v-else>
        <label for="">나이</label>
        <label for="">21</label>
      </div>

      <div>
        <label for="">이름 입력 : </label>
        <input type="text" v-model="nameInput">
      </div>

      <div>
        <button @click="show()">확인</button>
      </div>

      <div>
        <div style="margin-top: 2em; margin-bottom: 2em;">
          <span>동물들 </span>
          <button @click="addAnimal()">추가</button>
        </div>

        <div v-for="(item, index) in animals" :key="item.id" :class="(item.type == 'dog') ? 'dog-style' : 'cat-style'">
          <div style="margin-top: 1em;">
            <label for="">구분 : </label>
            <span>{{ (item.type == 'dog') ? '강아지' : (item.type == 'cat') ? '고양이' : '' }}</span>
          </div>

          <div>
            <label for="">이름 : </label>
            <span>{{ item.name }}</span>
          </div>

          <div>
            <label for="">나이 : </label>
            <span>{{ item.age }}</span>
          </div>

          <div>
            <label for="">전화번호 : </label>
            <span>{{ item.mobile }}</span>
          </div>

          <div>
            <label for="">사진 : </label>
            <img :src="item.path" style="width: 50px;">
          </div>

          <div>
            <button @click="modifyAnimal(index)">수정</button>
            <button @click="deleteAnimal(index)">삭제</button>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script setup>

import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router'
const router = useRouter();

//스토어(공통저장소)를 사용하기 위함
import { storeToRefs } from 'pinia';

import { useAnimalStore } from '@/stores/animal'
const animalStore = useAnimalStore()
const { animals, mode, selectedIndex } = storeToRefs(animalStore)

//감시할 수 있는 변수상자, ref 함수를 이용해서 만듦, 봉지를 씌운 것과 같다
//자바스크립트 코드에서는 변수상자의 값을 바꿀 때 name, value를 사용해야 한다.
//<template> 안에 있는 태그에서 값을 감시할 때는 {{ name }}을 사용해야 한다.
const name = ref('홍길동1')

const nameInput = ref('')

const nameVisible = ref(true)



//화면이 보이기 전에 한 번 실행됨
//목적 : 화면이 보이기 전에 초기화 or 실행해야 하는 것들을 실행
onMounted(() => {
  console.log(`HomeView : onMounted 호출됨`)
  
})

function show() {
  console.log(`show함수 호출됨`)

  name.value = nameInput.value

  nameVisible.value = false

  //name.value = '홍길동2'
}

function addAnimal() {
  console.log(`addAnimal 함수 호출됨`)

  mode.value = 'add'
  router.replace('/add')
}

//목록 : 해당 값을 확인할 id를 가져가야됨 
//삭제 : 그냥 버튼 누르면 객체가 사라지게 하기 
//수정 : onMounted로 해당 객체의 값들을 먼저 화면에 보여주고 수정한 후 버튼을 누르면 기존의 add 처럼 객체에 적용
function deleteAnimal(index) {
  console.log(`deleteAnimal 함수 호출됨`)

  animals.value.splice(index, 1)
}

function modifyAnimal(index) {
  console.log(`modifyAnimal 함수 호출됨`)

  mode.value = 'modify'
  selectedIndex.value = index
  
  router.replace(`/add?`, {})
}

</script>

<style scoped>

.dog-style {
  background-color: rgb(220, 163, 87);
  margin-bottom: 1em;

}

.cat-style {
  background-color: gainsboro;
  margin-bottom: 1em;
}

</style>

