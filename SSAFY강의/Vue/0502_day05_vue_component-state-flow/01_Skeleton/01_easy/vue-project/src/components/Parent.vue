<template>
    <div>
        <!-- Parent에서 ParentChild에 보낼 props -->
        <!-- my-msg prop 이름, 자식에게 전해줄때는 kebab-case이어야 한다. -->
        <!-- message prop 값 -->
        ParentChild: <ParentChild my-msg="엄마 사랑해요!"/>

        <!-- Dynamic Props 정의 -->
        <!-- ParentChild: <ParentChild my-msg="아빠 사랑해요!" :dynamic-props="name" /> -->

        <!-- Parent 에서는 v-on 으로 ParentChild에서 보낸 이벤트 수신 -->
        <!-- 수신 후 처리할 로직 및 콜백함수 호출 -->
        <!-- ParentChild: <ParentChild @some-event="someCallback" my-msg="엄마 사랑해요!" :dynamic-props="name"/> -->

        <!-- 이벤트 인자 전달 받기 -->
        <!-- <ParentChild 
            @some-event="someCallback"
            @emit-args="getNumbers"
            my-msg="엄마 사랑해요!"
            :dynamic-props="name"
        /> -->
    </div>
</template>

<script setup>
import ParentChild from '@/components/ParentChild.vue'
// Dynamic Props 정의
// import { ref } from 'vue'
// const name = ref('Alice')

// const someCallback = function() {
//     console.log('ParentChild가 발신한 이벤트를 수신했습니다')
// }

// const getNumbers = function(...args) {
//     console.log(args)
//     console.log(`ParentChild가 전달한 추가인자 ${args}를 수신했어요.`)
// }
</script>
