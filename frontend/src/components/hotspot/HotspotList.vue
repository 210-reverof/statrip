<template>
  <b-container class="mt-3">
    <div>
      <b-row>
        <b-col>
          <h2>Hot Spots</h2>
          <h5>나만의 핫스팟을 인증샷과 함께 자랑해주세요</h5>
          <hr />
        </b-col>
      </b-row>
      <b-row
        id="my-table"
        :articles="articles"
        :per-page="perPage"
        :current-page="currentPage"
      >
      
        <b-col cols="3" v-for="article in articles" :key="article.name">
          <div class="col-style">
            <hot-spot-card></hot-spot-card>
          </div>
        </b-col>
      </b-row>
    </div>
    <b-pagination
      class="center"
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="my-table"
    ></b-pagination>
  </b-container>
</template>

<script>
import HotSpotCard from "@/components/home/HotSpotCard.vue";
export default {
  name: "HotspotList",
  components: {
    HotSpotCard
  },
  data: function () {
    return {
      perPage: 8,
      currentPage: 1,
      articles: [
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
        {
          id: 1,
          writer: "Jessica_jj",
          img: "http://placehold.it/200x300?text=No-image",
          likes: "12",
        },
      ],
    };
  },
  created() {},
  computed: {
    rows() {
      return this.articles.length;
    },
  },
  methods: {},
};
</script>

<style scoped>
.center {
  justify-content: center;
}

.col-style {
  margin: 5%;
  padding: 5%;
}
</style>
