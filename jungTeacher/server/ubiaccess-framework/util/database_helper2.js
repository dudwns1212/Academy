const DatabaseHelper = require('../util/database_helper');
const Database = require('../database/database_mysql');

class DatabaseHelper2 {

    constructor (){
        this.database = new Database('database_mysql');
        this.databaseHelper = new DatabaseHelper(this.database);
    }
    async bbb(sqlName, params) {  
          
        const rows = await this.database.execute(sqlName, params);

        return rows;
    }
    
    async aaa(rows) {

        const output = {
            header: {

            },
            data: rows
        } 
        return output;

    }
    
}


module.exports = DatabaseHelper2;