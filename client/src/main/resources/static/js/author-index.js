import {createApp} from './vue.esm-browser.prod.js'
import instance from "./request.js";

createApp({
    created() {
        document.getElementById("app").hidden = false;
        this.indexDynasty = document.getElementById('indexDynasty').value
        this.getData()
    },
    data() {
        return {
            dynastyList: JSON.parse("[{\"dynastyId\":0,\"dynastyName\":\"全部\"},{\"dynastyId\":1,\"dynastyName\":\"先秦\"},{\"dynastyId\":2,\"dynastyName\":\"两汉\"},{\"dynastyId\":3,\"dynastyName\":\"魏晋\"},{\"dynastyId\":4,\"dynastyName\":\"南北朝\"},{\"dynastyId\":5,\"dynastyName\":\"隋代\"},{\"dynastyId\":6,\"dynastyName\":\"唐代\"},{\"dynastyId\":7,\"dynastyName\":\"五代\"},{\"dynastyId\":8,\"dynastyName\":\"宋代\"},{\"dynastyId\":9,\"dynastyName\":\"辽朝\"},{\"dynastyId\":10,\"dynastyName\":\"金朝\"},{\"dynastyId\":11,\"dynastyName\":\"元代\"},{\"dynastyId\":12,\"dynastyName\":\"明代\"},{\"dynastyId\":13,\"dynastyName\":\"清代\"},{\"dynastyId\":14,\"dynastyName\":\"近现代\"}]"),
            dataList: [],
            loading: true,
            pageIndex: 1,
            pageSize: 10,
            isNoMore: false,
            indexDynasty: 0,
        }
    },
    methods: {
        getData() {
            this.loading = true
            instance({
                    url: "/index/author?dynasty=" + this.indexDynasty+ "&pageNum=" + this.pageIndex + "&pageSize=" + this.pageSize,
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
        clickIndexDynasty(dynasty) {
            this.pageIndex = 1
            this.indexDynasty = dynasty
            this.isNoMore = false
            this.dataList = []
            this.getData()
        }
    }
}).mount('#app')
