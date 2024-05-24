// node.js를 설치했다면 `node script.js`으로 실행 가능


// Object 선언
<<<<<<< HEAD
// name: "haley", hobby: "golf", age: 20, 
const myObject = { 
  // 코드를 입력해보세요.



  
}

// Object to JSON - stringify()
// JSON.stringfy(Object)
const objToJson = JSON.stringify(myObject)
                              // 어떤 값들이 출력될지 맞춰보세요.
console.log(objToJson)        // 
console.log(typeof objToJson) // 
console.log(objToJson.age)    // 
console.log(objToJson[0])     // 
=======
const myObject = { 
  name: "haley", 
  hobby: "golf", 
  age: 20, 
}

// Object to JSON - stringfy()
// JSON.stringfy(Object)
const objToJson = JSON.stringify(myObject)

console.log(objToJson)        // {"name": "haley"...."age": 20}
console.log(typeof objToJson) // string
console.log(objToJson.age)    // undefined
console.log(objToJson[0])     // {
>>>>>>> b98a0d1b4f329df772afa265046aaec03fdeb220


// JSON to Object - parse()
// JSON.parse(JSON)
const jsonToObj = JSON.parse(objToJson)
<<<<<<< HEAD
                                  // 어떤 값들이 출력될지 맞춰보세요.
console.log(jsonToObj)            // {name: "haley", hobby: "golf", age:20} // <- JSON -> Object 변환했을 때
console.log(typeof jsonToObj)     // 
console.log(typeof jsonToObj.age) // 
console.log(jsonToObj["age"])     // 
=======

console.log(jsonToObj)            // {name: "haley", hobby: "golf", age:20}
console.log(typeof jsonToObj)     // object
console.log(typeof jsonToObj.age) // 20
console.log(jsonToObj["age"])     // 20
>>>>>>> b98a0d1b4f329df772afa265046aaec03fdeb220
