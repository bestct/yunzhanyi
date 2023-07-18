/**
 * 判断是否是手机号
 * @param tel
 * @returns {boolean}
 */
export function isPhoneNumber(tel) {
    const reg = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    return reg.test(tel);
}

/**
 * 判断是否是邮箱
 * @param email
 * @returns {boolean}
 */
export function isEmail(email) {
    const reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    return reg.test(email);
}

export function getToken() {
    return getCookies('token')
}    //获取cookie方法，封装一个方法getCookies(),传入一个属性参数，可以获取对应的属性值
export function clearToken(){
    document.cookie = 'token' + '=0;path=/;expires=' + new Date(0).toUTCString();
}
function getCookies(name) {
    const str = document.cookie;    //获取所有的cookie，得到的是一个字符串
    const arr = str.split("; "); //注意：分号后面有一个空格
    for (let i = 0; i < arr.length; i++) {
        var arr2 = arr[i].split("=")
        if (arr2[0] === name) {
            return arr2[1]
        }
    }
}
export function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}
export function toLogin() {
    window.location.href = "/login" + "?redirect=" + location.pathname + location.search
}
export function createToast(text,type) {
    var typeStyle={
        "info":"linear-gradient(to right, #2c3e50, #bdc3c7)",
        "success":"linear-gradient(to right, #56ab2f, #a8e063)",
        "warning":"linear-gradient(to right, #f2994a, #f2c94c)",
        "error":"linear-gradient(to right, #ed213a, #93291e)"
    }
    Toastify({
        text: text,
        duration: 2000,
        newWindow: true,
        close: false,
        gravity: "top", // `top` or `bottom`
        position: "center", // `left`, `center` or `right`
        stopOnFocus: true, // Prevents dismissing of toast on hover
        style: {
            background: typeStyle[type],
        },
    }).showToast();
}
