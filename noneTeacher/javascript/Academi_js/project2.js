window.addEventListener('DOMContentLoaded', () => { // 그냥 인터페이스 접속하면 뜨게함
    console.log(`DOMContentLoaded 이벤트 호출됨.`);

    let outputtime = document.querySelector('#outputtime'); // outputtime에 시간 띄우기
    setInterval(() => {

        let curTime = moment().format('YYYY-MM-DD HH:mm:ss')
        outputtime.innerHTML = `<p>${curTime}</p>`;

    }, 1000) // 1초마다
})

function add() {
    // add함수 input에 입력한 값을 받아오기 위해서 정의(id가 adultCount인 input을 찾는 그런 느낌)
    let adultCount = document.querySelector('#adultCount')
    let chilldrenCount = document.querySelector('#childrenCount')
    let outputadd = document.querySelector('#outputadd');
    // input에 입력한 값을 받아오기
    let inputA = adultCount.value;
    let inputC = chilldrenCount.value;
    // 정수로 변환(입력값이 string으로 되어있음)
    let a = Number(inputA);
    let c = Number(inputC);
    // 문자를 입력해서 NaN이 뜨면 오류창 생성
    if(isNaN(a) || isNaN(c)) {
        alert(`숫자를 입력하지 않았습니다. 다시 입력해주세요.`)

        outputadd.innerHTML = ``;
        return;
    }

    let result = (a * 20000) + (c * 9900);
    
    // 야간할인
    // 아까 시간을 hour로 받음 6시 이후면 할인가 적용
    let hour = moment().hour();
    if(hour >= 18) {
        result = (a * 12000) + (c * 4500);
    } else {
        result;
    }

    // 단체할인
    // 이름이 sale인 입력창 찾기 
    let sales = document.getElementsByName('sale');
    let saleChecked = Array.from(sales).find(emem => emem.checked);
    console.log(`단체할인 적용 여부 : ${saleChecked.value}`);
    //이거는 그냥 체크가 되어있는 걸 확인하기 위한 만들어져있는 메서드임
    // 만약 yes체크 되어있다면 인원수 체크 후 5명 이상이면 할인(return으로 5명 미만인데 체크 되어있다면 결과값 안나오게 함)
    if(saleChecked.value == 'yes') {
        if(a+c<5) {
            alert(`단체할인이 적용되지 않습니다!`);
            return;

        }else {
            result = result * 0.8 // 20프로 할인
        }
    } else if (saleChecked.value == 'no') {
        if(a+c>5) {
            alert(`단체할인이 적용됩니다!`);
            return;
        }else {
            result;
        } 
    }
    // 출력값 outputadd에 띄우기
    outputadd.innerHTML = `${result.toLocaleString()}원`;
    // 만약 계산이 잘 되었으면 사진 보이게 display = 'block'
    if(result != NaN) {
        document.getElementById('win').style.display = 'block';
    }

}

function lotto() {
    // lotto()메서드
    // numbers라는 배열을 만들고 6개 넣을 수 있게 반복문 설정
    let numbers = [];            
    while (numbers.length < 6) {
        // 랜덤숫자 생성 1~80
        let num = Math.floor(Math.random()*80+1)
        // 만약 생성한 랜덤숫자가 배열에 포함되어 있다면 추가 안하고 다시 돌림
        if (!numbers.includes(num)) {
            numbers.push(num)
        }
    }
// niceDay를 찾고 배열을 출력하게 함
let winner = document.querySelector(`#niceDay`);
winner.innerHTML = `${numbers}`;

}
