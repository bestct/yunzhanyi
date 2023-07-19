import instance from "./request.js";
import {createToast, isEmail, isPhoneNumber} from "./base.js";
var PhoneModal, EmailModel
//显示手机绑定对话框
document.getElementById('showPhoneModalBtn').addEventListener('click', ev => {
    showPhoneModal()
})
//显示邮箱绑定对话框
document.getElementById('showEmailModalBtn').addEventListener('click', ev => {
    showEmailModal()
})
//绑定手机号
document.getElementById('bindPhoneBtn').addEventListener('click', ev => {
    bindPhone()
})
//绑定电子邮箱
document.getElementById('bindEmailBtn').addEventListener('click', ev => {
    bindEmail()
})

document.getElementById('cpButton').addEventListener('click', ev => {
    changePassword()
})

function showPhoneModal() {
    PhoneModal = new bootstrap.Modal(document.getElementById('phoneModal'), {
        //点击背景不关闭
        backdrop: "static",
        //触发键盘esc事件时不关闭
    })
    PhoneModal.show()
}

function showEmailModal() {
    EmailModel = new bootstrap.Modal(document.getElementById('emailModal'), {
        //点击背景不关闭
        backdrop: "static",
        //触发键盘esc事件时不关闭
    })
    EmailModel.show()
}

function bindPhone() {
    let phone = document.getElementById('phone').value;
    if (phone === '') {
        createToast('手机号不能为空', 'error')
        return;
    }
    if (!isPhoneNumber(phone)) {
        createToast('手机号格式错误！', 'error')
        return;
    }
    instance({
        url: "/bind/phone",
        method: 'post',
        params: {
            phone: phone
        }
    }).then(function (response) {
        createToast("绑定成功", "success")
        window.location.reload()
    });
}

function bindEmail() {
    let email = document.getElementById('email').value;
    if (email === '') {
        createToast('邮箱不能为空', 'error')
        return;
    }
    if (!isEmail(email)) {
        createToast('邮箱格式错误！', 'error')
        return;
    }
    instance({
        url: "/bind/email",
        method: 'post',
        params: {
            email: email
        }
    }).then(function (response) {
        createToast("绑定成功", "success")
        window.location.reload()
    });
}

function changePassword() {
    let password = document.getElementById("password").value;
    let rePassword = document.getElementById("rePassword").value;
    if (password === '') {
        createToast("请输入密码！", "error")
    } else if (password.length < 8) {
        createToast("密码长度不能小于8！", "error")
    } else if (rePassword !== password) {
        createToast("两次密码不一致", "error")
    } else {
        instance({
            url: '/change/password',
            method: 'post',
            params: {newPassword: password}
        }).then(function (response) {
            createToast("修改成功", "success")
        })
    }
}
