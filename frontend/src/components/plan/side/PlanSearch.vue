<template>
  <div class="plan-search">
    <b-sidebar
      id="sidebar-right"
      bg-variant="dark"
      text-variant="light"
      right
      shadow
      v-model="sidebarVisible"
    >
      <div class="sidebar-content">
        <div class="exp-title">여행지 검색</div>
        <div class="exp-desc">
            지역별, 유형별로 여행지를 검색하세요
        </div>
        <div class="plan-info">시도</div>
        <b-form-select
          v-model="sidoCode"
          :options="sidos"
          @change="gugunList"
          class="search-sel"
        ></b-form-select>
        <div class="plan-info">구군</div>
        <b-form-select
          v-model="gugunCode"
          :options="guguns"
          @change="searchAttraction"
          class="search-sel"
        ></b-form-select>
        <div class="plan-info">유형</div>
        <b-form-select
          v-model="selectedType"
          :options="types"
          class="search-sel"
        ></b-form-select>
      </div>
      <b-button @click="searchBtn" class="search-bar-button">검색</b-button>
    </b-sidebar>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
const attractionStore = "attractionStore";
export default {
  name: "PlanSearch",
  data() {
    return {
      sidebarVisible: false,
      // selectedSido: 0,
      // selectedGugun: 0,
      sidoCode: null,
      gugunCode: null,
      selectedType: 0,
      types: [
        { value: 0, text: "레포츠" },
        { value: 1, text: "식당" },
      ],
    };
  },
  computed:{
    ...mapState(attractionStore, ["sidos", "guguns", "attractions"]),
  },
  created(){
    this.CLEAR_SIDO_LIST();
    this.CLEAR_ATTRACTION_LIST();
    this.getSido();
    console.log("crestdsfag")
  },
  methods: {
    searchBtn() {
      console.log("here");
      this.$emit("search-click", 127.5, 36.2);
      this.sidebarVisible = false;
    },
    
    ...mapActions(attractionStore, ["getSido", "getGugun", "getAttractionList"]),
    ...mapMutations(attractionStore, ["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_ATTRACTION_LIST"]),
    // sidoList() {
    //   this.getSido();
    // },
    gugunList() {
      console.log("gugunList : "+this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    searchAttraction() {
      if (this.gugunCode) this.getAttractionList(this.gugunCode);
    },
  },
};
</script>
<style scoped>
.search-sel {
  width: 80%;
  margin-bottom: 20px;
}

.exp-title {
  width: 80%;
  text-align: left;
  padding-top: 20px;
  font-size: 20px;
  padding-bottom: 8px;
  margin-left: 35px;
  font-weight: bold;
}

.exp-desc {
  width: 80%;
  text-align: left;
  margin-left: 35px;
  font-size: 14px;
  padding-bottom: 16px;
}

.plan-info {
  margin-left: 35px;
  width: 80%;
  text-align: left;
  font-size: 14px;
  padding-bottom: 8px;
  color: rgb(160, 190, 160);
  font-weight: 600;
}

.search-bar-button {
    margin-top: 60px
}
</style>
