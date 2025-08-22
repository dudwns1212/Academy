//분리하고 싶은 코드를 이 파일에 넣어줌
const calc = {
    add: function(a, b) {
        return a + b;
    }
}
//calc 객체를 부르는 쪽에서 사용하도록 함
module.exports = calc;