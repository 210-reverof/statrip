<template>
  <div
    class="like-icon-tag"
    onclick="event.cancelBubble = true;"
  >
    <b-row class="justify-content-center">
      <div class="heart-icon" :class="{ filled: isLiked }"></div>
      <p class="like-num">{{ likeCnt }}</p>
    </b-row>
  </div>
</template>

<script>
export default {
  name: "LikeTag",
  props: {
    isLiked: {
      type: Boolean,
      required: true,
    },
    likeCnt: {
      default: 0,
    },
  },
  created() {
    console.log(this.isLiked+ "=================");
  },
  methods: {
  },
};
</script>

<style scoped>
.like-icon-tag{
  width: fit-content;
}

.like-num{
  margin: auto 5px ;
}

.heart-icon {
  width: 20px;
  height: 20px;
  background-image: url("@/assets/common/heart-empty.png");
  background-repeat: no-repeat;
  background-size: cover;
}

.filled {
  background-image: url("@/assets/common/heart-fill.png");
}
</style>
