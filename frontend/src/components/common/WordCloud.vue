<template>
  <div>
      <wordcloud
      :data="defaultWords"
      nameKey="name"
      valueKey="value"
      :color="myColors"
      :showTooltip="true"
      :wordClick="wordClickHandler">
      </wordcloud>
  </div>
</template>

<script>
import wordcloud from 'vue-wordcloud'

export default {
  name: 'WordCloud',
  components: {
    wordcloud
  },
  methods: {
    wordClickHandler(name, value, vm) {
      console.log('wordClickHandler', name, value, vm);
    }
  },
  data() {
    return {
      myColors: ['#1f77b4', '#629fc9', '#94bedb', '#c9e0ef'],
      defaultWords: [{
          "name": "SightSeeing",
          "value": 26
        },
        {
          "name": "Cultural",
          "value": 19
        },
        {
          "name": "Festival",
          "value": 18
        },
        {
          "name": "TravelRoute",
          "value": 16
        },
        {
          "name": "Leports",
          "value": 15
        },
        {
          "name": "Sleeping",
          "value": 9
        },
        {
          "name": "Shopping",
          "value": 9
        },
        {
          "name": "Restaurant",
          "value": 9
        },
      ]
    }
  }
}
</script>