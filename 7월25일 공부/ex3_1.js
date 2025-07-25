// 웹서버 만들기

// 1. 다른 개발자가 만든 모듈 불러오기
const http = require('http');
const express = require('express');

// 2. 익스프레스를 이용해서 웹서버를 위한 객체 만들기
const app = express();

// 3. 웹서버 실행하기     
// http라는 다른 개발자가 만들어놓은 코드에 createServer라는 함수를 실행
// 메서드 안에 메서드? 콜백함수 listen -> 
// 7001번 포트로 웹서버가 대기하게 함
http.createServer(app).listen(7001, () => {
    console.log(`웹서버 실행됨`);
});

// 4. 미들웨어 추가하기
app.use((req, res, next) => {
    console.log(`첫번째 미들웨어 호출됨`);
    
    next();

})

app.use((req, res, next) => {
    console.log(`두번째 미들웨어 호출됨`);

    res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
    res.end('<h1>웹서버에서 전달받은 페이지</h1>');
});