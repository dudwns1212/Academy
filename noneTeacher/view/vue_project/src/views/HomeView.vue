<template>

  <div>

    <div>
      <h1>고객 목록</h1>
    </div>

    

  </div>

  <div>
    <h4>총 {{ persons.length }}명</h4>
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
          <td><button @click="goToUpdate(item)">수정</button></td>
          <td><button @click="deleteData(item.id)">삭제</button></td>
        </tr>
      </tbody>

    </table>
  </div>
  
  <div>
    <button @click="goToAdd()">추가</button>
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';

const router = useRouter();

import axios from 'axios';

const persons = ref([])

onMounted(() => { 
  console.log(`onMounted 호출됨`)    
  
  requestPersonList();

});

// 리스트의 데이터 불러오고 persons를 정의(불러온 데이터)
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

async function deleteData(id) {
  console.log(`deleteData 함수 호출됨`)

  try{
  
    const response = await axios({
      method: 'get',
      url: `http://localhost:7001/view/delete-data?id=${id}`,
      data: {}
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`);

    persons.value = response.data.data;

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }

}

// 수정 버튼 누르면 update 화면으로
function goToUpdate(person) {  

  console.log('선택된 고객 : ', person)

  router.push({
    path: '/update',
    query: {id: person.id, name: person.name, age: person.age, mobile: person.mobile}
  });
}

function goToAdd() {
  router.push('/add');
}

</script>

<style scoped>



</style>