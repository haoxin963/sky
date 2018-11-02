# sky平台
## 简介
sky平台是基于spring cloud的微服务接口开发平台，平台的目标是在高并发，大数据场景下支持水平扩展和服务高可用。

平台包含API网关、统一权限认证、记录上传分库分表等多个模块，可以作为后端接口的开发脚手架或微服务学习入门框架。

## 功能列表
- 服务注册发现：使用Eureka实现
- 配置文件：git和消息总线实现动态实时刷新
- 统一网关：支持多端流量控制的zuul网关服务
- 服务鉴权：oauth2.0+JWT统一权限认证
- 负载均衡及熔断：Feig+Hystrix
- 服务监控: SpringBootAdmin监控服务状态
- 链路追踪： zipkin链路图形化展示
- 用户管理：rbac用户权限角色管理
- 分库分表：基于shardingdbc分库分表
- 分布式锁：Redis+Redisson实现分布式锁
- 分布式事务：lcn分布式事务
- 分布式ID：Twitter的snowflake算法
- CRUD ：mybatis-plus的增删改查，分页，代码生成
- 接口文档：使用swagger文档管理
- 缓存服务：RedisTemplate+SpringCache
- 消息服务：阿里鱼的短信服务
- 日志管理，支持日保存ELK，图形化展示
- 部署发布：使用docker+jenkins自动发布
- 分布式任务调度：基于zookeeper的elastic-job实现
## 项目结构
``` lua
sky
├── sky-base -- 基础模块
├    ├── sky-auth -- 统一权限中心
├    ├── sky-common -- 公共模块
├    ├── sky-mc-service -- 消息中心模块
├    ├── sky-elastic-job -- 分布式任务调度模块
├    └── sky-tx-client -- 分布式事务客户端模块
├    └── sky-tx-manager -- 分布式事务协调模块
├── sky-control -- spring cloud服务模块
├    ├── sky-config -- 配置中心
├    ├── sky-eureka -- 服务注册发现
├    ├── sky-monitor -- 服务监控
├    └── sky-zipkin -- zipkin监控模块
├    └── sky-zuul -- 网关服务
└── sky-modules  -- 业务模块 
├    ├── sky-rbac-service -- 用户权限模块
├    ├── sky-record-api -- demo-记录接口
├    └── sky-record-service -- demo-记录服务
```
## 架构 
![输入图片说明](https://images.gitee.com/uploads/images/2018/1029/211344_a7376ab7_1207662.png "技术架构 (26).png")
## 核心技术
- [Spring Cloud](https://blog.csdn.net/haoxin963/article/details/82217548) 
- [RabbitMQ](https://blog.csdn.net/haoxin963/article/details/83351979) 
- [Redis](https://blog.csdn.net/haoxin963/article/details/83141487)
- [OAuth2.0](https://blog.csdn.net/haoxin963/article/details/82859487)
- [JWT](https://blog.csdn.net/haoxin963/article/details/82860284)
- [分布式锁](https://blog.csdn.net/haoxin963/article/details/83098510)
- [分布式ID](https://blog.csdn.net/haoxin963/article/details/83098885)
- [分布式事务](https://blog.csdn.net/haoxin963/article/details/81777348)
- [docker](https://blog.csdn.net/haoxin963/article/details/81906667)
- [jenkins](https://blog.csdn.net/haoxin963/article/details/81870545)
- [ELK](https://blog.csdn.net/haoxin963/article/details/81506817)
- [ZooKeeper ](https://blog.csdn.net/haoxin963/article/category/8239099)
## 启动说明
### 环境及工具
- JDK: 1.8+
- MAVEN: 3.3+
- MYSQL: 5.7+
- Redis: 3.0+
- RabbitMQ：3.7+
- IDEA 2018(需要安装Lombok插件)
- Postman
### 配置文件
https://gitee.com/haoxin963/sky-config
### 启动顺序
- sky-eureka
- sky-config
- sky-rbac-service
- sky-auth
- sky-zuul
- 其他模块
### docker+jenkins部署
关注微信公众号查看
## 演示
使用Postman调用接口
- 1.用户注册
URL：http://localhost:9999/restApi/record/registerUser
![用户注册](https://images.gitee.com/uploads/images/2018/1030/135018_21174675_1207662.png "TIM截图20181030113252.png")
- 2.获取Token
URL：http://localhost:9999/auth/oauth/token
![获取Token](https://images.gitee.com/uploads/images/2018/1030/135056_5b1387f9_1207662.png "TIM截图20181030131228.png")
- 3.上传记录
URL：http://localhost:9999/restApi/record/addRecord
![上传记录](https://images.gitee.com/uploads/images/2018/1030/135113_6abca477_1207662.png "TIM截图20181030131409.png")
- 4.分页查询
URL：http://localhost:9999/restApi/record/2/page
![分页查询](https://images.gitee.com/uploads/images/2018/1030/135138_087dfcb6_1207662.png "TIM截图20181030134322.png")
- 5.详情查询
URL：http://localhost:9999/restApi/record/2/505425581337214976
![详情查询](https://images.gitee.com/uploads/images/2018/1030/135155_a1dae00c_1207662.png "TIM截图20181030134119.png")
#### 接口详细调用demo:[查看](https://blog.csdn.net/haoxin963/article/details/83512953)

#### 有问题请在下方留言也可以微信公众号交流
![输入图片说明](https://images.gitee.com/uploads/images/2018/1029/211403_fad1d1b3_1207662.jpeg "qrcode_for_gh_0d1ad0d8e872_258.jpg")



