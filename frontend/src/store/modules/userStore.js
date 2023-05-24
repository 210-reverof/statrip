import jwtDecode from "jwt-decode";
import { login, info, logout } from "@/api/user";

const userStore = {
  namespaced: true,

  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
    isValidToken: false,
  },

  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
    checkToken: function (state) {
      return state.isValidToken;
    },
  },

  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_IS_VALID_TOKEN: (state, isValidToken) => {
      state.isValidToken = isValidToken;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
  },

  actions: {
    async userConfirm({ commit }, user) {
      await login(
        user,
        ({ data }) => {
            let accessToken = data["accessToken"];
            let refreshToken = data["refreshToken"];
           
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            commit("SET_IS_VALID_TOKEN", true);
            sessionStorage.setItem("access-token", accessToken);
            sessionStorage.setItem("refresh-token", refreshToken);
        },
        (error) => {
          alert("잘못된 로그인 정보입니다.");
          console.log(sessionStorage.getItem("access-token"));
          console.log(error);
        }
      );
    },

    async getUserInfo({ commit }, token) {
      let decodeToken = jwtDecode(token);
      console.log(decodeToken.userid);

      await info(
        ({ data }) => {
          commit("SET_USER_INFO", data);
        },
        async (error) => {
          console.log("getUserInfo() error code [토큰 만료되어 사용 불가능.] ::: ", error.response.status);
          commit("SET_IS_VALID_TOKEN", false);
         // await dispatch("tokenRegeneration");
        }
      );
    },
    
    async userLogout({ commit }, userid) {
      await logout(
        userid,
        () => {
            commit("SET_IS_LOGIN", false);
            commit("SET_USER_INFO", null);
            commit("SET_IS_VALID_TOKEN", false);
            sessionStorage.setItem("access-token", null);
            sessionStorage.setItem("refresh-token", null);
            window.location.reload();
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default userStore;