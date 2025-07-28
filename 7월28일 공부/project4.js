// 모듈 연결
const http = require('http');
const express = require('express');
const mariadb = require('mariadb');

const pool = mariadb.createPool({
    host: 'localhost',
    port: 4406,
    user: 'root',
    password: 'admin'
})

// 웹 서버 연결
const app = express();

app.set('views', './database');
app.set('view engine', 'ejs');

const router = express.Router();
app.use('/', router);

router.route('/page/allMenu').get(async (req, res) => {
    console.log(`/page/allMenu 요청됨`)
    let conn;
    try {
        conn = await pool.getConnection();
        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql, []);
        const context = {
            username: rows[0].name
        }

        req.app.render('allMenu', context, (err,html) => {
            if(err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'})
            res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }

})

router.route('/page/select').get(async (req, res) => {
    console.log(`/page/select 요청됨`)
    let conn;
    try {
        conn = await pool.getConnection();

        const sql = req.query;
        const rows = await conn.query(sql, []);

        const context = {
            username: rows[0].name,
            userage: rows[0].age,
            usermobile: rows[0].mobile
        }

        req.app.render('select', context, (err,html) => {
            if(err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'})
            res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }

})

router.route('/page/insert').get(async (req, res) => {
    console.log(`/page/insert 요청됨`)
    let conn;
    try {
        conn = await pool.getConnection();

        const sql = req.query;
        const rows = await conn.query(sql, []);

        const context = {
            username: rows[0].name,
            userage: rows[0].age,
            usermobile: rows[0].mobile
        }

        req.app.render('insert', context, (err,html) => {
            if(err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'})
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
    let conn;
    try {
        conn = await pool.getConnection();

        const sql = req.query;
        const rows = await conn.query(sql, []);

        const context = {
            username: rows[0].name,
            userage: rows[0].age,
            usermobile: rows[0].mobile
        }

        req.app.render('update', context, (err,html) => {
            if(err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'})
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
    let conn;
    try {
        conn = await pool.getConnection();

        const sql = req.query;
        const rows = await conn.query(sql, []);

        const context = {
            username: rows[0].name,
            userage: rows[0].age,
            usermobile: rows[0].mobile
        }

        req.app.render('delete', context, (err,html) => {
            if(err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'})
            res.end(html);

        })
    } catch(err) {
        console.error(`요청 처리 중 에러 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }

})

router.route('/page/result').get(async (req, res) => {
    console.log(`/page/result 요청됨`)
    let conn;
    try {
        conn = await pool.getConnection();

        const sql = req.query;
        const rows = await conn.query(sql, []);

        const context = {
            username: rows[0].name,
            userage: rows[0].age,
            usermobile: rows[0].mobile
        }

        req.app.render('result', context, (err,html) => {
            if(err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'})
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
