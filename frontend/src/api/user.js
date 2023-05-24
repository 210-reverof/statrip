import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function info(success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info`).then(success).catch(fail);
}

// async function tokenRegeneration(user, success, fail) {
//   api.defaults.headers["refresh-token"] = sessionStorage.getItem("refresh-token"); //axios header에 refresh-token 셋팅
//   await api.post(`/user/refresh`, user).then(success).catch(fail);
// }

async function logout(userId, success, fail) {
  await api.get(`/user/logout/${userId}`).then(success).catch(fail);
}

async function followUserCnt(userId, success, fail) {
  await api.get(`/user/follow-user-cnt/` + userId).then(success).catch(fail);
}

async function followCnt(success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/follow-cnt`).then(success).catch(fail);
}

async function isPossible(userId, success, fail) {
  await api.get(`/user/possible/` + userId).then(success).catch(fail);
}

async function join(join, success, fail) {
  await api.post(`/user/join`, JSON.stringify(join)).then(success).catch(fail);
}

async function getMyRecommend(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/stat/recommend`).then(success).catch(fail);
}

async function getRecommend(success, fail) {
  await api.get(`/stat/recommend`).then(success).catch(fail);
}

async function getFollowing(userId, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/following/` + userId).then(success).catch(fail);
}

async function getFollower(userId, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/follower/` + userId).then(success).catch(fail);
}


export { login, info, logout, followUserCnt, followCnt, isPossible, join, getMyRecommend, getRecommend, getFollowing, getFollower };
