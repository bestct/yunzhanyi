(() => {
    'use strict'
    const storedTheme = localStorage.getItem('theme')
    const getPreferredTheme = () => {
        if (storedTheme) {
            return storedTheme
        }
        return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'
    }

    const setTheme = function (theme) {
        if (theme === 'auto' && window.matchMedia('(prefers-color-scheme: dark)').matches) {
            document.documentElement.setAttribute('data-bs-theme', 'dark')
        } else {
            document.documentElement.setAttribute('data-bs-theme', theme)
        }
    }
    if (storedTheme === 'dark') {
        document.getElementById("darkmode-toggle").checked = true;
    }

    setTheme(getPreferredTheme())

    document.getElementById("darkmode-toggle").addEventListener("click", function (event) {
        const theme = event.target.checked ? 'dark' : 'light'
        localStorage.setItem('theme', theme)
        setTheme(theme)
    })
    /*

        const showActiveTheme = theme => {
            const activeThemeIcon = document.querySelector('.theme-icon-active use')
            const btnToActive = document.querySelector(`[data-bs-theme-value="${theme}"]`)
            const svgOfActiveBtn = btnToActive.querySelector('svg use').getAttribute('href')

            document.querySelectorAll('[data-bs-theme-value]').forEach(element => {
                element.classList.remove('active')
            })

            btnToActive.classList.add('active')
            activeThemeIcon.setAttribute('href', svgOfActiveBtn)
        }

        window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', () => {
            if (storedTheme !== 'light' || storedTheme !== 'dark') {
                setTheme(getPreferredTheme())
            }
        })

        window.addEventListener('DOMContentLoaded', () => {
            showActiveTheme(getPreferredTheme())

            document.querySelectorAll('[data-bs-theme-value]')
                .forEach(toggle => {
                    toggle.addEventListener('click', () => {
                        const theme = toggle.getAttribute('data-bs-theme-value')
                        localStorage.setItem('theme', theme)
                        setTheme(theme)
                        showActiveTheme(theme)
                    })
                })
        })*/
})()

document.getElementById('searchBtn').addEventListener('click', function () {
    //搜索内容不能为空
    let keyword = document.getElementById('keyword').value
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
})

const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
