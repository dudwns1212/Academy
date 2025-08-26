// 성공 200,201 / 실패 400(누락), 401(로그인x/권한없음), 403(로그인o/권한없음), 409(중복된 정보), 500(서버오류)
const http = require('http');
const express = require('express');
const cors = require('cors'); 
const mariadb = require('mariadb');
const pool = mariadb.createPool({
    host: 'localhost',
    port: 4406,
    user: 'root',
    password: 'admin',
    database: 'test',
    supportBigNumbers: true
});

const router = express.Router();

const app = express();

app.use(cors());

app.use(express.json());

app.use('/', router);

// 로그인 요청 처리
router.route('/auth/login').post(async (req, res) => {
    // 프론트에서 온 데이터를 변수로 꺼냄 / req = 프론트에서 온 정보
    // 즉 email = req.body.email , password = req.body.password
    const { email, password } = req.body;
    console.log(`로그인 요청됨: ${email}`);

    let conn;
    try {
        conn = await pool.getConnection();

        const sql = `select * from test.person where email = '${email}' AND password = '${password}'`;
        const rows = await conn.query(sql);

        if (rows.length > 0) {
            const result = {
                code: 200,
                message: '로그인 성공',
                user: rows[0]
            };

            res.writeHead(200, { 'Content-Type': 'text/html;charset=utf-8' });
            res.end(JSON.stringify(result));
            } else {
            const result = {
                code: 401,
                message: '계정이 존재하지 않습니다.'
            };

            res.writeHead(401, { 'Content-Type': 'text/html; charset=utf-8' });
            res.end(JSON.stringify(result));
            }
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
});

router.route('/auth/register').post(async (req, res) => {
    const { name, email, password, age, mobile } = req.body;
    console.log(`회원가입 요청됨: ${email}`);
    // 필수정보 누락 오류
    if (!email || !password || !name) {
        const result = { code: 400, message: '필수 정보 누락' };
        res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
        return res.end(JSON.stringify(result));
    }
    
    let conn;
    try {
        conn = await pool.getConnection();

        const checkSql = `select * from test.person where email = '${email}'`;
        const result = await conn.query(checkSql);
        // email 같을 때 오류
        if (result.length > 0) {
            const isEmail = { code: 409, message: '이미 존재하는 이메일입니다' };
            res.writeHead(409, { 'Content-Type': 'text/html; charset=utf-8' });
            return res.end(JSON.stringify(isEmail));
        }

        const insertSql = `
            insert into test.person (name, email, password, age, mobile)
            values ('${name}','${email}', '${password}', ?, '${mobile}')
        `;
        await conn.query(insertSql,[age || 0]);

        const success = { code: 201, message: '회원가입 성공! 로그인 후 이용해주세요.' };
        // 성공
        res.writeHead(201, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(success));

    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
});

// 구조는 다 같음 이름 변경
router.route('/auth/updateName').post(async (req, res) => {
    const { name, email } = req.body;
    if (!name) {
        const result = { code: 400, message: '이메일과 이름이 필요합니다.' };
        res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
        return res.end(JSON.stringify(result));
    }
    let conn;
    try {
        conn = await pool.getConnection();
        await conn.query(`update test.person set name='${name}' where email='${email}'`);
        const success = { code: 200, message: '이름이 성공적으로 변경되었습니다.' };
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(success));
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
});

// 나이 변경
router.route('/auth/updateAge').post(async (req, res) => {
    const { age, email } = req.body;
    if (age == '') {
        const result = { code: 400, message: '이메일과 나이가 필요합니다.' };
        res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
        return res.end(JSON.stringify(result));
    }
    let conn;
    try {
        conn = await pool.getConnection();
        await conn.query(`update test.person set age=${age} where email='${email}'`);
        const success = { code: 200, message: '나이가 성공적으로 변경되었습니다.' };
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(success));
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
});

// 전화번호 변경
router.route('/auth/updateMobile').post(async (req, res) => {
    const { mobile, email } = req.body;
    if (!mobile) {
        const result = { code: 400, message: '이메일과 전화번호가 필요합니다.' };
        res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
        return res.end(JSON.stringify(result));
    }
    let conn;
    try {
        conn = await pool.getConnection();
        await conn.query(`update test.person set mobile='${mobile}' where email='${email}'`);
        const success = { code: 200, message: '전화번호가 성공적으로 변경되었습니다.' };
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(success));
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
});

// 비밀번호 변경
router.route('/auth/updatePassword').post(async (req, res) => {
    const { password, email } = req.body;
    if (!password) {
        const result = { code: 400, message: '이메일과 비밀번호가 필요합니다.' };
        res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
        return res.end(JSON.stringify(result));
    }
    let conn;
    try {
        conn = await pool.getConnection();
        await conn.query(`update test.person set password='${password}' where email='${email}'`);
        const success = { code: 200, message: '비밀번호가 성공적으로 변경되었습니다.' };
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(success));
    } catch (err) {
        console.error(`에러 발생 -> ${err}`);
    } finally {
        if (conn) conn.end();
    }
});

const port = 7001;
http.createServer(app).listen(port, () => {
    console.log(`✅ 서버 실행됨: http://localhost:${port}`);
});