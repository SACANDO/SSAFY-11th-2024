// javascript를 실행하는 방법
// 1. js 파일을 html 안에다가 링크로 넣어서 -> Live Server로 열기 -> console창 확인
// 2. node.js 설치 -> 터미널에 node 파일이름.js
//   VSCode extension 중에 Code Runner 설치 => 화살표 아이콘

// 비동기 작업

setTimeout(function(){
    console.log("1초 후 실행.");
}, 1000);

console.log("바로 실행");