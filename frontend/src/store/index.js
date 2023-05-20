import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate";

import userStore from "@/store/modules/userStore";
import attractionStore from "@/store/modules/attractionStore";

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    userStore,
    attractionStore
  },

  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ]
})
