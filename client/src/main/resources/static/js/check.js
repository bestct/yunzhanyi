import instance from "./request.js";
import {createApp} from './vue.esm-browser.prod.js'
import {createToast} from "./base.js";

createApp
({
    created() {
        document.getElementById("app").hidden = false;
        this.loadForm()
    },
    data() {
        return {
            formHtml: "",
            formsName: "",
            searchResult: "",
            searchHanZi: "",
            selectedFormId: 1,
            selectedFirstId: 1,
            rhymeBookId: 1,
            content: '',
            selectedForm: [{id: 1, name: "五律"}, {id: 2, name: "五绝"}, {id: 3, name: "七律"}, {id: 4, name: "七绝"}],
            selectedFirst: [{id: 1, name: "仄起首句不入韵"}, {id: 2, name: "仄起首句入韵"}, {id: 3, name: "平起首句不入韵"}, {
                id: 4,
                name: "平起首句入韵"
            }],
            formList: [
                {formsCode: "31201,00114;20011,31104;31201,00114;20011,31104", formsId: "1-1", formsName: "五律·仄起首句不入韵"},
                {formsCode: "31104,00114;20011,31104;31201,00114;20011,31104", formsId: "1-2", formsName: "五律·仄起首句入韵"},
                {formsCode: "20011,31104;31201,00114;20011,31104;31001,00114", formsId: "1-3", formsName: "五律·平起首句不入韵"},
                {formsCode: "00114,31104;31201,00114;20011,31104;31001,00114", formsId: "1-4", formsName: "五律·平起首句入韵"},
                {formsCode: "31201,00114;20011,31104", formsId: "2-1", formsName: "五绝·仄起首句不入韵"},
                {formsCode: "31124,00114;20011,31104", formsId: "2-2", formsName: "五绝·仄起首句入韵"},
                {formsCode: "20011,31104;31201,00114", formsId: "2-3", formsName: "五绝·平起首句不入韵"},
                {formsCode: "00114,31104;31201,00114", formsId: "2-4", formsName: "五绝·平起首句入韵"},
                {
                    formsCode: "3120011,2031104;2031201,3100114;3120011,2031104;2031201,3100114",
                    formsId: "3-1",
                    formsName: "七律·仄起首句不入韵"
                },
                {
                    formsCode: "3100114,2031104;2031201,3100114;3120011,2031104;2031201,3100114",
                    formsId: "3-2",
                    formsName: "七律·仄起首句入韵"
                },
                {
                    formsCode: "2031201,3100114;3120011,2031104;2031201,3100114;3120211,2031104",
                    formsId: "3-3",
                    formsName: "七律·平起首句不入韵"
                },
                {
                    formsCode: "2031104,3100114;3120011,2031104;2031201,3100114;3120211,2031104",
                    formsId: "3-4",
                    formsName: "七律·平起首句入韵"
                },
                {formsCode: "3120011,2031104;2031201,3100114", formsId: "4-1", formsName: "七绝·仄起首句不入韵"},
                {formsCode: "3100114,2031104;2031201,3100114", formsId: "4-2", formsName: "七绝·仄起首句入韵"},
                {formsCode: "2031201,3100114;3120011,2031104", formsId: "4-3", formsName: "七绝·平起首句不入韵"},
                {formsCode: "2031104,3100114;3120011,2031104", formsId: "4-4", formsName: "七绝·平起首句入韵"}
            ]
        }
    },
    //监听
    watch: {
        selectedFormId(newSelectedFormId, oldSelectedFormId) {
            this.loadForm()
        },
        selectedFirstId(newSelectedFirstId, oldSelectedFirstId) {
            this.loadForm()
        }
    },
    methods: {
        check() {
            instance({
                    url: "/rhyme/check",
                    method: 'post',
                    data: {
                        checkContent: this.content,
                        formType: this.selectedFormId,
                        firstType: this.selectedFirstId,
                        rhymeBookId: this.rhymeBookId
                    }
                }
            ).then(res => {
                document.getElementById('checkSuccess').hidden = false
                document.getElementById("codeResult").innerHTML = res.data.codeResult;
                document.getElementById('suggest').innerHTML = res.data.suggest
            })
        },
        searchHanzi() {
            instance({
                    url: "/rhyme/search?hanZi=" + this.searchHanZi,
                    method: 'get'
                }
            ).then(res => {
                let HTML = "<ul class= 'nav nav-underline' role='tablist'>"
                res.data.forEach((itemData, index) => {
                    for (let i = 0; i < itemData.rhymeList.length; i++) {
                        let rhyme = itemData.rhymeList[i]
                        HTML += "<li class = 'nav-item'>"
                        let className = ''
                        if (index === 0 && i === 0) {
                            className = "class = 'nav-link active'"
                        } else {
                            className = "class = 'nav-link'"
                        }
                        let href = "href='#" + index + "-" + i + "'"
                        HTML += "<a " +
                            className + " " + href +
                            " data-bs-toggle='tab'>" + itemData.rhymeBookName + "·" + rhyme.rhymeName + "</a>"
                        HTML += "</li>"
                    }
                })
                HTML += "</ul>"

                HTML += "<div class='tab-content'>"
                res.data.forEach((itemData, index) => {
                    for (let i = 0; i < itemData.rhymeList.length; i++) {
                        let rhyme = itemData.rhymeList[i];
                        let className = ''
                        if (index === 0 && i === 0) {
                            className = "class = 'container tab-pane active'";
                        } else {
                            className = "class = 'container tab-pane fade'";
                        }
                        let id = "id='" + index + "-" + i + "'";
                        HTML += "<div " + id + " " +className + ">"
                        HTML +="<div  style='letter-spacing:5px;line-height: 1.5;padding-top: 4px;'>"+ rhyme.rhymeCharacter+"</div>"
                        HTML += "</div>"
                    }
                })
                HTML += "</div>"
                document.getElementById('searchSuccess').hidden = false
                this.searchResult = HTML;
            })
        },
        loadForm() {
            let formId = parseInt(this.selectedFormId) + "-" + parseInt(this.selectedFirstId);
            let formCode = ""
            let formsName = ""
            var formList = this.formList
            for (const key in formList) {
                const element = formList[key];
                if (element.formsId === formId) {
                    formCode = element.formsCode
                    formsName = element.formsName
                    break
                }
            }
            let formHtml = ""
            for (let i in formCode) {
                let char = formCode[i]
                if (char !== ';' && char !== ',') {
                    switch (char) {
                        case '0':
                            formHtml += "平"
                            break;
                        case '1':
                            formHtml += "仄"
                            break;
                        case '2':
                            formHtml += "<span style='color: gray'>" + "平" + "</span>"
                            break;
                        case '3':
                            formHtml += "<span style='color: gray'>" + "仄" + "</span>"
                            break;
                        case '4':
                            formHtml += "<span style='color: purple'>" + "平" + "</span>"
                            break;
                        case '5':
                            formHtml += "<span style='color: purple'>" + "仄" + "</span>"
                            break;
                        default:
                            break;
                    }
                } else {
                    if (char === ',') {
                        formHtml += "，"
                    } else {
                        formHtml += "<br/>"
                    }
                }
            }
            this.formHtml = formHtml
            this.formsName = formsName
        },
    }
}).mount('#app')
