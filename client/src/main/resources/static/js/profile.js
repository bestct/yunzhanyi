import instance from "./request.js";
import {createToast} from "./base.js";

document.getElementById('savaUser').addEventListener('click', ev => {
    savaUser()
})

function savaUser() {
    let nickName = document.getElementById('nickName').value;
    let sexInputs = document.getElementsByName("sex");
    let sex;
    for (let i = 0; i < sexInputs.length; i++) {
        let sexInput = sexInputs[i];
        if (sexInput.checked) {
            sex = sexInput.value
            break
        }
    }
    let signature = document.getElementById('signature').value;

    if (nickName === '' || nickName === null) {
        createToast('昵称不能为空', "warning")
    }
    instance({
        url: "/save/user",
        method: 'post',
        data: {
            nickName: nickName,
            signature: signature,
            sex: sex
        }
    }).then(function (response) {
        createToast("保存成功", 'success')
    });
}
