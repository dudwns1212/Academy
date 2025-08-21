// let을 씀 -> string, number, boolean 모두 가능
let age = 21;
let name =`goyoungjun`;
let isMan = true;
console.log(typeof(age));
console.log(typeof(isMan));
console.log(typeof(name));

// 여기는 ``이걸 사용함
console.log(`이거는 변수더할때 +안함 ${age} 더 추가도 됨 엔터도 그냥 됨
${name} /슬래시 \\백슬래시는 두번해야 가능`)

//undefined 미정의 null과 다름
let n = null;
let u;
console.log(typeof(n)); // object 타입
console.log(typeof(u)); // undefined 타입
if(n) {
    console.log(`null인데`)
}
if(u){
    console.log(`un`);
}
// 당연히 if문 둘다 실행 안됨

// 함수상자 기본, 익명, 화살표, 콜백

function A() {
    console.log(`기본`);
}
A();

// 변수에 함수상자 할당 가능
let B = function C(){
    console.log('B는 변수상자지만 함수로 사용 가능하게 됨 근데 이러면 이름이 2개네?');
    // C는 내부에서만 호출가능 외부에서 사용불가 나도 이해안됨
}
B();

// 이름이 2개니까 하나는 없어도 되잖아 -> 익명함수
let D = function(){
    console.log(`익명함수`)
}
D();
// 갑자기 function도 쓰기 싫네
let E = () => {
    console.log(`ㅋㅋ화살표함수`)
}
E();

// 매우 중요한 콜백함수 이건 이해까지 해야됨 구조를
// 2개의 변수만 필요하지만 3개를 변수로함
// return을 하지 않고 나머지 1개의 변수에 할당, 나머지 하나의 변수는 함수가 됨
// 그 함수 c를 실행
function useCallback(a,b,c){
    c(a+b);
}
useCallback(10,10,(result)=>{
    console.log(`콜백함수 실행결과 : ${result}`);
})

//객체생성도 let으로 가능
// 이렇게 클래스 없이 인스턴스객체 생성가능
let ive = {
    m1: `anYuJin`,
    m2: `jangWonYoung`,
    m3: `ley`,
    m4: `gaul`,

    dance() {
        console.log(`아이브가 춤을 춰요 : ${this.m1}`)
        console.log(`아이브가 춤을 춰요 : ${this.m2}`)
    }

}

console.log(ive.m1);
console.log(`이런식으로 객체생성이 된다 클래스없이 ${ive.m4}`);
ive.dance();

// 여기서 primitive type -> number, string, boolean 은 값을 가짐
// 하지만 reference type -> object, array, function은 주소를 가짐
let ive2 = ive;
ive2.m1 = 'karina';
ive.dance(); 
// ive2를 바꿨는데 ive의 값이 바뀜
// 주소를 참조하기 때문에 같은 주소를 가지고 그 주소의 값이 바뀌는 것
// 따라서 주소를 공유하는 모든 객체의 값이 변함 = reference type

// 클래스
class Fish{
    //name;
    //age;
    // 이렇게 타입 없이 속성선언이 되지만 생성자를 이용하면 자동 생성됨
    constructor(name,age){
        this.name=name;
        this.age=age;
    }

    profile() {
        console.log(`이름은 ${this.name}이고 나이는 ${this.age}`)
    }
}
let fish1 = new Fish('고등어',1);
fish1.profile();

//과제 복습하기, 강아지-고양이(name)+class
// 집-noclass (person,dog,cat), 사람-noclass(name age mobile)
class Dog {
    constructor(name){
        this.name=name;
    }
}

class Cat {
    constructor(name){
        this.name=name;
    }
}

let person = {
    name:'goyoungjun',
    age:25,
    mobile:'010-4041-7802'
}

let house = {
    person:person,
    cat: new Cat('yaong'),
    dog: new Dog('mungmung'),

    profile1(){
        console.log(`사람의 프로필
이름: ${this.person.name}, ${this.person.age}, ${this.person.mobile}
강아지의 프로필
이름: ${this.dog.name}
고양이의 프로필
이름: ${this.cat.name}`);    
    }   
}
house.profile1();