<template>
  <div class="like-tag">
    <b-row class="justify-content-center">
        <div class="heart-icon" :class="{ 'filled': isLiked }"></div>
        <p>{{ number }}</p>
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
    number: {
      default: 0,
    },
  },
};
</script>

<style>

.heart-icon {
  width: 20px;
  height: 20px;
  background-image: url('@/assets/common/heart-empty.png');
  background-repeat: no-repeat;
  background-size: cover;
}

.filled {
  background-image: url('@/assets/common/heart-fill.png');
}
</style>
