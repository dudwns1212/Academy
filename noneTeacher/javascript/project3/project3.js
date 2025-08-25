// 모듈 불러오기 
const http = require('http');
const express = require('express');

// 앱서버 객체만들기
const app = express();

// 웹 서버 실행
http.createServer(app).listen(7001, () => {
    console.log('웹 서버 실행됨')
})

// 뷰 사용
app.set('views', './loginSystem');
app.set('view engine','ejs');

// 라우터 추가
const router = express.Router();
app.use('/', router);

router.route('/page/basic').get((req,res) => {
    console.log(`/page/basic 요청됨`)

    const context = {

    }

    req.app.render('basic', context, (err,html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`)
            return;
        }

        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);


    });
 
});

router.route('/page/allMenu').get((req, res) => {
    console.log(`/page/allMenu 요청됨`)

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`)

    const context = {
        username: params.username,
        password: params.password,
        menu: params.menu // 정의 안하면 오류남
    }

    req.app.render('allMenu', context, (err,html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`)
            return;
        }

        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);

    })

})

router.route('/page/customerMenu').get((req, res) => {
    console.log(`/page/customerMenu 요청됨`)

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`)

    const context = {
        menu: '고객관리',  // 메뉴 이름을 기억, 나머지도 같음
        username: params.username,
    }

    req.app.render('customerMenu', context, (err,html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`)
            return;
        }

        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);

    })

})

router.route('/page/productMenu').get((req, res) => {
    console.log(`/page/productMenu 요청됨`)

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`)

    const context = {
        menu: '상품관리',
        username: params.username,
        password: params.password
    }

    req.app.render('productMenu', context, (err,html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`)
            return;
        }

        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);

    })

})

router.route('/page/saleMenu').get((req, res) => {
    console.log(`/page/saleMenu 요청됨`)

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`)

    const context = {
        menu: '매출관리',
        username: params.username,
        password: params.password
    }

    req.app.render('saleMenu', context, (err,html) => {
        if(err) {
            console.error(`뷰 처리 중 에러 -> ${err}`)
            return;
        }

        res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
        res.end(html);

    })

})
