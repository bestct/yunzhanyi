# 云沾衣诗词网 -入云深处亦沾衣
<img src="https://res.yunzhanyi.net/static/img/main_logo_black.png" width="200"/>

读几首诗 采几片云
云沾衣 出自唐代的书法家，诗人张旭《山中留客》一诗中的
“纵使晴明无雨色，入云深处亦沾衣。”

**官网**：[云沾衣诗词官网](https://www.yunzhanyi.net)

### 项目模块

```
├─yunzhanyi  -父项目
  └─admin    -管理端API
  └─client   -客户端
  └─domain   -数据库操作
  └─common   -通用模块
    └─core     -核心模块
    └─redis    -缓存模块
    └─security -安全模块
    └─swagger  -接口文档模块
    └─web      -web模块
```
### 项目主要依赖：
**后端**
- SpringBoot 2.7.4
- MySQL 8.0
- MyBatis 3.5.7
- MyBatis-Plus 3.5.7
- Swagger3
- Fastjson

**前端**
- Thymeleaf
- Bootstrap5
- Vue3
- Axios

#### 技术栈考虑
- 网站管理端在有来后台管理框架基础上进行改造。采用前后端分离模式，项目[admin模块](https://github.com/bestct/yunzhanyi/tree/master/admin) 为后端API
前端UI地址为[https://github.com/bestct/yunzhanyi-admin-ui](https://github.com/bestct/yunzhanyi-admin-ui)
  
- 网站客户端采用前后端不分离模式。使用 Thymeleaf + Vue3 在SEO和客户体验之间进行取舍，在用户操作复杂页面使用Vue。

### 本地环境
- Java 11
- MySQL 8.0
- Redis

### TODO
- [x] 用户相关
- [x] 诗词相关
- [x] 诗人相关
- [x] 诗词作者搜索
- [x] 收藏
- [x] 黑夜模式
- [x] 韵部查询
- [x] 诗格律检测
- [x] 课本诗词
- [ ] 词格律检测
- [ ] 诗词格律教学
- [ ] 词谱
- [ ] 自由诗（现代诗）

### 数据库
*四十万诗词加详情和两万的作者 SQL文件实在太大,所以放在了qq群里*
### 联系开发者
#### 公众号
<img src="https://res.yunzhanyi.net/static/img/qrcode_gzh.jpg" width="200"/>

#### qq群
<img src="https://res.yunzhanyi.net/static/img/qun.jpg" width="200"/>

### 支持一下
<img src="https://res.yunzhanyi.net/static/img/zanshang.png" width="200"/>
