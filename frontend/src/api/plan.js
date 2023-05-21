import { apiInstance } from "./index.js";

const api = apiInstance();

async function getPlanList(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/plan`).then(success).catch(fail);
}

async function getPlan(planId, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/plan/` + planId).then(success).catch(fail);
}

async function addPlan(plan, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.post(`/plan`, JSON.stringify(plan)).then(success).catch(fail);
}

export { getPlanList, getPlan, addPlan }