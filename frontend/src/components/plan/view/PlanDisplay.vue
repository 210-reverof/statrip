<template>
  <div class="plan-display">
    <button class="share-button" @click="sharePlan">공유</button>

    <div class="title-form">
      <div class="exp-title">{{ plan.title }}</div>
      <div v-if="userInfo.userId == plan.userId">
        <b-button
          class="delete-button"
          @click="deletePlan()"
          variant="danger"
          size="sm"
        >
          삭제
        </b-button>
      </div>
    </div>
    <div class="exp-desc">{{ plan.createdAt }}, {{ plan.userId }}</div>
    <div class="plan-info">
      여행지 개수 : {{ plan.attractions.length }} 이동거리 : {{ curLength }}
    </div>
    <div class="scroll-container">
      <plan-item
        v-for="(attraction, index) in plan.attractions"
        :key="index"
        :plan="attraction"
      ></plan-item>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import PlanItem from "@/components/plan/side/PlanItem.vue";
import { deletePlan } from "@/api/plan";
const userStore = "userStore";

export default {
  name: "PlanDisplay",
  props: {
    curLength: {},
    plan: {
      type: Object,
      required: true,
    },
  },
  components: {
    PlanItem,
  },
  computed: {
    ...mapState(userStore, ["userInfo"]),
  },
  methods: {
    sharePlan() {
      this.$router.push({ name: "shareWrite", params: { plan: this.plan } });
    },
    deletePlan() {
      deletePlan(
        this.plan.planId,
        this.handleDeleteSuccess,
        this.handleDeleteError
      );
      this.$router.push({ name: "planList" });
    },
    handleDeleteSuccess() {
      window.location.reload();
    },
    handleDeleteError(error) {
      console.log(error);
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

.share-button {
  width: 80%;
  text-align: center;
  margin-top: 20px;
  font-size: 20px;
  padding: 8px;
  font-weight: bold;
  color: rgb(240, 255, 248);
  background-color: rgb(84, 198, 166);
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.share-button:hover {
  background-color: skyblue;
}
.delete-button {
  float: right;
  width: 25%;
  margin-top: 10px;
}

.delete-button:hover {
  background-color: rgb(212, 80, 18);
}

.exp-title {
  width: 75%;
  text-align: left;
  padding-top: 20px;
  font-size: 20px;
  padding-bottom: 8px;
  font-weight: bold;

  float: left;
}

.title-form {
  width: 80%;
  height: 60px;
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
  max-height: 650px;
  overflow-y: auto;
}
</style>
