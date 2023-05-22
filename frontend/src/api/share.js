import { apiInstance } from "./index.js";

const api = apiInstance();

async function addShareArticle(shareArticle, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.post('/share', JSON.stringify(shareArticle)).then(success).catch(fail);
}

<<<<<<< HEAD
export { addShareArticle };
=======
async function getList(success, fail) {
    await api.get('/share').then(success).catch(fail);
}

async function getArticle(articleNo, success, fail) {
    await api.get('/share/' + articleNo).then(success).catch(fail);
}

export { addShareArticle, getList, getArticle };
>>>>>>> develop
