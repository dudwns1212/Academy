module.exports = {

    text_list_all: {
        sql: `select id, title, coments, likes, createDate, category
                from test.text`
    },

    text_list: {
        sql: `select id, title, coments, likes, createDate, category
                from test.text`,
        count: `select count(*) as total
                from test.text`,
        where: ` where #`,
        order: ` order by #`,
        page: ` limit #`

    },

    text_read: {
        sql: `select id, title, coments, likes, createDate, category
                from test.text
                where id = :id`
    },

    text_add: {
        sql: `insert into test.text(title, coments, likes, createDate, category)
                values
                (:title, :coments, :likes, :createDate, :category)`
    },

    text_modify: {
        sql: `update test.text 
                set title = :title,
                    coments = :coments,
                    likes = :likes,
                    createDate = :createDate,
                    category = :category
                where id = :id` 
    },

    text_remove: {
        sql: `delete from test.text
                where id = :id`
    }

}