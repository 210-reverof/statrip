import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function info(success, fail) {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json;charset=utf-8");
  myHeaders.append("auth-token", "tttttttttt");

  console.log("pllllllllllllz");

  var requestOptions = {
    method: 'GET',
    headers: myHeaders,
  };

  fetch("http://localhost:80/statrip/user/info", requestOptions)
    .then(success)
    .catch(fail);
  // const config = {
  //   headers: {
  //     "auth-token": sessionStorage.getItem("access-token"),
  //     "Content-Type": "application/json;charset=utf-8",
  //   },
  // };
  //   await api.get(`/user/info`, config).then(success).catch(fail);
}

export { login, info };