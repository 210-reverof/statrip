<template>
  <div>
    
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const routerStore = "routerStore";

export default {
  name: "BlackView",
  computed: {
    ...mapState(routerStore, ["isOnBoard"]),
  },
  methods: {
    ...mapActions(routerStore, ["setOnBoard"]),
  },
  created() {
    this.setOnBoard(true);
  }
};
</script>
