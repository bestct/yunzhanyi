import {createApp} from './vue.esm-browser.prod.js'
import instance from "./request.js";
import {createToast} from "./base.js";

createApp({
    created() {
        document.getElementById("app").hidden = false;
        this.getData()
    },
    data() {
        return {
            dataList: [],
            loading: true,
            pageIndex: 1,
            pageSize: 10,
            isNoMore: false,
            collectionType: 0
        }
    },
    methods: {
        getData() {
            this.loading = true
            instance({
                    url: 'collection?collectionType=' + this.collectionType + "&pageNum=" + this.pageIndex + "&pageSize=" + this.pageSize,
                    method: 'get'
                }
            ).then(res => {
                this.dataList = this.dataList.concat(res.data)
                this.loading = false
                if (this.pageSize > res.data.length) {
                    this.isNoMore = true
                }
                this.pageIndex = this.pageIndex + 1;
            })
        },
        loadMore() {
            this.getData()
        },
        switchType(collectionType) {
            if (collectionType !== this.collectionType) {
                this.collectionType = collectionType
                this.pageIndex = 1
                this.isNoMore = false
                this.dataList = []
                this.getData()
            }
        },
        doCollection(colId) {
            var spNode = document.getElementById('sp_' + colId)
            if (spNode.classList.contains('collect-cancel')) {
                instance({
                    url: '/collection/' + colId,
                    method: "delete"
                }).then(function (response) {
                    spNode.classList.remove('collect-cancel')
                    spNode.classList.add('collect-add')
                    createToast("取消收藏成功",'success')
                })
            } else {
                instance({
                    url: '/collection/' + colId,
                    method: "post"
                }).then(function (response) {
                    spNode.classList.remove('collect-add')
                    spNode.classList.add('collect-cancel')
                    createToast("收藏成功",'success')
                })
            }
        },
        resToTarget(resId, type) {
            if (type === 1) {
                window.open('/poetry/' + resId)
            } else if (type === 2) {
                window.open('/author/' + resId)
            }
        }
    }
}).mount('#app')
