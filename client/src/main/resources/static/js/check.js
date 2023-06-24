import instance from "./request.js";

const content = document.getElementById("content");
const rhymeBookIds = document.getElementsByName('rhymeBookId')
const selectedForm = document.getElementById("selectedForm")
const selectedFirst = document.getElementById("selectedFirst")
document.getElementById('searchHanZi').addEventListener('keydown', ev => {
    if (ev.key === 'Enter') {
        searchHanzi()
    }
})

document.getElementById('searchZiBtn').addEventListener('click',ev => {
    searchHanzi()
})


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
        document.getElementById('checkSuccess').hidden = false
        document.getElementById("codeResult").innerHTML = res.data.codeResult;
        document.getElementById('suggest').innerHTML = res.data.suggest
    })
}

export default function searchHanzi() {
    instance({
            url: "/rhyme/search?hanZi=" + document.getElementById('searchHanZi').value,
            method: 'get'
        }
    ).then(res => {
        let HTML = "<div>"
        document.getElementById('searchSuccess').hidden = false
        for (const rhymeBook of res.data) {
            HTML += "<div style='padding: 10px'>"
            HTML += "<h4>" + rhymeBook.rhymeBookName + "</h4>"
            let rhymeList = rhymeBook.rhymeList
            HTML+="<div style='margin: 10px'>"
            for (const rhyme of rhymeList) {
                HTML+="<h5>"
                HTML+=rhyme.rhymeName
                HTML+="</h5>"
                HTML+="<div style='letter-spacing:5px;line-height: 1.5;'>"
                HTML+=rhyme.rhymeCharacter
                HTML+="</div>"
            }
            HTML+="</div>"
            HTML += "</div>"
        }
        HTML += "</div>"
        document.getElementById("searchResult").innerHTML = HTML;
    })
}
