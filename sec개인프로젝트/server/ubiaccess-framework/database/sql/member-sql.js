module.exports = {

    member_list: {
        sql: `select id, name, age, mobile, email, password
                from test.member`,
        count: `select count(*) as total 
                from test.member`,
        where: `where #`,
        order: `order by #`,
        page: `limit #`
    },

    member_register: {
        sql: `insert into test.member (name, email, password, age, mobile)
            values (:name, :email, :password, :age, :mobile )`
    },

    member_login: {
        sql: `select * from test.member where email = :email AND password = :password`
    },
    
    email_check: {
        sql: `select * from test.member where email = :email`
    },
    member_modify: {
        sql: `update test.member set name = :name, age = :age, mobile = :mobile, password = :password where email = :email`
    }
}