import {getToken,createToast} from "./base.js";
const instance = axios.create({
    baseURL: '/api',
    timeout: 5000,
});
// 在实例已创建后修改默认值
instance.defaults.headers.common["Authorization"] = getToken();
// 添加响应拦截器
instance.interceptors.response.use(function (response) {

    // 对响应数据做点什么
    if (response.data.code===500){
        createToast(response.data.msg,"error")
        return Promise.reject(error);
    }
    return response.data;
}, function (error) {
    // 对响应错误做点什么
    createToast(error,"error")
    return Promise.reject(error);
});
export default instance
