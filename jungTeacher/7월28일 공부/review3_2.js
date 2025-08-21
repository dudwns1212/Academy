// 함수상자

// A 개발자 -> 더하기 함수상자 만들기 : a, b라는 2개의 위쪽 구멍을 만들어둠
function add(a, b) {
    return a + b;
}

// B 개발자 -> A 개발자가 만든 더하기 함수상자의 위쪽 구멍은 2개라고 이미 정의되어 있음
const a = 10;
const b = 20;

const result1 = add(a, b);
console.log(`더하기 결과 : ${result1}`);

// 콜백함수
// 함수를 일급객체로 다룬다. -> 함수를 변수에 할당할 수 있다. -> 함수상자를 변수상자에 넣을 수 있다.

const add2 = function (a, b) {
    return a + b;
}

const add3 = (a, b) => {
    return a + b;
}

// A 개발자가 콜백 함수를 사용하는 형태로 함수를 정의함
const add4 = (a, b, callback) => {
    callback(a + b);
}

// B 개발자가 콜백 함수를 사용함
// 위쪽 구멍으로 던져줄 값의 개수는 A 개발자가 정의한 개수와 동일하게 맞춰줌
add4(a, b, (result) => {
    console.log(`콜백 함수 안에서 더하기 결과 : ${result}`);
})


// 콜백함수를 여러 개 연속해서 사용하는 경우

// null 알아보기
let fish1 = {
    name: '물고기1',
    age: 1
}

let fish2 = null;

const add5 = (a, b, callback) => {
    const result = a + b;
    callback(null, result);
}

add5(10, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`더하기 결과 : ${result}`);
})

const divide5 = (a, b, callback) => {
    if (b == 0) {
        callback('두번째 값이 0입니다.', null);
        return;
    }

    const result = a / b;
    callback(null, result);
}

divide5(200, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`콜백함수 안에서 나누기 결과 : ${result}`);
})

// A 개발자가 만들어 둔 더하기 함수와 나누기 함수가 있을 때,
// 나누기 함수를 실행한 결과값에 다른 값을 더하고 싶은 경우

divide5(200, 10, (err, result) => {
    if (err) {
        console.log(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`나누기 결과 : ${result}`);

    add5(result, 10, (err2, result2) => {
        if (err2) {
            console.log(`에러 발생 -> ${err2}`);
            return;
        }

        console.log(`더하기 결과 : ${result2}`);


    })

})


const add6 = (a, b, callback) => {
    setTimeout(() => {
        const result = a + b;
        callback(null, result);
    }, 500)
}

const divide6 = (a, b, callback) => {
    setTimeout(() => {
        if (b == 0) {
            callback('두번째 값이 0입니다.', null);
            return;
        }

        const result = a / b;
        callback(null, result);
    }, 1000)

}



divide6(200, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`divide6 안에서 나누기 결과 : ${result}`);
})
add6(10, 10, (err, result) => {
    if (err) {
        console.error(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`add6 안에서 더하기 결과 : ${result}`);
})


divide6(200, 10, (err, result) => {
    if (err) {
        console.log(`에러 발생 -> ${err}`);
        return;
    }

    console.log(`나누기 결과 : ${result}`);

    add6(result, 10, (err2, result2) => {
        if (err2) {
            console.log(`에러 발생 -> ${err2}`);
            return;
        }

        console.log(`더하기 결과 : ${result2}`);


    })

})

// async ~ await

const add7 = (a, b) => new Promise((resolve, reject) => {
    add6(a, b, (err, result) => {
        if (err) {
            reject(err);
            return;
        }

        resolve(result);
    })
})

const divide7 = (a, b) => new Promise((resolve, reject) => {
    divide6(a, b, (err, result) => {
        if (err) {
            reject(err);
            return;
        }

        resolve(result);
    })
})

// 나누기를 먼저 하고 그 결과를 이용해서 더하기하기
const doCalc = async () => {

    try {

        //const result1 = await divide7(200, 10);
        const result1 = await divide7(200, 0);
        console.log(`doCalc 안에서 나누기 결과 : ${result1}`);

        const result2 = await add7(result1, 10);
        console.log(`doCalc 안에서 더하기 결과 : ${result2}`);

    } catch(err) {
        console.error(`doCalc 안에서 에러 발생 : ${err}`);
    }

}

doCalc();

