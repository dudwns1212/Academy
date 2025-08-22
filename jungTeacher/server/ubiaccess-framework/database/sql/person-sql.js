module.exports = {

    test_person_list: {
        sql: `select id, name, age, mobile
                from test.person`,
        count: `select count(*) as total 
                from test.person`,
        where: `where #`,
        order: `order by #`,
        page: `limit #`
    },

    test_person_list2: {
        sql: `select id, name, age, mobile
                from test.person
                where name like :name`
    }
}