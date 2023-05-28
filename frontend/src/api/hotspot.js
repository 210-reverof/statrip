import { apiInstance } from "./index.js";

const api = apiInstance();

async function addHotspotArticle(formdata, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    api.defaults.headers["Content-Type"] = "multipart/form-data";
    await api.post('/hotspot', formdata).then(success).catch(fail);
}

async function getHotspotList(success, fail) {
    console.log("getHotspotList")
    await api.get('/hotspot').then(success).catch(fail);
}

async function getHotspotArticle(articleNo, success, fail) {
    await api.get('/hotspot/' + articleNo).then(success).catch(fail);
}

async function deleteHotspotArticle(articleNo, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.delete('/hotspot/' + articleNo).then(success).catch(fail);
}

export { addHotspotArticle, getHotspotList, getHotspotArticle, deleteHotspotArticle };
