import { Axios } from "axios";


export const axios = new Axios({
    baseURL: "http://localhost:8080/api",headers : {
        "Content-Type": "application/json"
    }})
