let foodExists; // 사료가 있는지 없는지
let waterExists; // 물이 있는지 없는지

// 작업의 순서: 사료를 먼저 먹은 후, 그다음 물을 마신다.
// 1. 사료가 있는지 체크
//    1.1 사료가 있다면 사료를 먹고 -> 물이 있는지 확인
//                                   1.1.1 물이 있다면 물을 마시고 => 산책하러 나감
//                                   1.1.2 물이 없다면 => 에러
//    1.2 사료가 없다면 => 에러

function tryEatFood(callback, errorCallback){
    setTimeout(function(){
        foodExists = true;
        if(foodExists) {
            console.log("사료가 있으므로 사료를 먹습니다");
            callback(); // 여기가 중첩되어야 함.
        } else {
            errorCallback();
        }
    }, 1000);
}

function tryDrinkWater(callback, errorCallback){
    setTimeout(function(){
        waterExists = true;
        if(waterExists) {
            callback();
        } else {
            errorCallback();
        }
    })
}

function eatErrorCallback(){
    console.log("사료가 없습니다!!!");
}

function drinkErrorCallback(){
    console.log("물이 없습니다!!!")
}

function drinkCallback(){
    console.log("물도 마셨으니 산책을 갑니다.");
}

tryEatFood(function(){tryDrinkWater(drinkCallback, drinkErrorCallback)}, eatErrorCallback);