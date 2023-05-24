const routerStore = {
    namespaced: true,
    state: {
      isOnBoard: true
    },
    getters: {
      isOnBoard: state => state.isOnBoard
    },
    mutations: {
      setIsOnBoard: (state, isOnBoard) => {
        state.isOnBoard = isOnBoard;
      }
    },
    actions: {
      setOnBoard({ commit }, isOnBoard) {
        commit('setIsOnBoard', isOnBoard);
      }
    }
  };
  
  export default routerStore;
  