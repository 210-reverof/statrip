<template>
  <b-container class="mt-3" >
    <div>
      <b-row>
        <b-col cols="3" v-for="(article, index) in articles" :key="index">
          <div class="col-style">
            {{article.writer}}
            <img :src=article.img alt=article.imgss><br>
            {{article.likes}}
          </div>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
export default {
  name: "HotspotList",
  components: {},
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
  padding-top: 10%;
  padding-bottom: 10%;
  border-radius: 1%;
	border-width: 1px;
	border-color: #DDF9FF;
  border-style: solid;
  box-shadow: 1px 1px 10px #b0b0b0;
  background-color: #DDF9FF;
}
.img-style {
  text-align: center;
  margin-top:20px;
  margin-bottom:20px;
  border-radius: 3%;
  border: 1;
}

</style>
