아카데미 자바 스크립트 예습 - 웹페이지에 컬러 피커 띄우기
const text = document.querySelector('#colorText');
const color = document.querySelector('#colorPicker');

// 컬러 피커를 조작할 때의 일련의 동작
const colorBg = () => {
    // 선택한 색을 배경색으로 설정
    document.body.style.backgroundColor = color.value;

    // 컬러 코드 표시
    if (color.value === '#ffffff') {
        text.textContent = '컬러 코드 : ${color.value} (white)';
    } else if (color.value === '#000000') {
        text.textContent = '컬러 코드 : ${color.value} (black)'; 
    } else {
        text.textContent = '컬러 코드 : ${color.value}';
    }
}

// 컬러 피커가 변경되면 colorBg 실행
color.addEventListener('input', colorBg)

console.log('준비완료');
