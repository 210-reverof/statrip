import { sidoList, gugunList, attractionList } from "@/api/attraction";

const attractionStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    
    attractions: [],
    attraction: null,
  },
  getters: {},
  mutations: {
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_ATTRACTION_LIST(state) {
      state.attractions = [];
      state.attraction = null;
    },
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    SET_ATTRACTION_LIST(state, attractions) {
      attractions.forEach((attraction) => {
        state.attractions.push(attraction);
      });
      console.log(attractions);
    },
    SET_DETAIL_ATTRACTION(state, attraction) {
      state.attraction = attraction;
    },
  },
  actions: {
    getSido: ({ commit }) => {
      sidoList(
        ({ data }) => {
          commit("SET_SIDO_LIST", data);
        },
        (error) => {
          console.log("getsido" + error);
        }
      );
    },
    getGugun: ({ commit }, sidoCode) => {
      // const params = { sido: sidoCode };
      gugunList(
        sidoCode,
        ({ data }) => {
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getAttractionList: ({ commit }, {sidoCode, gugunCode, types}) => {
      const params = {
        sido : sidoCode,
        gugun: gugunCode,
        types: types
      };
      
      attractionList(
        params,
        ({ data }) => {
          commit("SET_ATTRACTION_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    detailAttraction: ({ commit }, attraction) => {
      // 나중에 attraction id를 이용하여 호출
      commit("SET_DETAIL_ATTRACTION", attraction);
    },
  },
};

export default attractionStore;
