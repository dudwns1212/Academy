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

router.route('/page/first').get(async (req, res) => {
    console.log(`/page/first 요청됨`)

    let conn;
    try {
        // DB로 SQL문 실행 요청하기
        conn = await pool.getConnection();

        const sql = `select id, name, age, mobile from test.person`;
        const rows = await conn.query(sql, []);  // rows 배열 안에 조회한 결과가 들어가 있음

        const context = {
            username: rows[0].name
        }

        req.app.render('first', context, (err,html) => {
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



