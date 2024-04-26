// callback => promise로 바꾸기

let foodExists; // 사료가 있는지 없는지
let waterExists;

// callback : 함수를 매개변수로 넘겨서, 나중에 조건이 되면 실행.

// 불확실한(비동기 작업 수행) -> 성공하면 성공 콜백
//                          -> 실패하면 실패 콜백.

// 비동기 작업 수행함수 => 프라미스를 반환하는 함수.
function tryEatFoodPromise(){
    return new Promise((resolve, reject)=>{
         // 비동기 작업(시간이 오래 걸려서 결과 확인에 시간이 다소 소요됨)
        setTimeout(function(){
            // 1초 후 확인해보니
            // 불확실한 작업을 수행
            foodExists = true; // <- 서버에서 결과를 얻어옴.
            if(foodExists){
                resolve("밥그릇에 사료가 있으니까 사료를 먹습니다."); // 성공 시점 결정
            } else {
                reject("사료가 없습니다!!!");
            }
        }, 1000);
    })
}


function tryDrinkWaterPromise(){
    return new Promise((resolve, reject)=>{
        setTimeout(function(){
            waterExists = false;
            if(waterExists) {
                resolve('물이 있어서 물을 마십니다.');
            } else {
                reject('물이 없습니다!!!');
            }
        })
    })
}

tryEatFoodPromise()
.then((response)=>{
    console.log(response);
    return tryDrinkWaterPromise();
})
.then((response)=>{
    console.log(response);
    // 두 개의 프라미스가 모두 성공했을 경우 대응 로직.
    console.log('사료도 먹고 물도 마셨으니 산책을 갑니다.')
})
.catch((response)=>{
    console.log(response);
})