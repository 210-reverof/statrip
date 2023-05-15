<template>
  <header class="custom-header">
    <b-navbar type="dark">
      <b-navbar-brand to="/">
        <img src="@/assets/common/logo_white.png" style="max-width: 100px; max-height: 60px; padding-left: 20px;" class="mr-2" />
      </b-navbar-brand>
      <b-nav class="ml-auto">
        <router-link to="/plan" class="nav-link">MY PLAN</router-link>
        <router-link to="/hotspot" class="nav-link">HOT SPOT</router-link>
        <router-link to="/share" class="nav-link">SHARE</router-link>
        <router-link to="/mypage" class="nav-link">MY PAGE</router-link>
      </b-nav>
    </b-navbar>
  </header>
</template>

<script>
export default {
  name: "ConfirmHeader",
};
</script>

<style>
.nav-link {
  color: white;
  text-decoration: none;
}

.router-link-active.nav-link {
  color: grey;
}

.custom-header {
  background-color: #323F30;
  font-family: 'Hahmlet', sans-serif;
  padding-top: 10px;
  padding-bottom: 10px;
}
</style>