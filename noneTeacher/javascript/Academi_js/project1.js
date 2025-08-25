class Dog {
    constructor (name) {
        this.name = name;
    }
}


class Cat {
    constructor (name) {
        this.name = name;
    }
}


let person1 = {
    name: '사람',
    age: 25,
    mobile: '1111-1111'
}

let House = {
    Person: person1,
    Dog: new Dog('강쥐'),
    Cat: new Cat("걍이"),
    
    print() {
        console.log(`--person의 정보
${this.Person.name}
${this.Person.age}
${this.Person.mobile}
--dog의 정보
${this.Dog.name}
--Cat의 정보
${this.Cat.name}`)
}
}

House.print();