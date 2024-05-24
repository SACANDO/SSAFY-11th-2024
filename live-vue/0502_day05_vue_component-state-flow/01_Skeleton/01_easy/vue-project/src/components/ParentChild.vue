<template>
    <div>
        <!-- template에서 반응형 변수와 같은 방식으로 활용 가능 -->
        <p>{{ myMsg }}</p>
        <!-- Parent로 받은 데이터를 ParentGrandChild로 보내줄때는 v-bind를 사용한 동적 props 진행 -->
        ParentGrandChild: <ParentGrandChild :my-msg="myMsg"/>

        <!-- Dynamic Props 선언 및 출력 -->
        <!-- <p>{{ dynamicProps }}</p> -->

        <!-- $emit 발생시키기 -->
        <!-- <button @click="$emit('someEvent')">클릭</button> -->

        <!-- defineEmits(['someEvent'])  활용-->
        <!-- <button @click="buttonClick">클릭</button> -->

        <!-- defineEmits([emitArgs'])  활용 -->
        <!-- <button @click="emitArgs">추가인자 전달</button> -->
    </div>
</template>

<script setup>

    import ParentGrandChild from '@/components/ParentGrandChild.vue'

    // 1. 문자열 배열을 사용한 선언
    // defineProps()를 사용하여 props선언
    // defineProps(['myMsg'])

    // 2. 객체를 사용한 선언 (권장)
    // defineProps({
    //     myMsg: String,
    // })

    // 부모에서는 my-msg로 보내줬고 자식에서 myMsg로 받음
    const props = defineProps({ myMsg: String })
    console.log(props) // {myMsg: 'message'}
    console.log(props.myMsg) // message

    // Dynamic Props 선언 및 출력
    // defineProps({
    //     myMsg: String,
    //     dynamicProps: String,
    // })


    // $emit 대신에 defineEmits() 
    // const emit = defineEmits(['someEvent', 'emitArgs'])

    // const buttonClick = function() {
    //     // someEvent는 부모로 넘어가면 some-event이겠쬬?
    //     emit('someEvent')
    //     console.log('\t이번에는 defineEmits 사용해봤어요')
    // }

    // const emitArgs = function() {
    //     emit('emitArgs', 1, 2, 3) 
    // }
</script>
