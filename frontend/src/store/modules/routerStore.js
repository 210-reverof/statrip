const routerStore = {
  namespaced: true,
  state: {
    isOnBoard: localStorage.getItem('isOnBoard') === 'true' 
  },
  mutations: {
    SET_IS_ON_BOARD: (state, isOnBoard) => {
      state.isOnBoard = isOnBoard;
      localStorage.setItem('isOnBoard', isOnBoard);
    }
  },
  actions: {
    setOnBoard({ commit }, isOnBoard) {
      if (isOnBoard == false || isOnBoard == 'false' ) commit('SET_IS_ON_BOARD', false);
      else commit('SET_IS_ON_BOARD', true);
    }
  }
};

export default routerStore;