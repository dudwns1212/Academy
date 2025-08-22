
const param = require('./param');

///
/// 데이터베이스 쿼리 기능을 도와주기 위한 헬퍼
///
class DatabaseHelper {

    constructor(db) {
        this.database = db;
    }

    ///
    /// SQL문 1개 실행 후 결과 반환
    ///
    /// sqlName: SQL문의 이름
    ///
    async query(sqlName, params) {
 
        const queryParams = {
            sqlName: sqlName,
            params: params,
            paramType: {}
        }

        const rows = await this.database.execute(queryParams);

        return rows;
    }

    ///
    /// 전체 레코드 개수 조회 후 반환
    ///
    /// sqlObj: SQL 객체의 이름 (sql, count, where, order, page 속성이 포함된 객체)
    ///
    async queryCount(sqlObj, params) {
 
        const sql = param.getCountSql(sqlObj, params);
        
        const queryParams = {
            sql: sql,
            sqlParams: []
        }
        const rows = await this.database.query(queryParams);

        let total = 0;
        if (rows && rows.length > 0) {
            total = rows[0].total;
        }

        return total;
    }

    ///
    /// 리스트용 SQL문 실행 후 반환
    ///
    /// sqlObj: SQL 객체의 이름 (sql, count, where, order, page 속성이 포함된 객체)
    ///
    async queryListOnly(sqlObj, params) {
 
        const sql = param.getSql(sqlObj, params);
        
        const queryParams = {
            sql: sql,
            sqlParams: []
        }
        const rows = await this.database.query(queryParams);

        return rows;
    }

    
    ///
    /// 페이지네이션을 포함한 리스트용 SQL문 실행 후 반환 -> { total, rows }
    ///
    /// sqlObj: SQL 객체의 이름 (sql, count, where, order, page 속성이 포함된 객체)
    ///
    async queryList(sqlObj, params) {
 
        const total = await this.queryCount(sqlObj, params);
        const rows = await this.queryListOnly(sqlObj, params);

        return { total, rows };
    }

}

module.exports = DatabaseHelper;
 