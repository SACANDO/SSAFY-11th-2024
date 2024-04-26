let task;


const p = new Promise((resolve, reject)=>{
    setTimeout(function(){ // 불확실한 작업이었는데
        task = true; 
        if( task === true){
            resolve("작업이 성공했습니다."); // 성공 상태 결정 
        } else {
            reject("작업이 실패했습니다."); // 실패 상태 결정
        }

    }, 1000);
})

// 성공, 실패 로직은 p.then(), .catch(), .finally()에 작성한다.


p.then((response)=>{
    console.log(`Promise resolved: ${response}`)
})
.catch((response)=>{
    console.log(`Promise rejected: ${response}`)
})
.finally(()=>{
    console.log('Promise completed.')
})