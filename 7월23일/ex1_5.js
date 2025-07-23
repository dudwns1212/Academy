console.log('안녕!');

// 변수상자 만들기

// 자바 스크립트는 변수상자의 크기를 명시하지 않음 (Type은 있음)

let name1;
console.log(name1);
name1 = '고영준';
console.log(name1);
console.log(`name1 변수상자의 값 : ` + name1);
console.log(`name1 변수상자의 값 : ${name1}`);

let name2 = '홍길동2';
let age1 = 21;

console.log(`name2 변수상자의 값 : ${name2}`);
console.log(`age1 변수상자의 값 : ${age1}`);

// 자바스크립트는 숫자(소수점이 있든 없든) -> number
console.log(`age1 변수상자의 타입(크기) : ${typeof(age1)}`);
console.log(`name1 변수상자의 타입(크기) : ${typeof(name1)}`);

let isTrue = true;
let isFalse = false;
console.log(`isTrue 변수상자의 타입(크기) : ${typeof(isTrue)}`)

let age2;
console.log(`undefined의 타입 : ${age2}`);

if(typeof(age2) == 'undefined') {
    console.log(`age2 변수상자의 크기를 알 수 없습니다.`)
} else if (typeof(age2) == 'string') {
    console.log(`age2 변수상자의 크기는 string 입니다.`)
}

age2 = 22;
// undefined -> if문이 실행되지 않음
if(age2) {
    console.log("age2 변수상자가 정의되어 있습니다 : " + typeof(age2));
}

// ==: 느슨한 비교(자료형은 비교하지 않음), ===: 엄격한 비교(자료형 까지 일치해야 true
