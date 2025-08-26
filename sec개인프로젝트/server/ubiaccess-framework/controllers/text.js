
const logger = require('../util/logger');

const Database = require('../database/database_mysql');

const DatabaseHelper = require('../util/database_helper');
const ControllerHelper = require('../util/controller_helper');

const textSql = require('../database/sql/text-sql');

/**
 * @Controller(path="/text/v1")
 */
module.exports = class text {

    constructor() {
        this.database = new Database('database_mysql');

        this.databaseHelper = new DatabaseHelper(this.database)
        this.controllerHelper = new ControllerHelper(this.database); 
    }

    ///
    /// 모든 데이터 조회하기
    ///

    /**
     * @RequestMapping(path="/list-all", method="get,post")
     */
    async listAll(req, res) {
        logger.debug(`Text::listAll 호출됨.`);

        const sqlName = 'text_list_all';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 리스트 조회하기 (페이지 단위로 조회하거나 조건으로 검색하는 것 포함)
    ///

    /**
     * @RequestMapping(path="/list", method="get,post")
     */
    async list(req, res) {
        logger.debug(`Text::list 호출됨.`);

        const sqlObj = textSql.text_list;
        this.controllerHelper.executeList(req, res, sqlObj);

    }

    ///
    /// id를 이용해 하나 검색하기
    ///

    /**
     * @RequestMapping(path="/read", method="get,post")
     */
    async read(req, res) {
        logger.debug(`Text::read 호출됨.`);

        const sqlName = 'text_read';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 추가하기
    ///

    /**
     * @RequestMapping(path="/add", method="get,post")
     */
    async add(req, res) {
        logger.debug(`Text::add 호출됨.`);

        const sqlName = 'text_add';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 수정하기
    ///

    /**
     * @RequestMapping(path="/modify", method="get,post")
     */
    async modify(req, res) {
        logger.debug(`Text::modify 호출됨.`);

        const sqlName = 'text_modify';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 삭제하기
    ///

    /**
     * @RequestMapping(path="/remove", method="get,post")
     */
    async remove(req, res) {
        logger.debug(`Text::remove 호출됨.`);

        const sqlName = 'text_remove';
        this.controllerHelper.execute(req, res, sqlName);
    }

}
