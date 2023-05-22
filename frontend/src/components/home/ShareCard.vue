<template>
  <div class="share-card">
    <div class="share-tag">
      <user-tag class="share-user-tag"></user-tag>
      <like-tag class="share-like-tag" :is-liked="true" :number="detail.hit"></like-tag>
    </div>
    <div class="col-style">
      <img :src="detail.thumbnail" alt="detail.img" class="img-style" /><br />
      <b-row>
        <b-col cols="8">
          {{ detail.title }}
        </b-col>
        <b-col cols="4">
          {{ detail.createdAd }}
        </b-col>
      </b-row>
    </div>
  </div>
</template>

<script>
import UserTag from "@/components/common/UserTag.vue";
import LikeTag from "@/components/common/LikeTag.vue";

export default {
  name: "ShareCard",
  components: {
    LikeTag,
    UserTag,
  },
  props: {
    detail: {
    },
  },
  methods: {
    hoverEffect() {
      this.$refs.card.style.opacity = 0.5;
    },
  },
};
</script>

<style scoped>
.share-card:hover {
  opacity: 0.8;
}

.share-tag{
  position: relative;
}
.share-user-tag {
  position: absolute;
  margin-left: 40px;
  margin-top: 10px;
}
.share-like-tag {
  position: absolute;
  margin-left: 90%;
  margin-top: 25px;
}

.col-style {
  margin: 0;
  padding-top: 50px;
  padding-bottom: 5%;
  border-radius: 1%;
  border-width: 1px;
  border-color: #b0b0b0;
  border-style: solid;
  box-shadow: 1px 1px 10px #b0b0b0;
}
.img-style {
  text-align: center;
  margin-top: 10px;
  margin-bottom: 10px;
  width: 90%;
  height: auto;
  border: 1;
}
</style>