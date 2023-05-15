<template>
  <b-container class="mt-3">
    <div>
      <b-row>
        <b-col class="" v-for="(club, index) in clubs" :key="index">
          <div>
            제목
            <img src="http://placehold.it/130?text=No-image" class="col-img">
            좋아요
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
      clubs: [
          {id:1, description:'chelsea', price:1000, country:'england'},
          {id:2, description:'liverpool', price:900, country:'england'},
          {id:3, description:'mu', price:800, country:'england'},
          {id:4, description:'cit', price:700, country:'england'},
          {id:5, description:'arsenal', price:600, country:'england'},
          {id:6, description:'tottenham', price:500, country:'england'},
          {id:7, description:'juventus', price:400, country:'italy'},
          {id:8, description:'madrid', price:300, country:'spain'},
          {id:9, description:'barcelona', price:200, country:'spain'},
          {id:10, description:'psg', price:100, country:'france'}
      ]
    }
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.col-style {
  margin-top: 0;
  border-radius: 10px;
  color: white;
  border: 1;
  background-color: #323F30;
  font-family: 'Hahmlet', sans-serif;
}
.col-img {
  margin: auto;
  padding: auto;
  border-radius: 2px;
  border: 1;
}

</style>
