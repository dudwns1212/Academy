const util = require('../util/util');
const param = require('../util/param');

const Database = require('../database/database_mysql');
const DatabaseHelper = require('../util/database_helper');
const DatabaseHelper2 = require('../util/database_helper2');
const ControllerHelper = require('../util/controller_helper');

const personSql = require('../database/sql/person-sql');


/**
 * @Controller(path="/person")
 */
class Person {
    constructor() {
        this.database = new Database('database_mysql');
        this.databaseHelper = new DatabaseHelper(this.database);
        this.databaseHelper2 = new DatabaseHelper2(this.database);
        this.controllerHelper = new ControllerHelper(this.database);
    }

    /**
     * @RequestMapping(path="/list", method="get,post")
     */
    async testPersonList(req, res) {
        const params = param.parse(req);
        
        try {

            //테이블에 들어있는 전체 레코드 개수 조회
            let sql = param.getCountSql(personSql.test_person_list, params);

            let queryParams = {
                sql: sql,
                sqlParams: []
            }

            let rows = await this.database.query(queryParams);
            const total = rows[0].total;

            //레코드 조회를 위한 SQL문 실행
            sql = param.getSql(personSql.test_person_list, params);

            queryParams = {
                sql: sql,
                sqlParams: []
            }

            rows = await this.database.query(queryParams);

            //응답 전송
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

            util.sendRes(res, 200, 'ok', output);


        } catch(err) {
            util.sendError(res, 400, `Error -> ${err}`);
        }
    }

    /**
     * @RequestMapping(path="/list2", method="get,post") 
     */
    async testPersonList2(req, res) {
        const params = param.parse(req);

        try {

            const rows = await this.databaseHelper.query('test_person_list2', params);

            const output = {
                header: {

                },
                data: rows
            }

            util.sendRes(res,200,'ok',output);

        } catch(err) {
            util.sendError(res,400,`Error -> ${err}`);
        }
    }

    /**
     * @RequestMapping(path="/list3", method="get,post") 
     */
    async testPersonList3(req, res) {
        const params = param.parse(req);

        try {

            const rows = await this.databaseHelper.query('test_person_list2', params);

            const output = await this.databaseHelper2.aaa(rows);

            util.sendRes(res,200,'ok',output);

        } catch(err) {
            util.sendError(res,400,`Error -> ${err}`);
        }
    }

    /**
     * @RequestMapping(path="/list4", method="get,post") 
     */
    async testPersonList4(req, res) {

        const sqlName = 'test_person_list2';
        this.controllerHelper.execute(req, res, sqlName);

    }

}

module.exports = Person;