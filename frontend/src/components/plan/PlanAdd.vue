<template>
  <div class="plan-add">
    <plan-display
      :planItemList="planItemList"
      :curLength="curLength"
      @delete-click="deletePlan"
      @dragged="draggedItem"
    ></plan-display>
    <div class="follower-chart">
      <div v-for="(plan, index) in followPlanUserList" :key="index">
        <div :style="colorStyle[index]">{{ plan.userId }}</div>
      </div>
    </div>
    <div class="map-block">
      <kakao-map
        ref="kakaomap"
        :kakaoMapType="1"
        :planItemList="planItemList"
        :followPlanList="followPlanList"
        @marker-click="addPlanToMarker"
        @get-lenght="getCurLength"
      ></kakao-map>
      <b-button v-b-toggle.sidebar-right class="search-bar-button"
        >여행지 검색</b-button
      >
      <plan-search @search-click="addPointToMap"></plan-search>
    </div>
  </div>
</template>

<script>
import { getSelectedPlan, getPlan } from "@/api/plan";

import KakaoMap from "@/components/plan/KakaoMap.vue";
import PlanDisplay from "@/components/plan/side/PlanDisplay.vue";
import PlanSearch from "@/components/plan/side/PlanSearch.vue";
import { mapState } from "vuex";
const attractionStore = "attractionStore";

export default {
  name: "PlanAdd",
  components: {
    KakaoMap,
    PlanDisplay,
    PlanSearch,
  },
  data() {
    return {
      planItemList: [],
      followPlanList: [],
      followPlanUserList: [],
      curLength: "",
      colorStyle: [
        {backgroundColor:"#FFA500"}, // 주황
        {backgroundColor:"#FFFF00"}, // 노랑
        {backgroundColor:"#00FF00"}, // 초록
        {backgroundColor:"#0000FF"}, // 파랑
        {backgroundColor:"#800080"}, // 보라
      ],
    };
  },
  methods: {
    getUserId() {
      this.followPlanUserList = [];
      for (let i = 0; i < this.followPlanList.length; i++) {
        getPlan(
          this.followPlanList[i].planId,
          ({ data }) => {
            this.followPlanUserList.push(data);
            console.log(this.followPlanUserList);
          },
          (error) => console.log(error)
        );
      }
    },
    addPointToMap(plan) {
      let flag = true;
      console.log("addPointToMap--------start");
      console.log(plan.contentId);
      console.log(this.planItemList);
      this.planItemList.forEach((element) => {
        console.log("num-------------");
        console.log(element.contentId);
        if (element.contentId == plan.contentId) {
          flag = false;
        }
      });
      if (flag == true) this.planItemList.push(plan);
      console.log("addPointToMap--------end");
      // this.$refs.kakaomap.addPoint(plan);
    },
    addPlanToMarker(plan) {
      let flag = true;
      console.log("addPlanToMarker--------start");
      console.log(plan.contentId);
      console.log(this.planItemList);
      this.planItemList.forEach((element) => {
        console.log("num-------------");
        console.log(element.contentId);
        if (element.contentId == plan.contentId) {
          flag = false;
        }
      });
      if (flag == true) this.planItemList.push(plan);
      console.log("addPlanToMarker--------end");

      // this.$refs.kakaomap.addPoint(plan);
    },
    getCurLength(curLength) {
      this.curLength = curLength;
    },
    deletePlan(index) {
      console.log("deletePlan");
      this.planItemList.splice(index, 1);
    },
    draggedItem(attractionList) {
      console.log("draggedPlan" + attractionList);
      this.planItemList = attractionList;
    },
  },
  computed: {
    ...mapState(attractionStore, ["sidos", "guguns", "attractions"]),
  },
  watch: {
    planItemList() {
      if (this.planItemList) {
        const params = new URLSearchParams();
        this.planItemList.forEach((element) => {
          params.append("sel", element.contentId);
        });
        console.log(params);
        getSelectedPlan(
          params,
          ({ data }) => {
            this.followPlanList = [];
            if (data) {
              for (let i = 0; i < 5; i++) {
                if (data[i]) {
                  this.followPlanList.push(data[i]);
                } else break;
              }
            }
            // this.followPlanList = data;
            // if (this.followPlanList.length > 5) {
            //   this.followPlanList = this.followPlanList.slice(0, 5);
            // }
            console.log("azzzzzzzzzzzzzzzzzzzzzzzzzz");
            this.getUserId()
            console.log(this.followPlanList);
            console.log(this.followPlanUserList);
            console.log("azzzzzzzzzzzzzzzzzzzzzzzzzz");
          },
          (error) => {
            console.log(error);
          }
        );
        // getSelectedPlan(
        //   params,
        //   ({ data }) => {
        //     this.followPlanList = [];
        //     this.followPlanUserList = [];
        //     if (data) {
        //       for (let i = 0; i < 5; i++) {
        //         if (data[i]) {
        //           this.followPlanList.push(data[i]);
        //           console.log(this.followPlanList);
        //           getPlan(
        //             data[i].planId,
        //             ({ response }) => {
        //               this.followPlanUserList.push(response);
        //               console.log(this.followPlanUserList);
        //             },
        //             (error) => console.log(error)
        //           );
        //         } else break;
        //       }
        //     }
        //     // this.followPlanList = data;
        //     // if (this.followPlanList.length > 5) {
        //     //   this.followPlanList = this.followPlanList.slice(0, 5);
        //     // }
        //     console.log("azzzzzzzzzzzzzzzzzzzzzzzzzz");
        //     console.log(this.followPlanList);
        //     console.log("azzzzzzzzzzzzzzzzzzzzzzzzzz");
        //   },
        //   (error) => {
        //     console.log(error);
        //   }
        // );
      }
    },
  },
};
</script>

<style scoped>
.plan-add {
  display: flex;
  width: 100%;
}

.plan-display {
  min-width: 200px; /* 왼쪽 컴포넌트의 최소 너비 설정 */
}

.map-block {
  flex: 1;
  position: relative;
}

.search-bar-button {
  position: absolute;
  top: 10px;
  right: 10px;
  z-index: 2;
  background-color: rgb(66, 131, 77);
  border-color: rgb(76, 136, 85);
}

.sidebar-content {
  flex: 1; /* Make the sidebar content expand to fill the available space */
  display: flex;
  flex-direction: column;
}

.follower-chart {
  position: absolute;
  z-index: 2;
  top: 105px;
  left: 310px;
  width: 150px;
  height: 150px;
  border-radius: 5%;
  opacity: 0.8;
}
</style>
