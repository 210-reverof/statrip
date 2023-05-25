<template>
  <div>
      <wordcloud
      :data="defaultWords"
      nameKey="name"
      valueKey="value"
      :color="myColors"
      :showTooltip="true"
      :wordClick="wordClickHandler"
      class="wordcloud">
      </wordcloud>
  </div>
</template>

<script>
import wordcloud from 'vue-wordcloud'
import { getStatCloud } from "@/api/stat";

export default {
  name: 'WordCloud',
  components: {
    wordcloud
  },
  methods: {
    wordClickHandler(name, value, vm) {
      console.log('wordClickHandler', name, value, vm);
    },
    async getCloud() {
      getStatCloud(
        ({ data }) => {
          data.forEach(element => {
            this.defaultWords.push(element)
          });
        },
        (error) => console.log(error)
      );
    },
  },
  data() {
    return {
      myColors: ['#1f77b4', '#629fc9', '#94bedb', '#c9e0ef'],
      defaultWords: []
    }
  },
  created() {
    this.getCloud();
  }
}
</script>

<style scoped>
.wordcloud{
  width: 100%;
  height: 100%;
  margin: 0 auto;
}
</style>