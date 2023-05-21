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

        <div class="scroll-container">
          <div v-for="(plan, index) in attractionList" :key="index" class="plan-item-hover" @dblclick="planItmeDbClick(index, plan)">
            <plan-item :plan="plan" :index="index" ></plan-item>
          </div>
        </div>
      
    </b-sidebar>
  </div>
</template>

<script>
import PlanItem from "@/components/plan/side/PlanItem.vue";
import { mapState, mapActions, mapMutations } from "vuex";
const attractionStore = "attractionStore";

export default {
  name: "PlanSearch",
  components: {
    PlanItem
  },
  data() {
    return {
      sidebarVisible: false,
      selected: false,
      // selectedSido: 0,
      // selectedGugun: 0,
      sidoCode: null,
      gugunCode: null,
      selectedType: 0,
      types: [
        { value: 12, text: "관광지" },
        { value: 14, text: "문화시설" },
        { value: 15, text: "축제공연행사" },
        { value: 25, text: "여행코스" },
        { value: 28, text: "레포츠" },
        { value: 32, text: "숙박" },
        { value: 38, text: "쇼핑" },
        { value: 39, text: "음식점" },
      ],
      attractionList:[]
    };
  },
  computed:{
    ...mapState(attractionStore, ["sidos", "guguns", "attractions"]),
    
  },
  created(){
    this.CLEAR_SIDO_LIST();
    this.CLEAR_ATTRACTION_LIST();
    this.getSido();
  },
  methods: {
    searchBtn() {
      console.log("searchBtn");
      this.CLEAR_ATTRACTION_LIST();
      if(this.attractions) this.selectedCount = true;
      else this.selectedCount = false;
      if (this.gugunCode & this.selectedType!=0) this.getAttractionList({sidoCode:this.sidoCode, gugunCode:this.gugunCode, types:this.selectedType});
      this.attractionList = this.attractions;
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
    

    planItmeDbClick(index, plan){
      console.log(index+" , "+plan);
      this.$emit("search-click", index, plan);
    }
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
.plan-item-hover:hover{
  opacity: 50%;
}

.search-bar-button {
    margin: 20px
}

.scroll-container {
  width: 90%;
  margin: 0 auto;
  max-height: 400px;
  overflow-y: auto;
}

</style>
