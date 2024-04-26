// 비동기 함수: 프라미스를 반환하는 함수
function TaskHasDuration(duration){
    return new Promise((resolve, reject)=>{
        setTimeout(function(){
            resolve(duration);
        }, duration)
    });
}

// async function은 값이 아니라 Promise를 감싸서 반환.
function timeout(duration){
    return new Promise(resolve=> setTimeout(resolve, duration));
}

async function TaskAsyncFunction(duration){
    await timeout(duration);
    return duration;
}

// async function
// 함수 앞에 async 키워드를 붙이면
// 그 함수는 프라미스를 반환.

// await 프라미스 앞에 붙인다.
// 비동기적 성격의 프라미스를 동기화된 값으로 변경
// - 최상위 코드 레벨에서 쓰지 않는다.

// TaskAsyncFunction(2000)
// .then((response)=>{
//     console.log(response)
// })

async function main(){
    let duration1 = await TaskAsyncFunction(2000);
    console.log(duration1);
    let duration2 = await TaskAsyncFunction(2001);
    console.log(duration2);
    
}

main();