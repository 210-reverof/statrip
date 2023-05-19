<template>
  <div
    class="user-tag"
    onclick="event.cancelBubble = true;"
    @click="$router.push({ name: 'userPageMain', params: { usernickn: usernickn } }).catch(()=>{});

"
  >
    <b-row class="align-items-center">
      <div class="stat-box-a"></div>
      <div class="stat-box-b"></div>
      <div class="user-name">{{ usernickn }}</div>
    </b-row>
  </div>
</template>

<script>
export default {
  name: "UserTag",
  data() {
    return {
      usernickn: "",
    };
  },
  created() {
    this.usernickn = 'Jessica_jj'
  },
};
</script>

<style scoped>
.user-tag {
  padding: 10px;
  width: fit-content;
}

.user-name {
  padding-left: 10px;
  font-size: 18px;
}

.stat-box-a {
  width: 30px;
  height: 20px;
  background-color: blue;
}

.stat-box-b {
  width: 30px;
  height: 20px;
  background-color: coral;
  padding-left: 20px;
}
</style>
