<template>
  <b-container class="mt-3" >
    <div>
      <b-row>
      <b-col>
        <h2>Share</h2>
        <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
        <hr>
      </b-col>
    </b-row>
      <b-row>
        <b-col cols="6" v-for="(article, index) in articles" :key="index">
          <div class="col-style">
            <user-tag class="user-tag"></user-tag>
            <img class="img-style"  :src=article.img alt=article.imgss><br>
            {{article.likes}}
          </div>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import UserTag from '@/components/common/UserTag.vue';
export default {
  name: "ShareList",
  components: {
        UserTag
  },
  data: function () {
    return {
      articles: [
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
          {id:1, writer:'Jessica_jj', img:"http://placehold.it/200x300?text=No-image", likes:"12"},
      ]
    }
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.row-style{
  justify-content:center;
}

.col-style {
  margin: 1%;
  margin-bottom: 20%;
  padding-top: 5%;
  padding-bottom: 5%;
  border-radius: 1%;
	border-width: 1px;
	border-color: #DDF9FF;
  border-style: solid;
  box-shadow: 1px 1px 10px #b0b0b0;
  background-color: #DDF9FF;
}
.img-style {
  text-align: center;
  margin-top:10px;
  margin-bottom:10px;
  width: 90%;
  height: auto;
  border-radius: 3%;
  border: 1;
}

</style>
