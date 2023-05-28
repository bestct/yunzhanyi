document.getElementById('keyword').addEventListener('keydown', ev => {
    if (ev.key === 'Enter') {
        search()
    }
})
document.getElementById('searchBtn').addEventListener('click', search)

function search() {
    //搜索内容不能为空
    let keyword = document.getElementById('keyword').value.trim()
    if (keyword === '' || keyword === undefined) {
        Toastify({
            text: "搜索内容不能为空",
            duration: 2000,
            newWindow: true,
            close: false,
            gravity: "top", // `top` or `bottom`
            position: "center", // `left`, `center` or `right`
            stopOnFocus: true, // Prevents dismissing of toast on hover
            style: {
                //成功 linear-gradient(to right, #56ab2f, #a8e063)
                //警告 linear-gradient(to right, #f2994a, #f2c94c)
                //错误 linear-gradient(to right, #ed213a, #93291e)
                //提示 linear-gradient(to right, #2c3e50, #bdc3c7)
                background: "linear-gradient(to right, #f2994a, #f2c94c)",
            },
        }).showToast();
    } else {
        let searchType = document.getElementById('searchType').value
        if ('/search' === window.location.pathname) {
            window.location.href = `/search?keyword=${keyword}&searchType=${searchType}&hotWord=true`
        } else {
            window.open(`/search?keyword=${keyword}&searchType=${searchType}&hotWord=true`)
        }

    }
}

const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
