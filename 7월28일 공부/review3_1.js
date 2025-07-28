// 변수상자 만들기

let name1 = '홍길동1';  // string
let age1 = 21;  // number
let visible = true;  // boolean
// 위의 기본자료형 3가지를 primitive 타입
const name1Type = typeof(name1);
console.log(`name1 변수상자의 크기 : ${name1Type}`)

let name2;  // undefined (미정의)
const name2Type = typeof name2;
console.log(`name2 변수상자의 크기 : ${name2Type}`)

const age2 = '21A';
const age3 = '22';

const age2Int = Number(age2);  // 문자 -> 숫자
const age3Int = Number(age3); 

const result1 = age2Int + age3Int;
console.log(`더하기 결과 : ${result1}`);  // 숫자만 들어간 문자열이 아니라서 숫자로 바뀌지 못함 -> (NaN)

if (isNaN(age2Int)) {
    console.log(`첫 번째 글자는 숫자가 아닙니다.`)
}

if (isNaN(result1)) {
    console.log(`더하기 결과가 숫자가 아닙니다.`)
}

