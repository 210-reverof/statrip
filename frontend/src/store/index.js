import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate";

import userStore from "@/store/modules/userStore";
import attractionStore from "@/store/modules/attractionStore";
import routerStore from "@/store/modules/routerStore";

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    userStore,
    attractionStore,
    routerStore
  },

  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ]
})
