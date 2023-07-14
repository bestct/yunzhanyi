import {createApp} from './vue.esm-browser.prod.js'
import instance from "./request.js";
import {createToast, isEmail, isPhoneNumber, getQueryString} from './base.js'

createApp({
    created() {
        document.getElementById("app").hidden = false;
    },
    data() {
        return {
            phone: "",
            registerPassword: "",
            rePassword: "",
            account: "",
            loginPassword: ""
        }
    },
    methods: {
        login() {
            if (this.account === '') {
                createToast("账号不能为空", "warning")
                return;
            }
            if (!isPhoneNumber(this.account) && !isEmail(this.account)) {
                createToast("账号格式错误", "warning")
                return;
            }
            if (this.loginPassword === '') {
                createToast("请输入密码", "warning")
            } else if (this.loginPassword.length < 8) {
                createToast("密码长度不能小于8", "warning")
            } else {

                let loginBtn = document.getElementById('loginBtn');
                let loginLoading = document.getElementById('loginLoading');
                loginLoading.hidden = false
                loginBtn.disabled = true
                instance({
                        method: 'post',
                        url: '/login',
                        params: {
                            account: this.account,
                            password: this.loginPassword
                        }
                    }
                ).then(function (response) {
                    createToast("登录成功", 'success')
                    loginBtn.disabled = false
                    loginLoading.hidden = true
                    document.cookie = "token=" + response.data.access_token + ";path=/;expires=" + response.data.expires_in + ";"
                    //重定向
                    var url = getQueryString("redirect")
                    if (!url) {
                        url = '/'
                    }
                    location.href = url
                })
            }
        },
        registerAccount() {
            if (this.phone === '') {
                createToast('手机号不能为空',"warning")
                return;
            }
            if (!isPhoneNumber(this.phone)) {
                createToast('手机号格式错误！',"warning")
                return;
            }
            if (this.registerPassword === '') {
                createToast("请输入密码！","warning")
            } else if (this.registerPassword.length < 8) {
                createToast("密码长度不能小于8！","warning")
            } else if (this.rePassword !== this.registerPassword) {
                createToast("两次密码不一致","warning")
            } else {
                instance({
                        method: 'post',
                        url: '/register',
                        params: {
                            phone: this.phone,
                            password: this.registerPassword
                        }
                    }
                ).then(function (response) {
                    createToast("注册成功，请去登录吧","success")
                    this.registerPassword=''
                    this.rePassword=''
                    this.phone=''
                })
            }
        },
    }
}).mount('#app')
