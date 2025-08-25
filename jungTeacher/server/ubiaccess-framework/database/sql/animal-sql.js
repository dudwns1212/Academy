module.exports = {

    animal_list_all: {
        sql: `select id, type, name, age, mobile, path
                from test.animal`
    },

    animal_list: {
        sql: `select id, type, name, age, mobile, path
                from test.animal`,
        count: `select count(*) as total
                from test.animal`,
        where: ` where #`,
        order: ` order by #`,
        page: ` limit #`

    },

    animal_read: {
        sql: `select id, type, name, age, mobile, path
                from test.animal
                where id = :id`
    },

    animal_add: {
        sql: `insert into test.animal(type, name, age, mobile, path)
                values
                (:type, :name, :age, :mobile, :path)`
    },

    animal_modify: {
        sql: `update test.animal 
                set type = :type,
                    name = :name,
                    age = :age,
                    mobile = :mobile,
                    path = :path
                where id = :id` 
    },

    animal_remove: {
        sql: `delete from test.animal
                where id = :id`
    }

}