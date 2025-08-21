// 클래스 없이 객체만들기
let fish1 = {
    name: '홍길동1',
    age: 21,

    swim () {
        console.log(`${this.name}인 물고기가 헤엄칩니다.`);
    }
}
fish1.swim();

// 클래스에서 객체 만들기
class Fish {

    constructor(name, age) {
        this.name = name;
        this.age = age;
        console.log(`물고기가 만들어졌어요.`)
    }
}

let fish2 = new Fish('물고기1', 1);
console.log(`fish2 변수상자에 들어있는 물고기의 이름 : ${fish2.name}`);