
//
function TaskHasDuration(duration){
    return new Promise((resolve, reject)=>{
        setTimeout(function(){
            resolve(duration);
        }, duration)
    });
}


// 비동기 방식
// TaskHasDuration(2000)
// .then((response)=>{console.log(response)})
// TaskHasDuration(2001)
// .then((response)=>{console.log(response)})

// 동기 방식
// TaskHasDuration(2000)
// .then((response)=>{
//     console.log(response)
//     return new TaskHasDuration(2001);
// })
// .then((response)=>{console.log(response)})


// Promise.all() : 모든 비동기작업이 다 완료되었을 때 뭘 하고 싶을 때.
// api 서버 json dat, img, css, ...., => 웹페이지.

// Promise.race() : 비동기작업 중에 하나만 완료되어도 가능할 때
// cdn : server1, server2 둘 중 하나 선택.

// Promise.all([
//     TaskHasDuration(2000),
//     TaskHasDuration(1500),
//     TaskHasDuration(3000),
//     TaskHasDuration(5000),
//     TaskHasDuration(4000)
// ])
// .then((response)=>{
//     console.log(response)
// })

Promise.race([
    TaskHasDuration(2000),
    TaskHasDuration(1500),
    TaskHasDuration(3000),
    TaskHasDuration(5000),
    TaskHasDuration(4000)
])
.then((response)=>{
    console.log(response)
})