<template>
  <div class="top-block">
    <div>
      <br>
      <div class="test">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <h2><b>내 주위 통계로 보는 <span class="bright-text">다채로운 여행 기록</span></b></h2>
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

.bright-text {
  color: #eeeeee; /* 밝은 색상으로 변경할 색상 코드 입력 */
}
</style>
