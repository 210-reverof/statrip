<template>
  <div class="share-list">
    <div class="contents-block">
      <br />
      <h2>Share</h2>
      <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>

      <b-row
        id="my-row"
        :items="items"
        :per-page="perPage"
        :current-page="currentPage"
      >
        <!-- 카드 하나씩을 출력하며 각 카드에 클릭 이벤트를 달아줌.
       id값만 넘어가기 때문에 moveDetail로 넘어간 shareDetail에서는 별도의 get을 통해 게시글에 들어갈 plan을 받아줘야 함 -->
        <b-col
          class="col-margin"
          cols="6"
          v-for="item in lists"
          :key="item.name"
          @click="moveDetail(item.articleNo)"
        >
          <!-- sharelist에 띄울 card의 모양에 들어가는 데이터의 리스트를 받아 출력 -->
          <share-card class="card-size" :detail="item"></share-card>
        </b-col>
      </b-row>
    </div>

    <b-button class="btn-pos" squared variant="outline-info" @click="moveMyPlanList()"
      >글쓰기</b-button
    >

    <b-pagination
      class="center"
      v-model="currentPage"
      :total-rows="totalRows"
      :per-page="perPage"
      aria-controls="my-row"
    ></b-pagination>
  </div>
</template>

<script>
import ShareCard from "@/components/home/ShareCard.vue";
import { getList } from "@/api/share";
import { getPlanMyList } from "@/api/plan";
export default {
  name: "ShareList",
  components: {
    ShareCard,
  },
  data: function () {
    return {
      usernickn: "",
      perPage: 6,
      currentPage: 1,
      items: [],
      planitems: [],
    };
  },
  created() {
    getList(
      ({ data }) => (this.items = data),
      (error) => console.log(error)
    );
  },
  computed: {
    lists() {
      const items = this.items;
      return items.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    totalRows() {
      return this.items.length;
    },
  },
  methods: {
    moveDetail(articleNo) {
      this.$router.push({ path: `/share/detail/${articleNo}` });
    },
    moveMyPlanList() {
      getPlanMyList(
        ({ data }) => {
          data.forEach(element => {
            this.planitems.push(element)
          })
        },
        (error) => console.log(error)
      );
      console.log(this.planitems)
      this.$router.push({ name: 'myPlanList', params: { items: this.planitems } })
    },
  },
};
</script>

<style scoped>
.share-list {
  justify-content: center;
}

.contents-block {
  max-width: 1500px;
  justify-content: center;
  margin: 0 auto;
}

.center {
  justify-content: center;
}

.card-size {
  width: 85%;
  margin: 60px auto;
}

.btn-pos {
  margin-left: 80%;
  margin-right: 2%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
