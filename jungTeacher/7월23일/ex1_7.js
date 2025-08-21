// 붕어빵 만들기

let anYuJin = {
    name: '안유진',
    age: 23
}
console.log(`아이브 멤버 이름을 한 명 말하시오 : ${anYuJin.name}`);
console.log(`아이브 멤버 안유진의 나이를 말하시오 : ${anYuJin.age}`);

let jangWonYoung = {
    name: '장원영',
    age: 23,
    dance: function () {
        console.log(`아이브가 춤을 춘다 : ${this.name}`);
    }
}
jangWonYoung.dance();

let ley = jangWonYoung;
ley.name = '레이';

// 레이라는 객체를 만들어서 장원영 객체와 같다고해 속성을 복사함
// 근데 레이의 이름을 레이로 바꿨는데 장원영의 이름도 레이로 바뀜 왜?
ley.dance();
jangWonYoung.dance();
console.log(jangWonYoung.name);
console.log(jangWonYoung===ley);
let a = 'a';
let b = a;
b = 'b';
console.log(a);
console.log(a===b);

console.log('-----------------------------');

class Fish {
    //변수상자가 자동생성
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    
    swim() {
        console.log(`붕어빵이 헤엄칩니다. : ${this.name}`)
    }

}

let fish1 = new Fish('붕어빵1', 1);
console.log(`fish1 변수상자에 들어있는 붕어빵의 이름 : ${fish1.name}`)
fish1.swim();


class House {
    Cat;
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    dance() {
        console.log(`${this.name}의 나이 : ${this.age}`);
    }

}
let dog = new House('강쥐',3);
class Cat extends House {

}
let cat = new Cat('고얌미',1);


dog.dance();
cat.dance();
