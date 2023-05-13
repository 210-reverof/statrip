<template>
  <header>
    <div class="container-fluid">
      <div>
        <ul>
          <li>
            <router-link to="/" style="color: Black">statrip</router-link>
          </li>
          <li>
            <router-link to="/plan" style="color: Black">MY PLAN</router-link>
          </li>
          <li>
            <router-link to="/hotspot" style="color: Black"
              >HOT SPOT</router-link
            >
          </li>
          <li>
            <router-link to="/share" style="color: Black">SHARE</router-link>
          </li>
          <li>
            <router-link to="/question" style="color: Black">Q&A</router-link>
          </li>
          <li>
            <router-link to="/mypage" style="color: Black">MY PAGE</router-link>
          </li>
        </ul>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "ConfirmHeader",
};
</script>
