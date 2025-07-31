<template>

  <div>

    <div>
      <h1>홈 화면</h1>
    </div>

    <div>
      <label for="">이름 : </label><input type="text" v-model="nameInput">
    </div>

    <div>
      <label for="">나이 : </label><input type="text" v-model="ageInput">
    </div>

    <div>
      <label for="">전화번호 : </label><input type="text" v-medel="mobileInput">
    </div>

    <div>
      <button @click="show()">확인</button>
    </div>

    <div>
      <p>결과 : {{ name }}</p>
    </div>
  </div>

  <div>
    <button @click="requestPersonList()">웹서버에서 조회하기</button>
  </div>

  <table>      
    <thead>
      <tr>
        <th>이름</th>
        <th>나이</th>
        <th>전화번호</th>
      </tr>
    </thead>

    <tbody>
      <tr v-for="(item, index) in persons" :key="item.id">
        <td>{{ item.name }}</td>
        <td>{{ item.age }}</td>
        <td>{{ item.mobile }}</td>
      </tr>
    </tbody>

  </table>

  <div>
    <button @click="goToAbout()">정보 화면으로</button>
    <button @click="goToMenu()">메뉴 화면으로</button>
  </div>
  

</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';

const router = useRouter();

import axios from 'axios';

const nameInput = ref('');

const name = ref('');

const persons = ref([])

// const persons = ref([   // 배열이 ref로 감싸짐
//   {
//     id: 1,
//     name: '홍길동1',
//     age: 21,
//     mobile: '010-1000-1000'
//   },
//   {
//     id: 2,
//     name: '홍길동2',
//     age: 22,
//     mobile: '010-2000-2000'
//   },
//   {
//     id: 3,
//     name: '홍길동3',
//     age: 23,
//     mobile: '010-3000-3000'
//   }
// ])

// 페이지가 로딩되면 호출되는 콜백함수를 등록하기
// 웹서버 조회 버튼을 누르지 않아도 그냥 홈페이지를 들어오면 고객리스트가 보이게 자동 요청
onMounted(() => { 
  console.log(`onMounted 호출됨`)    
  
  requestPersonList();
});

function show() {
  console.log('show 함수 실행됨');

  name.value = nameInput.value
}

async function requestPersonList() {
  console.log(`requsetPersonList 함수 호출됨`);

  try{

    const response = await axios({
      method: 'get',
      url: 'http://localhost:7001/view/list-data',
      data: {}
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    persons.value = response.data.data;

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }

}

function goToAbout() {  // 정보를 about뷰로 넘겨줌
  router.push({
    path: '/about',
    query: { name: '홍길동1', age: 21}
  });
}

function goToMenu() {
  router.push('/menu');
}

</script>

<style scoped>



</style>