// 붕어빵 만들기
// 클래스 없이 객체 만들기
const fish1 = {
    name: '홍길동1',
    age: 21
}

// 여러개의 변수 넣기
const fishes = [];
// 배열을 만들고 push로 배열의 맨 뒤에 값(객체) 추가
fishes.push({
    name: '물고기1',
    age: 1
})

fishes.push({
    name: '물고기2',
    age: 2
})

console.log(`fishes의 칸 개수 : ${fishes.length}`);
// 둘은 같은 용도 / .으로 찾냐, 대괄호 안의 문자열로 찾냐
console.log(`첫 번째 칸에 있는 물고기의 이름 : ${fishes[0].name}`);
console.log(`첫 번째 칸에 있는 물고기의 이름 : ${fishes[0]['name']}`);


// 클래스로 객체만들기
class Fish {
    // 변수상자 정의없이 생성자를 이용하면 자동으로 정의됨
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

}

const fish3 = new Fish('물고기3', 3);
const fish4 = new Fish('물고기4', 4);