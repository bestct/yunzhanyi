import instance from "./request.js";
import {createToast} from "./base.js";
document.getElementById('advise').addEventListener("click",ev => {
    let perfectTitle = document.getElementById('perfect-title').value;
    let perfectContent = document.getElementById('perfect-content').value;
    if (perfectContent == null || perfectContent === '') {
        createToast('内容不能为空','warning')
        return
    }
    if (perfectTitle == null || perfectTitle === '') {
        createToast('标题不能为空','warning')
        return
    }
    instance({
        url: '/perfect',
        method: 'post',
        data: {
            perfectTitle: perfectTitle,
            perfectContent: perfectContent,
            perfectType: 0
        },
    }).then(function (response) {
        createToast('提交成功','warning')
    })
    document.getElementById('perfect-title').value = ''
    document.getElementById('perfect-content').value = ''
})
