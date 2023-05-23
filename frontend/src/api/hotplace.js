import { apiInstance } from "./index.js";

const api = apiInstance();

async function addHotspotArticle(hotspotArticle, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.post('/hotspot', JSON.stringify(hotspotArticle)).then(success).catch(fail);
}

async function getHotspotList(success, fail) {
    await api.get('/hotspot').then(success).catch(fail);
}

async function getHotspotArticle(articleNo, success, fail) {
    await api.get('/hotspot/' + articleNo).then(success).catch(fail);
}

async function deleteHotspotArticle(articleNo, success, fail) {
    await api.delete('/hotspot/' + articleNo).then(success).catch(fail);
}

export { addHotspotArticle, getHotspotList, getHotspotArticle, deleteHotspotArticle };
