import axios from "axios";
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
axios.defaults.baseURL="/api"
const service = axios.create({
    // 超时
    timeout: 10000
})
export default service
