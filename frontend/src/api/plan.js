import { apiInstance } from "./index.js";

const api = apiInstance();

async function getPlanList(success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/plan`).then(success).catch(fail);
}

export { getPlanList }