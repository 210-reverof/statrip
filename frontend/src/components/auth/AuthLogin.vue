<template>
    <div class="auth-login">
        로그인 페이지
        <button @click="$router.push('/auth/joina')">아직 회원이 아니신가요?</button>
    </div>
</template>

<script>

export default {
    name: "AuthLogin",
}
</script>
