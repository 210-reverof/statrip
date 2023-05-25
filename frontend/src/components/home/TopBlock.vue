<template>
  <div class="top-block">
    <div>
      <br>
      <div class="test">
        <h1>최고의 여행지</h1>
      </div>
      <b-button @click="moveToAddPlan" class="mx-3" variant="success">여행 경로 추가하기</b-button>
      <b-button @click="moveToHotspotAdd" class="mx-3" variant="dark">내 핫스팟 인증하기</b-button>
    </div>
  </div>
</template>
<script>
export default {
  methods: {
    moveToAddPlan() {
      this.$router.push('/plan/add');
    },
    moveToHotspotAdd(){
      this.$router.push({name: 'hotspotAdd'});

    }
  }
};
</script>

<style scoped>
.top-block {
  box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.3);
  background-image: url("@/assets/home/home-bg-1.png");
  background-size: cover;
  background-repeat: no-repeat;
  height: 600px;
}
</style>
