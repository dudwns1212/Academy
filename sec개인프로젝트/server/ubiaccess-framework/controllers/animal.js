
const logger = require('../util/logger');

const Database = require('../database/database_mysql');

const DatabaseHelper = require('../util/database_helper');
const ControllerHelper = require('../util/controller_helper');

const animalSql = require('../database/sql/animal-sql');

/**
 * @Controller(path="/animal/v1")
 */
module.exports = class Animal {

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
        logger.debug(`Animal::listAll 호출됨.`);

        const sqlName = 'animal_list_all';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 리스트 조회하기 (페이지 단위로 조회하거나 조건으로 검색하는 것 포함)
    ///

    /**
     * @RequestMapping(path="/list", method="get,post")
     */
    async list(req, res) {
        logger.debug(`Animal::list 호출됨.`);

        const sqlObj = animalSql.animal_list;
        this.controllerHelper.executeList(req, res, sqlObj);

    }

    ///
    /// id를 이용해 하나 검색하기
    ///

    /**
     * @RequestMapping(path="/read", method="get,post")
     */
    async read(req, res) {
        logger.debug(`Animal::read 호출됨.`);

        const sqlName = 'animal_read';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 추가하기
    ///

    /**
     * @RequestMapping(path="/add", method="get,post")
     */
    async add(req, res) {
        logger.debug(`Animal::add 호출됨.`);

        const sqlName = 'animal_add';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 수정하기
    ///

    /**
     * @RequestMapping(path="/modify", method="get,post")
     */
    async modify(req, res) {
        logger.debug(`Animal::modify 호출됨.`);

        const sqlName = 'animal_modify';
        this.controllerHelper.execute(req, res, sqlName);

    }

    ///
    /// 삭제하기
    ///

    /**
     * @RequestMapping(path="/remove", method="get,post")
     */
    async remove(req, res) {
        logger.debug(`Animal::remove 호출됨.`);

        const sqlName = 'animal_remove';
        this.controllerHelper.execute(req, res, sqlName);
    }

}
