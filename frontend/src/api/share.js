import { apiInstance } from "./index.js";

const api = apiInstance();

async function addShareArticle(shareArticle, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.post('/share', JSON.stringify(shareArticle)).then(success).catch(fail);
}

export { addShareArticle };