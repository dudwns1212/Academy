//calc1.js 파일로 분리되어 있는 코드를 불러옴
//-> 모듈.export에 해당된 calc를 불러옴
const calc = require('./calc1');

const result = calc.add(10,10);
console.log(`더하기 결과 : ${result}`);


