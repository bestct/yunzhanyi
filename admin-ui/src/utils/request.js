import axios from "axios";
import {ElMessage, ElNotification} from "element-plus";
import errorCode from "./errorCode";

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
const service = axios.create({
    // 超时
    baseURL: "/api",
    timeout: 10000
})
service.interceptors.response.use(res => {
        // 未设置状态码则默认成功状态
        const code = res.data.code || 200;
        // 获取错误信息
        const msg = errorCode[code] || res.data.msg || errorCode['default']
        if (code === 401) {
            ElMessage({message: msg, type: 'error'})

        } else if (code === 500) {
            ElMessage({message: msg, type: 'error'})
            return Promise.reject(new Error(msg))
        } else if (code === 403) {
            ElMessage({message: msg, type: 'warning'})
            return Promise.reject(new Error(msg))
        } else if (code !== 200) {
            ElNotification.error({title: msg})
            return Promise.reject('error')
        } else {
            return Promise.resolve(res.data)
        }
    }, error => {
        console.log('err' + error)
        let {message} = error;
        if (message === "Network Error") {
            message = "后端接口连接异常";
        } else if (message.includes("timeout")) {
            message = "系统接口请求超时";
        } else if (message.includes("Request failed with status code")) {
            message = "系统接口" + message.substr(message.length - 3) + "异常";
        }
        ElMessage({message: message, type: 'error', duration: 5 * 1000})
        return Promise.reject(error)
    }
)
export default service
