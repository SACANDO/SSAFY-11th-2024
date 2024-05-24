<template>
    <div>
        <h1>UserView</h1>
        <!-- 매개 변수를 사용한 동적 경로 매칭 방법1 -->
        <!-- 라우트의 매개변수는 $route.params 으로 참조 가능합니다. -->
        <!-- 우리는 id를 가져올 예정이니, $route.params.id -->
        <!-- text interpolation은 이제 .... 말 안해도... 알죠?  -->
        <!-- <h2>{{ $route.params.id }}번 페이지</h2> -->

        <!-- 매개 변수를 사용한 동적 경로 매칭 방법2 -->
        <!-- Composition API방식으로 작성하는 것을 권장합니다. -->
        <h2>{{ userId }}번 User 페이지</h2>

        <!-- router.push()로 집으로 goHome -->
        <button @click="goHome">집에가자</button>
        <!-- <RouterLink to="/">집에가자</RouterLink> -->

        <!-- router.replace()로 foreverAtHome -->
        <button @click="foreverAtHome">평생집에만있어요...</button>
        <!-- <RouterLink :to="{name: 'home'}" replace>평생집에만있어요...</RouterLink> -->

        <button @click="routeUpdate">100번 유저 페이지</button>
    </div>
</template>

<script setup>
    // 매개 변수를 사용한 동적 경로 매칭 방법2 
    import { ref } from 'vue'
    import { useRoute, useRouter } from 'vue-router'
    import { onBeforeRouteLeave, onBeforeRouteUpdate } from 'vue-router'

    const route = useRoute()
    const userId = ref(route.params.id) // $route.params.id 와 동일

    // router.push()사용
    const router = useRouter()

    const goHome = () => {
        // name 속성을 객체에 담아서 전송
        router.push({ name:'home' })
    }


    // router.push 인자 참고!!
    // https://router.vuejs.org/guide/essentials/navigation.html

    // literal string path
    // router.push('/users/alice')

    // object with path
    // router.push({ path: '/users/alice' })

    // named route with params to let the router build the url
    // router.push({ name: 'user', params: { username: 'alice' } })

    // with query, resulting in /register?plan=private
    // router.push({ path: '/register', query: { plan: 'private' } })

    // router.replace()사용
    // const foreverAtHome = () => {
    //     router.replace({name:'home'})
    // }


    // 사용자가 UserView를 떠날 시 
    // Home, About, Login 버튼 클릭시 팝업 창 출력하기
    onBeforeRouteLeave((to, from) => {
        console.log(to)
        console.log(from)
        const answer = window.confirm('정말 떠나실 건가요?')
        if (answer === false) {
            return false
        }
    })


    const routeUpdate = function () {
        router.push({ name: 'user', params: { id: 100 } })
    }


    // onBeforeRouteUpdate((to, from) => {
    //   userId.value = to.params.id
    // })
</script>