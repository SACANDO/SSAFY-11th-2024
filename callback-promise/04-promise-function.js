// 프라미스는 그냥 사용하기 보다는
// 보통 함수의 반환형(프라미스를 생성해서 반환)으로 사용합니다.

let task; 

// 비동기 작업은 보통 서버에다 요청을 보냄.
// 주소, ... 등 파라미터가 있을 것임


function taskPromise(){
    // 사전작업 수행.
    // url에 요청 보내기.

    return new Promise((resolve, reject)=>{
        setTimeout(function(){ // 불확실한 작업이었는데
            task = true; 
            if( task === true){
                resolve("작업이 성공했습니다."); // 성공 상태 결정 
            } else {
                reject("작업이 실패했습니다."); // 실패 상태 결정
            }

        }, 1000);
    })
}

taskPromise()
.then((response)=>{
    console.log(`Promise resolved: ${response}`)
})
.catch((response)=>{
    console.log(`Promise rejected: ${response}`)
})
.finally(()=>{
    console.log('Promise completed.')
})