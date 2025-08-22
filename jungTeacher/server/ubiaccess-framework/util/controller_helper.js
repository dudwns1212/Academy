
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
