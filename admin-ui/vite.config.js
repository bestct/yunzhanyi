import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'
// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    // 别名
    base: './',
    resolve: {
        alias: {
            // 设置路径
            '~': path.resolve(__dirname, './'),
            // 设置别名
            '@': path.resolve(__dirname, './src')
        },
    },
    build: {
        outDir: 'dist', //指定打包输出路径
        assetsDir: 'assets', //指定静态资源存放路径
        cssCodeSplit: true, //css代码拆分,禁用则所有样式保存在一个css里面
        sourcemap: false, //是否构建source map 文件
        // 生产环境取消 console
        minify: 'terser',
        terserOptions: {
            compress: {
                drop_console: true,
                drop_debugger: true
            }
        },
        //会打包出 css js 等文件夹 目录显得清晰
        rollupOptions: {
            output: {
                chunkFileNames: 'js/[name]-[hash].js',
                entryFileNames: 'js/[name]-[hash].js',
                assetFileNames: '[ext]/[name]-[hash].[ext]'
            }
        }
    },

    server: {
        host: '0.0.0.0',
        https: false,
        outDir: 'dist',
        port: 81,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, ''),
            },
        }
    }
})
