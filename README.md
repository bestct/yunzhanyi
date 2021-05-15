
# yunzhanyi
# 云沾衣后端+后台项目



### 前言

**纵使晴明无雨色,入云深处亦沾衣**  ——【唐】张旭


## 数据库

云沾衣共收录八十万余首诗词古文


### 组织结构

``` lua
yunzhanyi
├── yuanzhanyi-common -- 工具类及通用代码
├── yunzhanyi-opposite -- MyBatisGenerator生成的数据库操作代码
├── yunzhanyi-admin -- 后台诗词古文管理
├── yunzhanyi-search -- 基于Elasticsearch的诗词搜索系统 // 未开始
```



### 技术选型

#### 后端技术

| 技术                 | 说明                | 官网                                           |
| -------------------- | ------------------- | ---------------------------------------------- |
| SpringBoot2.4     | 容器+MVC框架        | https://spring.io/projects/spring-boot         |
| junit5      | 单元测试      | https://sourceforge.net/projects/junit/     |
| thymeleaf       | 后端页面渲染      | https://www.thymeleaf.org/     |
| SpringSecurity5      | 认证和授权框架      | https://spring.io/projects/spring-security     |
| MyBatis3.5          | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator     | 数据层代码生成      | http://www.mybatis.org/generator/index.html    |
| Druid                | 数据库连接池        | https://github.com/alibaba/druid               |
| PageHelper           | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper |

#### 前端技术

| 技术       | 说明                  | 官网                                   |
| ---------- | --------------------- | -------------------------------------- |
| Vue        | 前端框架              | https://vuejs.org/                     |
| Element    | 前端UI框架            | https://element.eleme.io               |
| Axios      | 前端HTTP框架          | https://github.com/axios/axios         |
| Qs      | 前端HTTP请求插件          | https://github.com/ljharb/qs         |



### 开发工具

| 工具          | 说明                | 官网                                            |
| ------------- | ------------------- | ----------------------------------------------- |
| IDEA          | 开发IDE             | | X-shell       | Linux远程连接工具   | http://www.netsarang.com/download/software.html |
| Navicat       | 数据库连接工具      | http://www.formysql.com/xiazai.html             |
| Snipaste      | 屏幕截图工具        | https://www.snipaste.com/                       |
| Postman       | API接口调试工具      | https://www.postman.com/                        |
| Typora        | Markdown编辑器      | https://typora.io/                              |




| 工具  | 版本号 | 下载                                                         |
| ----- | ------ | ------------------------------------------------------------ |
| JDK   | 11     | https://www.oracle.com/java/technologies/javase-jdk11-downloads.html |
| MySQL | 8.0    | https://www.mysql.com/                                       |

## 友情提示

> 1. **快速体验项目**：[在线访问地址](http://www.yunzhanyi.net/login.html)。游客账号: yzy111111  	密码:123456
> 5. **项目交流**：想要加群交流项目的朋友，可以加入[云沾衣技术交流群]: 1056424843
