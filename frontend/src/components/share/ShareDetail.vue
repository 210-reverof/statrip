<template>
  <div class="contents-block">
    <h2>Share</h2>
    <h5>자신이 자랑하고싶은 여행 경로를 공유해주세요</h5>
    <hr />
    <div class="block-tmp-size">
        <share-block-tmp ></share-block-tmp>
        {{item.id}}<br>
        {{item.writer}}<br>
        <img :src=item.img><br>
        {{item.likes}}<br>
        {{item.content}}<br>
        {{item.regitdate}}<br>
    <b-row>
      <b-col> </b-col>
    </b-row>
    </div>
    <share-map></share-map>
    <b-row>
        <b-col cols="10"></b-col>
        <b-col cols="2">
            <b-button squared variant="outline-info" @click="$router.push({name: 'shareList'})"
            >뒤로가기
            </b-button>
            </b-col>
    </b-row>
  </div>
</template>

<script>

import ShareBlockTmp from '@/components/home/ShareBlockTmp.vue';
import ShareMap from './ShareMap.vue';

export default {
  name: "ShareDetail",
  components: {
    ShareBlockTmp,
    ShareMap
  },
  data: function () {
    return {
      item: {},
    };
  },
  created() {
    this.item = this.$route.params.item;
    // item.id로 경로 불러와서 경로 다 찍어주기
  },
  methods: {},
};
</script>

<style scoped>
.contents-block {
  max-width: 1500px;
  justify-content: center;
  margin: 0 auto;
}

.block-tmp-size{
    widows: 50%;
}
</style>
