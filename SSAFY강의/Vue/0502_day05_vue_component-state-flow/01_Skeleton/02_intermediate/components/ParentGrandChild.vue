<template>
    <div>
        <!-- 상위컴포넌트로부터 전달받은 props를 반응형 변수를 활용해서 보여준다. -->
        <p>{{ myMsg }}</p>
    </div>
</template>

<script setup>
    // ParentChild로 받은 값이 아니다. Parent에 정의되어 있는 Prop이다.
    defineProps({
        myMsg: String,
    })
</script>

