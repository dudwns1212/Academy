const param = require('../util/param');


class DatabaseHelper {

    constructor(db) {
        this.database = db;
    }

    async query(sqlName, params) {

        const queryParams = {
            sqlName: sqlName,
            params: params,
            paramType: {}
        }

        const rows = await this.database.execute(queryParams);

        return rows;
    }

    async queryList(sqlObj, params) {

        const total = await this.queryCount(sqlObj, params);
        const rows = await this.queryListOnly(sqlObj, params);

        return { total, rows };
    }
}

module.exports = DatabaseHelper;