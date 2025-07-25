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

// 5. 라우터 추가하기
const router = express.Router();
app.use('/', router);

router.route('/page/first').get((req, res) => {
    console.log(`/page/first 요청됨`);

    res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
    res.end(`
        <!DOCTYPE html>
        <html>
            <head>
                <meta charset="UTF-8">
                <title>웹서버에서 받아온 페이지</title>
            </head>
             <body>
                <h1>첫 번째 페이지</h1>
                
                <a href="/page/second">두 번째 페이지로</a>

             </body>
        </html>
    `);
});

router.route('/page/second').get((req, res) => {
    console.log(`/page/second 요청됨`)

    res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'})
    res.end('<h1>두번째 페이지</h>');
});