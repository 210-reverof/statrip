import { apiInstance } from "./index.js";

const api = apiInstance();

async function getPlanAllList(success, fail) {
    await api.get(`/plan/list/all`).then(success).catch(fail);
}

async function getPlanMyList(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/plan/list/my`).then(success).catch(fail);
}

async function getPlanUserList(userId, success, fail) {
    await api.get(`/plan/list/user/` + userId).then(success).catch(fail);
}

async function getPlanFollowList(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/plan/list/follow`).then(success).catch(fail);
}

async function getPlan(planId, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/plan/` + planId).then(success).catch(fail);
}

async function getSelectedPlan(params, success, fail) {
    console.log("api getSelectedPlan")
    console.log(params)
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/plan/overlay?`+params.toString()).then(success).catch(fail);
}

async function addPlan(plan, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.post(`/plan`, JSON.stringify(plan)).then(success).catch(fail);
}

export { getPlan, addPlan, getPlanAllList, getPlanMyList, getPlanFollowList, getPlanUserList, getSelectedPlan}
