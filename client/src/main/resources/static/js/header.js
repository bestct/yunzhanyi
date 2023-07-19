import instance from "./request.js";
import {createToast,clearToken} from "./base.js";

var logoutModel;

var showLogout=document.getElementById('showLogout')
if (showLogout){
    showLogout.addEventListener('click', ev => {
        showLogoutModel()
    })
    document.getElementById('logout').addEventListener('click',logout)
}
function showLogoutModel() {
    //初始化模态框
    logoutModel = new bootstrap.Modal(document.getElementById('logoutModal'))
    logoutModel.show()
}

function logout() {
    instance({
        url: "/logout",
        method: 'post',
    }).then(function (response) {
        createToast("退出成功","success")
        //清楚token
        clearToken()
        window.location.reload()
        logoutModel.hide()
    });
}

document.getElementById('keyword').addEventListener('keydown', ev => {
    if (ev.key === 'Enter') {
        search()
    }
})
document.getElementById('searchBtn').addEventListener('click', search)

function search() {
    //搜索内容不能为空
    let keyword = document.getElementById('keyword').value.trim()
    if (keyword === '' || keyword === undefined) {
        createToast("搜索内容不能为空",'warning')
    } else {
        let searchType = document.getElementById('searchType').value
        if ('/search' === window.location.pathname) {
            window.location.href = `/search?keyword=${keyword}&searchType=${searchType}&hotWord=true`
        } else {
            window.open(`/search?keyword=${keyword}&searchType=${searchType}&hotWord=true`)
        }

    }
}

const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
