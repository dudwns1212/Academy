//calc2.js 모듈에 있는 여러 개의 함수 중에서 add 함수만 불러오기
const { add, subtract } = require('./calc2');

const result = add(10,10);
console.log(`더하기 결과 : ${result}`);

const result2 = subtract(20,10);
console.log(`빼기 결과 : ${result2}`);