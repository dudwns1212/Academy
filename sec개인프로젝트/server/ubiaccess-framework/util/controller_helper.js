
const param = require('./param');
const util = require('./util');

const DatabaseHelper = require('./database_helper');

///
/// 콘트롤러 기능을 도와주기 위한 헬퍼
///
class ControllerHelper {

    constructor(db) {
        this.databaseHelper = new DatabaseHelper(db);
    }

    ///
    /// SQL문 1개 실행 후 응답 전송
    ///
    /// sqlName: SQL문의 이름
    ///
    async execute(req, res, sqlName) {

        const params = param.parse(req);

        try {

            const rows = await this.databaseHelper.query(sqlName, params);
    
            const output = {
                header: {},
                data: rows
            }

            util.sendRes(res, 200, 'OK', output);

        } catch(err) {
            util.sendError(res, 400, `Error -> ${err}`);
        }

    }

    async executeLogin(req, res, sqlName) {
        const params = param.parse(req);

        try {
            const rows = await this.databaseHelper.query(sqlName, params);
            
            if (!rows || rows.length === 0) {
                // 사용자를 찾지 못했거나 비밀번호가 틀린 경우
                return util.sendError(res, 401);
            }

            // 로그인 성공
            const user = rows[0];
            const output = {
                header: {},
                data: { 
                    user: {
                        id: user.id,
                        email: user.email,
                        name: user.name,
                    }
                }
            }

            util.sendRes(res, 200, 'OK', output);

        } catch(err) {
            util.sendError(res, 500);
        }
    }

    async executeRegister(req, res, sqlName) {
        const params = param.parse(req);

        try {
        // 먼저 이메일 중복 체크
        const checkEmail = await this.databaseHelper.query('email_check', params);
        
        // 이메일이 이미 존재하면
        if (checkEmail && checkEmail.length > 0) {
            return util.sendError(res, 409, '이미 존재하는 이메일입니다.');
        }
        
        await this.databaseHelper.query(sqlName, params);

        const output = {
            header: {},
            data: {
                message: 'success',
                success: true
            }
        }
        
        util.sendRes(res, 200, '회원가입 성공!', output);

    } catch(err) {
        util.sendError(res, 500, '서버 오류입니다.');
    }
}

    ///
    /// 페이지네이션을 포함한 리스트용 SQL문 실행 후 응답 전송
    ///
    /// sqlObj: SQL 객체의 이름 (sql, count, where, order, page 속성이 포함된 객체)
    ///
    async executeList(req, res, sqlObj) {

        const params = param.parse(req);

        try {

            const { total, rows } = await this.databaseHelper.queryList(sqlObj, params);
 
            // 응답 전송
            const output = {
                header: {
                    page: params.page,
                    perPage: params.perPage,
                    total: total,
                    search: params.search,
                    searchValue: params.searchValue,
                    searchJoin: params.searchJoin,
                    searchLike: params.searchLike,
                    order: params.order,
                    orderDirection: params.orderDirection
                },
                data: rows
            }

            util.sendRes(res, 200, 'OK', output);

        } catch(err) {
            util.sendError(res, 400, `Error -> ${err}`);
        }

    }

}

module.exports = ControllerHelper;
