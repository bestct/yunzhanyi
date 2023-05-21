import instance from "./request.js";

const content = document.getElementById("content");
const rhymeBookIds = document.getElementsByName('rhymeBookId')
const selectedForm = document.getElementById("selectedForm")
const selectedFirst = document.getElementById("selectedFirst")

document.getElementById('checkBtn').onclick = function () {
    let rhymeBookId
    for (let i = 0; i < rhymeBookIds.length; i++) {
        if (rhymeBookIds[i].checked === true) {
            rhymeBookId = rhymeBookIds[i].value
            break
        }
    }
    instance({
            url: "/rhyme/check",
            method: 'post',
            data: {
                checkContent: content.value,
                formType: selectedForm.value,
                firstType: selectedFirst.value,
                rhymeBookId: rhymeBookId
            }
        }
    ).then(res => {
        document.getElementById('checkSuccess').hidden=false
        document.getElementById("codeResult").innerHTML=res.data.codeResult;
        document.getElementById('suggest').innerHTML=res.data.suggest
    })
}
