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

// 6. 뷰 사용을 위해 설정하기
app.set('views', './views'); // 뷰를 사용, views라는 폴더 사용
app.set('view engine', 'ejs');



// 4. 미들웨어 추가하기



// 5. 라우터 추가하기
const router = express.Router();
app.use('/', router);

router.route('/page/login').get((req, res) => {
    console.log(`/page/login 요청됨`)
    
    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`);

    const context = {
        name: params.name
    }

    req.app.render('login', context, (err,html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        
        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);
    })

});

router.route('/page/first').get((req, res) => {
    console.log(`/page/first 요청됨`);

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`);

    const context = {
        username: '고영준'
    };

    req.app.render('first', context, (err, html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        
        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);

    })

});

router.route('/page/second').get((req, res) => {
    console.log(`/page/second 요청됨`)

    const params = req.query;

    const context = {

        name: params.name

    }

    req.app.render('second', context, (err,html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`);
            return;
        }
        
        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);
    })
});