// 함수상자 만들기
function print() {
    console.log(`print 함수 실행됨`);
}
print();

// 함수상자를 1급객체로 다루기 : 함수상자를 변수상자에 넣을 수 있다.
const print2 = function () {
    console.log(`print 함수 실행됨`);
}

// 화살표 함수 만들기
const print3 = () => {
    console.log(`print 함수 실행됨`);
}

// 콜백함수 사용하기
function add(a, b) {
    return a + b;
}

const output1 = add(10,10);
console.log(`더하기 결과 : ${output1}`);

const add2 = (a, b, callback) => {
    const result = a + b;
    callback(result);
}

add2(10, 10, (output) => {
    console.log(`콜백함수 안에서 더하기 결과 : ${output}`);
})