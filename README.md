# 图书借阅智能管理系统
## 项目简介
基于JDK17 + SpringBoot3 + MyBatis + MySQL开发的后端接口管理系统，配套科技深色前端可视化页面，实现图书CRUD、分页模糊检索、图书借阅/归还、事务控制、全局异常处理等企业级功能，适配Java实习生简历项目。
## 技术栈
JDK 17 | SpringBoot3 | MyBatis | MySQL8 | Maven | Vue2 前端
## 启动步骤
1. 执行mysql建表SQL创建book_db数据库
2. 修改application.yml数据库账号密码
3. VSCode打开项目，运行BookManageApplication启动类
4. 浏览器访问：http://localhost:8080/api/index.html
## 核心功能
1. 图书分页模糊查询、新增、编辑、删除
2. 图书借阅（库存扣减事务）、归还（库存恢复）
3. 全部借阅记录查询，未归还标红提示
4. 全局统一返回、自定义业务异常、跨域配置