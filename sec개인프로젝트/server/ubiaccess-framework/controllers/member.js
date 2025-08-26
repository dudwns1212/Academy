
const logger = require('../util/logger');

const Database = require('../database/database_mysql');

const DatabaseHelper = require('../util/database_helper');
const ControllerHelper = require('../util/controller_helper');

const memberSql = require('../database/sql/member-sql');

/**
 * @Controller(path="/member/v1")
 */
module.exports = class Member {

    constructor() {
        this.database = new Database('database_mysql');

        this.databaseHelper = new DatabaseHelper(this.database)
        this.controllerHelper = new ControllerHelper(this.database); 
    }

    /**
     * @RequestMapping(path="/list", method="get,post")
     */
    async list(req, res) {
        logger.debug(`Member::list 호출됨.`);

        const sqlName = 'member_list';
        this.controllerHelper.executeList(req, res, sqlName);

    }

    ///
    /// 로그인
    ///

    /**
     * @RequestMapping(path="/login", method="get,post")
     */
    async login(req, res) {
        logger.debug(`Member::login 호출됨.`);

        const sqlName = 'member_login';
        this.controllerHelper.executeLogin(req, res, sqlName);

    }

    ///
    /// 회원가입
    ///

    /**
     * @RequestMapping(path="/register", method="get,post")
     */
    async register(req, res) {
        logger.debug(`Member::register 호출됨.`);

        const sqlName = 'member_register';
        this.controllerHelper.executeRegister(req, res, sqlName);

    }

    ///
    /// 수정하기
    ///

    /**
     * @RequestMapping(path="/modify", method="get,post")
     */
    async modify(req, res) {
        logger.debug(`Member::modify 호출됨.`);

        const sqlName = 'member_modify';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 삭제하기
    ///

    /**
     * @RequestMapping(path="/remove", method="get,post")
     */
    async remove(req, res) {
        logger.debug(`Member::remove 호출됨.`);

        const sqlName = 'member_remove';
        this.controllerHelper.execute(req, res, sqlName);
    }

}