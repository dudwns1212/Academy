// 변수상자 만들기
let name1;
name1 = `홍길동`;

let name2 = `홍길동2`;

let age1 = 21;
let visible = true;

console.log(`name1 변수상자의 크기 : ${typeof(name1)}`); // string
console.log(`age1 변수상자의 크기 : ${typeof(age1)}`); // number
console.log(`visible 변수상자의 크기 : ${typeof(visible)}`); // boolean

let name3;
console.log(`name3 변수상자의 크기 : ${typeof(name3)}`); // undefined  

if (name3 == `undefined`) {
    console.log(`name3 변수는 정의되지 않았습니다.`);
}
