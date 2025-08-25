// 함수상자 만들기
function add1(a,b) {
    return a + b;
}

let a = 10;
let b = 10;

let output1 = add1(a, b);
console.log(`더하기 결과 : ${output1}`);

// 함수상자를 변수상자에 넣기
let add2 = function (a, b) {
    return a + b;
}

let add3 = (a, b) => {
    return a + b;
}

// 콜백함수 사용하기
let add4 = (a, b, c) => {
    c(a + b);
}
add4(20, 20, (output) => {
    console.log(`콜백함수 안에서 결과 : ${output}`);
})


