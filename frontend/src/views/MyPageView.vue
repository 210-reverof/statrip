<template>
  <div class="mypage">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "MyPageView",
};
</script>

<style scoped>
.mypage{
  min-height: 500px;
}
</style>