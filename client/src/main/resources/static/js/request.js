import {getToken} from "./base.js";
const instance = axios.create({
    baseURL: '/api',
    timeout: 1000,
});
// 在实例已创建后修改默认值
instance.defaults.headers.common["Authorization"] = getToken();
// 添加响应拦截器
instance.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    if (response.data.code===500){
        Qmsg.error(response.data.msg)
        return Promise.reject(error);
    }
    return response.data;
}, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
});
export default instance
