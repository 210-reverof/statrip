<template>
  <div class="share-card">
    <div class="share-tag">
      <user-tag :userId="detail.userId" class="share-user-tag"></user-tag>
      <like-tag class="share-like-tag" :is-liked="true" :number="detail.hit"></like-tag>
    </div>
    <div class="col-style">
      <img :src="getValidImageUrl(detail.thumbnail)" alt="detail.img" class="img-style" /><br />
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
    getValidImageUrl(imageUrl) {
      if (!imageUrl || imageUrl.trim() === "") {
        return "https://firebasestorage.googleapis.com/v0/b/pocket-sch.appspot.com/o/noimg-statrip-2.png?alt=media&token=6a8354d8-3533-4eee-9272-7d8a7e87302d"; 
      }
      return imageUrl;
    }
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