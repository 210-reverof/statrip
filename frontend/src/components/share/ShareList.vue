<template>
  <div class="share-list">
    <div class="contents-block">
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
          @click="moveDetail(item.id)"
        >
        <!-- sharelist에 띄울 card의 모양에 들어가는 데이터의 리스트를 받아 출력 -->
          <share-card class="card-size" :detail="item"></share-card>
        </b-col>
      </b-row>
    </div>

    <b-button class="btn-pos" squared variant="outline-info">글쓰기</b-button>

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
export default {
  name: "ShareList",
  components: {
    ShareCard,
  },
  data: function () {
    return {
      usernickn:"",
      perPage: 6,
      currentPage: 1,
      items: [
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 2,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 3,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 4,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 5,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 6,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 7,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 8,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 9,
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
      ],
    };
  },
  created() {},
  computed: {
    lists() {
      const items = this.items;
      // Return just page of items needed
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
    moveDetail(id) {
      console.log(id);
      this.$router.push({ name: "shareDetail", params: { id: id } });
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

.card-size{
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
