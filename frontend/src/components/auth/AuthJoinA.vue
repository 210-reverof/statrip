<template>
    <div class="auth-join-a">
        회원가입 페이지 A
        <button @click="$router.push('/auth/joinb')">다음</button>
    </div>
</template>

<script>

export default {
    name: "AuthJoinA",
}
</script>
