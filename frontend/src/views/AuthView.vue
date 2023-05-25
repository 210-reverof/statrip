<template>
  <div class="auth-view">
    <router-view></router-view>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const routerStore = "routerStore";

export default {
  name: "AuthView",
  computed: {
    ...mapState(routerStore, ["isOnBoard"]),
  },
  methods: {
    ...mapActions(routerStore, ["setOnBoard"]),
  },
  created() {
    this.setOnBoard(false);
  }
};
</script>
