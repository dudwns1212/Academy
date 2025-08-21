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

app.set('views', './database');
app.set('view engine', 'ejs')

const router = express.Router();
app.use('/', router);

router.route('/person/list').get(async(req,res) => {
    console.log(`/person/list 요청경로로 요청됨`);
    
    let conn;

    try {

        const sql = `select id, name, age, mobile from test.person`;
        conn = await pool.getConnection();
        let rows = await conn.query(sql,[]); 


        const context = {
            persons: rows
        }

        req.app.render('list', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
            res.end(html);
        })
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

router.route('/person/modify').get(async(req,res) => {
    console.log(`/person/modify 요청경로로 요청됨`);
    
    const params = req.query;
    console.log(`요청된 파라미터 : ${JSON.stringify(params)}`);

    let conn;

    try {

        let sql = `update test.person 
                        set name = '${params.name}', age = ${params.age}, mobile = '${params.mobile}'
                        where id = ${params.id}`
        conn = await pool.getConnection();
        let rows = await conn.query(sql, []); 

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

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
            res.end(html);
        })
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

router.route('/person/update').get(async(req,res) => {
    console.log(`/person/update 요청경로로 요청됨`);
    
    const params = req.query;
    console.log(`요청 파라미터 : 수정할 정보 ${JSON.stringify(params)}`);

    let conn;

    try {


        const context = {
            params: params
        }

        req.app.render('update', context, (err,html) => {
            if (err) {
                console.error(`뷰 처리 중 에러 -> ${err}`);
                return;
            }
            
            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
            res.end(html);
        })
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

router.route('/person/add').get(async (req, res) => {
    console.log(`/person/add 요청됨`)

    const params = req.query;

    let conn;

    try {

        const context = {
            params: params
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
    } finally {
        if (conn) { conn.end(); }
    }

})

router.route('/person/insert').get(async (req, res) => {
    console.log(`/person/insert 요청됨`)

    const params = req.query;
    console.log(`요청된 파라미터 : ${JSON.stringify(params)}`);

    let conn;

    try {

        let sql = `insert into test.person(name, age, mobile) values ('${params.name}', ${params.age}, '${params.mobile}')`;
        conn = await pool.getConnection();
        let rows = await conn.query(sql, []); 

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

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
            res.end(html);
        })
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

router.route('/person/delete').get(async (req, res) => {
    console.log(`/person/delete 요청됨`)

    const params = req.query;
    console.log(`요청된 파라미터 : ${JSON.stringify(params)}`);

    let conn;

    try {

        let sql = `delete from test.person where id = ${params.id}`;
        conn = await pool.getConnection();
        let rows = await conn.query(sql, []); 

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

            res.writeHead(200, {'Content-Type' : 'text/html;charset=utf-8'});
            res.end(html);
        })
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) { conn.end(); }
    }
})

const port = 7001;
http.createServer(app).listen(port, () => {
    console.log(`웹서버 실행됨 : ${port}`);
})

