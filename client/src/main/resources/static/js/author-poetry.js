import {createApp} from './vue.esm-browser.prod.js'
import instance from "./request.js";

createApp({
    created() {
        document.getElementById("app").hidden = false;
        this.authorId=document.getElementById('authorId').value
        this.getData()
    },
    data() {
        return {
            dataList: [],
            loading: true,
            pageIndex: 1,
            pageSize: 10,
            isNoMore: false,
            searchAuthor: "",
            authorId: ''
        }
    },
    methods: {
        getData() {
            this.loading = true
            instance({
                    url: "/author/poetry/" + this.authorId + "?searchVal=" + this.searchAuthor + "&pageNum=" + this.pageIndex + "&pageSize=" + this.pageSize,
                    method: 'get'
                }
            ).then(res => {
                this.dataList = this.dataList.concat(res.data.list)
                this.loading = false
                if (this.pageSize > res.data.list.length) {
                    this.isNoMore = true
                }
                this.pageIndex = this.pageIndex + 1;
            })
        },
        loadMore() {
            this.getData()
        },
        searchAuthorPoetry() {
            this.pageIndex = 1
            this.isNoMore = false
            this.dataList = []
            this.getData()
        }
    }
}).mount('#app')
