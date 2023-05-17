<template>
  <div>
    <b-row>
      <b-col cols="3">
        <div>
          본문
        </div>
      </b-col>
      <b-col cols="9">
        <share-map></share-map>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import ShareMap from "./ShareMap.vue";
export default {
  name: "ViewPlan",
  components: {
    ShareMap,
  },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>
