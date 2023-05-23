import { apiInstance } from "./index.js";

const api = apiInstance();

async function addComment(comment, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.post('/comment', JSON.stringify(comment)).then(success).catch(fail);
}

async function getComments(shareId, success, fail) {
    await api.get('/comment/' + shareId).then(success).catch(fail);
}

async function deleteComment(commentId, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.delete('/comment/' + commentId).then(success).catch(fail);
}


export { addComment, getComments, deleteComment };
