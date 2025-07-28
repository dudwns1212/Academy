// 웹서버 만들기
// 1 모듈 불러오기
const http = require('http');
const express = require('express');
const mariadb = require('mariadb');

const pool = mariadb.createPool({
    host: 'localhost',
    port: 4406,
    user: 'root',
    password: 'admin'
})

const app = express();

app.set('views', './views');
app.set('view engine', 'ejs');

const router = express.Router();
app.use('/', router);

router.route('/page/list').get(async (req, res) => {
    console.log(`/page/list 요청됨`)

    let conn;
    try {
        // DB로 SQL문 실행 요청하기
        conn = await pool.getConnection();

        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql, []);  // rows 배열 안에 조회한 결과가 들어가 있음

        const context = {
            persons: rows
        }

        req.app.render('list', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

        res.writeHead(200, {'Content_Type' : 'text/html;charset=utf-8'});
        res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

router.route('/page/add').get(async (req, res) => {
    console.log(`/page/add 요청됨`)

    try {

        const context = {
            
        }

        req.app.render('add', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

        res.writeHead(200, {'Content_Type' : 'text/html;charset=utf-8'});
        res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    }

})

router.route('/page/change').get(async (req, res) => {
    console.log(`/page/change 요청됨`)

    try {

        const context = {
            
        }

        req.app.render('change', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

        res.writeHead(200, {'Content_Type' : 'text/html;charset=utf-8'});
        res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    }

})

router.route('/page/minus').get(async (req, res) => {
    console.log(`/page/minus 요청됨`)

    try {

        const context = {
            
        }

        req.app.render('minus', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

        res.writeHead(200, {'Content_Type' : 'text/html;charset=utf-8'});
        res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    }

})

router.route('/page/insert').get(async (req, res) => {
    console.log(`/page/insert 요청됨`)

    const params = req.query;
    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`)

    let conn;
    try {
        // DB로 SQL문 실행 요청하기
        conn = await pool.getConnection();

        let sql = `insert into test.person(name, age, mobile) values ('${params.name}', ${params.age}, '${params.mobile}')`;
        let rows = await conn.query(sql, []);  // rows 배열 안에 조회한 결과가 들어가 있음

        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, []);

        const context = {
            persons: rows
        }

        req.app.render('list', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

        res.writeHead(200, {'Content_Type' : 'text/html;charset=utf-8'});
        res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

router.route('/page/update').get(async (req, res) => {
    console.log(`/page/update 요청됨`)

    const params = req.query;
    const colume1 = params.colume1;
    const colume2 = params.colume2;
    const gets1 = params.gets1;
    const gets2 = params.gets2;

    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`)

    let conn;
    try {
        // DB로 SQL문 실행 요청하기
        conn = await pool.getConnection();

        let sql = `update test.person set ${params.colume1} = '${params.gets1}' where ${params.colume2} = '${params.gets2}'`;
        let rows = await conn.query(sql, []);  // rows 배열 안에 조회한 결과가 들어가 있음

        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, []);

        const context = {
            persons: rows
        }

        req.app.render('list', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

        res.writeHead(200, {'Content_Type' : 'text/html;charset=utf-8'});
        res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

router.route('/page/delete').get(async (req, res) => {
    console.log(`/page/delete 요청됨`)

    const params = req.query;
    const colume = params.colume;

    console.log(`요청 파라미터 -> ${JSON.stringify(params)}`)

    let conn;
    try {
        // DB로 SQL문 실행 요청하기
        conn = await pool.getConnection();

        let sql = `delete from test.person where ${params.colume} = '${params.gets}'`;
        let rows = await conn.query(sql, []);  // rows 배열 안에 조회한 결과가 들어가 있음

        sql = `select id, name, age, mobile from test.person`;
        rows = await conn.query(sql, []);

        const context = {
            persons: rows
        }

        req.app.render('list', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

        res.writeHead(200, {'Content_Type' : 'text/html;charset=utf-8'});
        res.end(html);
            
        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})


const port = 7001;
http.createServer(app).listen(port, () => {
    console.log(`웹서버 실행됨 -> port : ${port}`);
})



