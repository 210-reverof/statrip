<template>
  <div
    class="user-tag"
    onclick="event.cancelBubble = true;"
    @click="$router.push({ path: `/userpage/main/${userId}` }).catch(()=>{});
"
  >
    <b-row class="align-items-center">
      <div :style="getStatBoxStyle(firstType)" class="stat-box-a"></div>
      <div :style="getStatBoxStyle(secondType)" class="stat-box-b"></div>
      <div class="user-name">{{ userId }}</div>
    </b-row>
  </div>
</template>

<script>
import { getUserStat } from "@/api/stat";
export default {
  name: "UserTag",
  props: {
    userId: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      firstType: 0,
      secondType: 0,
    }
  },
  created() {
    console.log("usertag----------")
    console.log(this.userId)
    if (this.userId != "tmp") {
      getUserStat(this.userId, 
      ({data}) => {
        this.firstType = data.firstType;
        this.secondType = data.secondType;
      }
    , (error) => console.log(error)
    )
    }
  },
  methods: {
    getStatBoxStyle(type) {
      const colorMap = {
        12: "#FF0000", // 빨강
        14: "#FFA500", // 주황
        15: "#FFFF00", // 노랑
        25: "#00FF00", // 초록
        28: "#0000FF", // 파랑
        32: "#800080", // 보라
        38: "#FF00FF", // 분홍
        39: "#888888"  // 회색
      };

      return {
        backgroundColor: colorMap[type] || 'transparent'
      };
    }
  }
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
