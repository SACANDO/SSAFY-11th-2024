<template>
    <div>
        <h2>MyComponent</h2>
    </div>
    <MyComponentItem />
    <MyComponentItem />
    <MyComponentItem />
</template>

<script setup>
// 사용할 일이 없습니다... 왜냐면 지금 MyComponent는 자식을 갖을 게 없음!!
    import MyComponentItem from '@/components/MyComponentItem.vue'
</script>