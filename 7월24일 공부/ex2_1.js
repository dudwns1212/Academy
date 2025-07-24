// 여러 개의 값을 하나의 변수 상자에 넣기

let names = ['홍길동1', '홍길동2', '홍길동3'];
console.log(`names 배열 안에 있는 요소들의 개수 : ${names.length}`);
console.log(`names 배열 안에 있는 요소들 : ${names}`);
console.log(`names의 첫 번째 칸에 들어있는 값은? : ${names[0]}`);

console.log(`names의 자료형 : ${typeof names}`)
console.log(`names 안에 있는 값의 자료형 ${typeof names[0]}`);

let fishes = [
    {
        name: 'fish1',
        age: 1
    },
    {
        name: 'fish2',
        age: 2
    },
    {
        name: 'fish3',
        age: 3
    }
]
console.log(`fishes 변수상자에 들어있는 칸(요소)의 개수 : ${fishes.length}`); 
console.log(`fishes 변수상자에 들어있는 칸(요소)들 : ${fishes}`); // 배열 안에 객체가 들어있음
console.log(`fishes 변수상자에 들어있는 첫 번째 칸의 값 : ${fishes[0].name}, ${fishes[0].age}`);
console.log(`fishes의 첫 번째 칸에 들어있는 물고기의 이름은? : ${fishes[0].name}`);

let fish1 = {
    name: 'fish1'
}
console.log(`fish1의 자료형은? : ${typeof fish1}`); // 객체의 자료형은 object
// 배열과 객체의 자료형이 모두 object라서 구분이 안됨.

console.log(`names 변수상자는 배열인가요? : ${Array.isArray(names)}`); // true 배열임
console.log(`fish1 변수상자는 배열인가요? : ${Array.isArray(fish1)}`); // false 객체임

let print = ()=>{
    console.log(`print 함수 실행됨.`);
}
console.log(`print 변수상자의 자료형 : ${typeof print}`); // 함수의 자료형은 function 
// 자료형 문자열 = 'string', 숫자 = 'number', 불리언 = 'boolean', 객체 = 'object', 함수 = 'function', 배열 = 'object', 'undefined' = 'undefined'

// 값 추가하기
// push는 맨 뒤에다가 추가
fishes.push({
    name: 'fish4',
    age: 4
})
console.log(`fishes 변수상자에 들어있는 칸의 개수 : ${fishes.length}`);

// for문으로 배열의 값들을 하나씩 확인하기
// for문은 안쓰는게 좋다 - 속도가 느림
for(let i=0; i<fishes.length; i++) {
    console.log(`fishes의 ${i}번째 물고기 : ${fishes[i].name}`);
}
console.log(`-----------------------------------------------`);

// 앞의 fish변수에다가 fishes의 값을 넣어서 확인
// 단 i의 값이 없기 때문에 몇 번째인지 몇 번째까지 할건지 알 수 없음
// 따라서 i를 정의
let i = 0;
for (let fish of fishes) {
    console.log(`fishes의 ${i}번째 물고기 : ${fish.name}`);
    i += 1;
}
console.log(`-----------------------------------------------`);

fishes.forEach((value, index) => {
    console.log(`fishes의 ${index}번째 물고기 : ${value.name}`);
})

let house = {
    name: 'our house',
    children: [
        {
            name: 'child1',
            age: 11,
            fishes: [
                {
                    name: 'fish1',
                    age: 1
                }
            ]
        },
        {
            name: 'child2',
            age: 12
        }
    ]
}
console.log(`집 안에 있는 첫 번째 아이가 가지고 있는 첫 번째 물고기의 나이는? : ${house.children[0].fishes[0].age}`);

console.log(`fish1 물고기의 이름 : ${fish1.name}`); // .으로 접근
console.log(`fish1 물고기의 이름 : ${fish1['name']}`); // 대괄호를 이용해 문자열로 접근 

let attrName = 'name';
console.log(`fish1 물고기의 이름 : ${fish1[attrName]}`); // 대괄호를 이용해 변수로도 접근 가능 

// 93번째 줄을 96번째 줄의 형태로 변경 / .을 지우고 대괄호와 ''을 넣어줌
console.log(`집 안에 있는 첫 번째 아이가 가지고 있는 첫 번째 물고기의 나이는? : ${house['children'][0]['fishes'][0]['age']}`);

// 객체 안에 들어있는 속성들을 글자로 바꿔 출력
// JSON 포맷(자바스크립트의 객체를 글자로 바꾼것)
let houseInfo = JSON.stringify(house); // 객체를 문자열로 변환
console.log(`house 정보 : ${houseInfo}`); // 문자열로 변환된 객체 출력

house2 = JSON.parse(houseInfo); // 문자열을 다시 객체로 변환
console.log(`house의 이름 : ${house2['name']}`);

// 해시테이블 사용하기
let map = new Map();
map.set('강아지',{
    name: '강아지1',
    age: 1
});
map.set('고양이',{
    name: '고양이1',
    age: 2
});

let dog = map.get('강아지');
console.log(`해시맵에서 꺼내온 강아지의 이름 : ${dog.name}`);

let map2 = {}
// 이 방법은 권장하지 않음
map2['강아지'] = {
    name: '강아지1',
    age: 1
}

map2['고양이'] = {
    name: '고양이1',
    age: 2
};

let dog2 = map2['강아지']
console.log(`꺼내온 강아지의 이름 : ${dog2.name}`);