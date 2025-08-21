class Dog {
    constructor (name) {
        this.name = name;
    }
}

let dog1 = new Dog('강쥐');

class Cat {
    constructor (name) {
        this.name = name;
    }
}

let cat1 = new Cat('고얌미');

let person1 = {
    name: '사람',
    age: 25,
    mobile: '1111-1111'
}

let House = {
    Person: person1,
    Dog: dog1,
    Cat: cat1,
    
    print: function () {
        console.log(`--person의 정보
${person1.name}
${person1.age}
${person1.mobile}
--dog의 정보
${dog1.name}
--Cat의 정보
${cat1.name}`)
    }
}

House.print();