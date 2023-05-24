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
        Toastify({
            text: response.data.msg,
            duration: 2000,
            newWindow: true,
            close: false,
            gravity: "top", // `top` or `bottom`
            position: "center", // `left`, `center` or `right`
            stopOnFocus: true, // Prevents dismissing of toast on hover
            style: {
                //成功 linear-gradient(to right, #56ab2f, #a8e063)
                //警告 linear-gradient(to right, #f2994a, #f2c94c)
                //错误 linear-gradient(to right, #ed213a, #93291e)
                //提示 linear-gradient(to right, #2c3e50, #bdc3c7)
                background: "linear-gradient(to right, #ed213a, #93291e)",
            },
        }).showToast();
        return Promise.reject(error);
    }
    return response.data;
}, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
});
export default instance
