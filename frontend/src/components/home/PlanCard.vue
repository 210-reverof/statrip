<template>
  <div class="plan-card">
    <div class="card-background">
      <user-tag class="user-tag"></user-tag>
      <b-row class="image-row">
        <img class="thumbnail" src="https://via.placeholder.com/400x300" />
        <img class="thumbnail" src="https://via.placeholder.com/400x300" />
        <img class="thumbnail" src="https://via.placeholder.com/400x300" />
      </b-row>
      <b-row class="content-row">
        <div class="left-align">
          <p>여행지 개수: 3 최소 이동 거리: 1234km</p>
        </div>
        <div class="right-align">
          <p>2021.03.17</p>
        </div>
      </b-row>
    </div>
  </div>
</template>

<script>
import UserTag from "../common/UserTag.vue";
export default {
  components: {
    UserTag,
  },
};
</script>

<style scoped>
.plan-card {
  margin: 60px;
}

.card-background {
  background-color: white;
  border-radius: 10px;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.3);
}

.user-tag {
  padding-left: 60px;
  padding-top: 40px;
}

.image-row {
  display: flex;
  justify-content: center;
  align-items: center;
}

.thumbnail {
  padding: 60px;
}

.content-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.left-align {
  text-align: left;
  margin-left: 60px;
  margin-bottom: 20px;
}

.right-align {
  text-align: right;
  margin-right: 60px;
  margin-bottom: 20px;
}
</style>
