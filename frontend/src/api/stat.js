import { apiInstance } from "./index.js";

const api = apiInstance();

async function getUserStat(userId, success, fail) {
    await api.get('/stat/user/' + userId).then(success).catch(fail);
}

async function getMyStat(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get('/stat/my').then(success).catch(fail);
}

async function getRealStat(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get('/stat/exp').then(success).catch(fail);
}

async function getCount(userId, success, fail) {
    await api.get('/stat/count/' + userId).then(success).catch(fail);
}

async function getMyCount(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get('/stat/mycount').then(success).catch(fail);
}

export { getUserStat, getMyStat, getRealStat, getCount, getMyCount };
