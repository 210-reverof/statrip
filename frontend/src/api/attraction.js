import { apiInstance } from "./index.js";

const api = apiInstance();

function sidoList(success, fail) {
  console.log("api - sidolist");
  api.get(`/attraction/sido`).then(success).catch(fail);
}

function gugunList(no, success, fail) {
    console.log("api - gugunList");
  api.get(`/attraction/gugun/${no}`).then(success).catch(fail);
}

function attractionList(params, success, fail) {
    console.log("api - attractionList");
    api.get(`/attraction/list`, { params: params }).then(success).catch(fail);
}




export { sidoList, gugunList, attractionList };