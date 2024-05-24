<template>
    <div>
        <!-- props -->
        <!-- PrentChild: <ParentChild my-msg="아빠 건강해요!!"/> -->


        <!-- emit event할거니깐! -->
        PrentChild: 
        <ParentChild 
            @some-event="someCallback"
            @emit-args="getBirthday"
        /> 

    </div>
</template>

<script setup>
    import ParentChild from '@/components/ParentChild.vue'
    const someCallback = function(){
        console.log('승호야 생일축하해~~~')
    }

    const getBirthday = function(...args) {
        console.log(args)
        console.log(`오늘은 승호의 생일, ${args}입니다 <3 !!!`)
    }
</script>
