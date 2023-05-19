<template>
  <div
    class="like-icon-tag"
    onclick="event.cancelBubble = true;"
    @click="clickHeart()"
  >
    <b-row class="justify-content-center">
      <div class="heart-icon" :class="{ filled: isLiked }"></div>
      <p class="like-num">{{ number }}</p>
    </b-row>
  </div>
</template>

<script>
export default {
  name: "LikeTag",
  props: {
    // isLiked: {
    //   type: Boolean,
    //   required: true,
    // },
    // number: {
    //   default: 0,
    // },
  },
  data(){
    return{
      isLiked:"",
      number:0
    }
  },
  methods: {
    clickHeart() {
      if(this.isLiked == true){
        this.isLiked = false;
        this.number--;
      }
      else{
        this.isLiked = true;
        this.number++;
      }
    },
  },
  // created:{
  //   isLiked 불러오기
  //   number 불러오기
  // }
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
