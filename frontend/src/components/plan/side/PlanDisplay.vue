<template>
  <div class="plan-display">
    <div class="exp-title">
      <input
        type="text"
        class="form-control"
        id="planname"
        v-model="planname"
        placeholder="경로 이름을 입력하세요"
      />
    </div>
    <div class="exp-desc">
      지도에서 바로 여행지를 추가하세요. 특정 여행지를 삭제하려면 하단에 추가된
      칸을 더블 클릭하세요
    </div>
    <div class="plan-info">
      여행지 개수 : {{attractionList.length}} 최단 경로 : 1
    </div>
    <draggable  class="scroll-container" v-model="attractionList"
     @change="finish()">
      <!-- <plan-item v-for="(plan, index) in attractionList" :key="index" :plan="plan" :index="index"></plan-item> -->
      <div
        v-for="(plan, index) in attractionList"
        :key="index"
        class="plan-item-hover"
        @dblclick="planItmeDbClick(index)"
      >
        <plan-item :plan="plan" :index="index"></plan-item>
      </div>
    </draggable >
    <b-button class="submit-btn" @click="addPlanItemList">등록</b-button>
  </div>
</template>

<script>
import PlanItem from "@/components/plan/side/PlanItem.vue";
import { addPlan } from "@/api/plan";
import draggable from 'vuedraggable'

export default {
  name: "PlanDisplay",
  components: {
    PlanItem,
    draggable
  },
  props: {
    planItemList: [],
  },
  data() {
    return {
      planname: "",
      attractionList: [],
    };
  },
  methods: {
    addPlanItemList() {
      let attractionsIdList = [];
      this.attractionList.forEach((element) => {
        attractionsIdList.push(element.contentId);
      });

      const params = {
        title: this.planname,
        attractions: attractionsIdList,
      };
      console.log(params);
      addPlan(
        params,
        ({ data }) => {
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    planItmeDbClick(index){
      console.log("delete-click");
      this.$emit("delete-click", index);
    },
    finish () {
         console.log('finished')
        this.$emit("dragged", this.attractionList);
      }
  },
  watch: {
    planItemList(newValue, oldValue) {
      console.log(newValue, oldValue);
      this.attractionList = newValue;
    },
  },
};
</script>

<style scoped>
.plan-display {
  width: 300px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.exp-title {
  width: 80%;
  text-align: left;
  padding-top: 20px;
  font-size: 20px;
  padding-bottom: 8px;
  font-weight: bold;
}

.exp-desc {
  width: 80%;
  text-align: left;
  font-size: 14px;
  padding-bottom: 16px;
}

.plan-info {
  width: 80%;
  text-align: left;
  font-size: 14px;
  padding-bottom: 8px;
  color: darkgreen;
  font-weight: 600;
}
.plan-items {
  height: 80px;
}

.scroll-container {
  width: 90%;
  max-height: 600px;
  overflow-y: auto;
}

.submit-btn {
  margin-right: 30px;
  margin-left: auto;
}
</style>
