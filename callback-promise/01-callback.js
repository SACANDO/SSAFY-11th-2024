let foodExists; // 사료가 있는지 없는지

// callback : 함수를 매개변수로 넘겨서, 나중에 조건이 되면 실행.

// 불확실한(비동기 작업 수행) -> 성공하면 성공 콜백
//                          -> 실패하면 실패 콜백.

function tryEatFood(callback, errorCallback){
    // 비동기 작업(시간이 오래 걸려서 결과 확인에 시간이 다소 소요됨)
    setTimeout(function(){
        // 1초 후 확인해보니
        // 불확실한 작업을 수행
        foodExists = true; // <- 서버에서 결과를 얻어옴.
        if(foodExists){
            callback(); // 정상 콜백 실행.
        } else {
            errorCallback(); // 에러 콜백 실행.
        }
    }, 1000);
}

function callback(){
    console.log("사료를 먹습니다.");
}

function errorCallback(){
    console.log("사료가 없습니다!!!");
}

tryEatFood(callback, errorCallback);