<template>
    <div>
        <p> {{ myMsg }}</p>
        ParentGrandChild: <ParentGrandChild :my-msg="myMsg"/>

        <!-- $emit 을 사용 -->
        <!-- <button @click="$emit('someEvent')">전송</button> -->

        <!-- defineEmits buttonClick 사용 -->
        <button @click="buttonClick">클릭</button>
        <button @click="emitArgs">추가 이자 전달</button>

    </div>
</template>

<script setup>
    import ParentGrandChild from '@/components/ParentGrandChild.vue'
    // 1. props를 받을때 문자배열은 명시적이지 않다!
    // defineProps(['myMsg'])

    // 2. 객체 
    const props = defineProps({
        myMsg: String,
    })

    console.log(props)
    console.log(props.myMsg)


    // defineEmits
    const emit = defineEmits(['someEvent', 'emitArgs'])

    const buttonClick = () => {
        emit('someEvent')
    }

    const emitArgs = function() {
        emit('emitArgs', 2024 ,5, 2)
    }

</script>
