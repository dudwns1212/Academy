// 함수상자 만들기

// 자바의 경우는 
// int add(a,b) {return a+b;}

function add(a, b) {
    return a+b;
}
let output1 = add(10,10);
console.log(`더하기 결과 : ${output1}`);

function print(a) {
    console.log(`print 함수상자 안에서 a 상자의 값 : ${a}`);
}

print(10);

// 함수상자를 변수상자에 넣기
let show = print;
show(20);

// 변수상자를 만들면서 함수상자로 초기화하기
let show2 = function () {
    console.log(`print2 함수 실행`);
}
show2();

let show3 = () => {
    console.log(`print3 함수 실행`);
}
show3();

function add2(a,b) {
    return a+b;
}

let output2 = add2(10,10);
console.log(`더하기 결과 : ${output2}`);

function add3(a, b, c) {
    c(a+b);
}

add3(10,10, (output) => {
    console.log(`더하기 결과 : ${output}`);
})

