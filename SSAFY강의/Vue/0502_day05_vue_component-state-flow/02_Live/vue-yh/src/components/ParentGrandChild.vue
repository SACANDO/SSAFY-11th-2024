<template>
    <div>
        {{ myMsg }}
    </div>
</template>

<script setup>
    defineProps({
        myMsg: String,
    })
</script>
