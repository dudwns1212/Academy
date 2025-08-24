module.exports = {

    test_list1: {
        sql: `select id,title, contents, image, time
                from test.list`,
        count: `select count(*) as total
                from test.list`,
        where: `where #`,
        order: `order by #`,
        page: `limit #`
    }
}