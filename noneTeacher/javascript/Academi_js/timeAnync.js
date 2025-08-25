const { reject } = require("async");
const { resolve } = require("path");

const add1 = (a, b, callback) => {
    setTimeout(() => {
        const result = a + b;
        callback(null, result);
    }, 500)
}

const divide1 = (a, b, callback) => {
    setTimeout(() => {
        if (b == 0) {
            callback(`두 번째 값이 0 입니다.`, null);
            return;
        }

        const result = a / b;
        callback(null, result);

    }, 1000)
}
// 이렇게 콜백 함수를 만들고 이제 Promise를 이용해서 리턴을 받을 수 있게 형태를 변환

const divide2 = (a, b) => new Promise((resolve, reject) => {
    divide1(a, b, (err,result) => {
        if (err) {
            reject(err);
            return;
        }

        resolve(result);
    })
})

const add2 = (a, b) => new Promise((resolve,reject) => {
    add1(a, b, (err, result) => {
        if (err) {
            reject(err);
            return;
        }

        resolve(result);

    })
})

// async/await로 순차처리
const doCalc = async() => {
    try{
        
        const result1 = await divide2(200,10);
        console.log(`나누기 결과 : ${result1}`);

        const result2 = await add2(result1, 10);
        console.log(`더하기 결과 : ${result2}`);

    } catch (err){
        console.error(`에러발생 -> ${err}`);
    }
}

doCalc();
