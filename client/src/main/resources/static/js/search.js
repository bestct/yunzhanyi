import {createApp} from './vue.esm-browser.prod.js'
import instance from "./request.js";

createApp({
    created() {
        document.getElementById("app").hidden = false;
        this.keyword = document.getElementById("keyword").value;
        this.searchType = document.getElementById('searchType').value;
        this.getData()
    },
    data() {
        return {
            dataList: [],
            loading: true,
            pageIndex: 1,
            pageSize: 10,
            isNoMore: false,
            keyword: "我",
            searchType: null
        }
    },
    methods: {
        getData() {
            this.loading = true
            instance({
                    url: "/search?keyword=" + this.keyword + "&searchType=" + this.searchType + "&pageNum=" + this.pageIndex + "&pageSize=" + this.pageSize,
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
        switchType(searchType) {
            if (searchType !== this.searchType) {
                this.searchType=searchType
                this.pageIndex=1
                this.isNoMore=false
                this.dataList=[]
                this.getData()
            }
        }
    }
}).mount('#app')
