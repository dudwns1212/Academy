module.exports = {

    product_list_all: {
        sql: `select id, name, lating, genre, path
                from test.product`
    },
    product_read: {
        sql: `select id, name, lating, genre, path
                from test.product
                where id = :id`
    }
}