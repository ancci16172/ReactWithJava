import { Axios, default as axiosDefault } from "axios";


export const axios = axiosDefault.create({
  baseURL: "http://localhost:8080/api",
  headers: {
    "Content-Type": "application/json",
  },
  withCredentials : true
});
