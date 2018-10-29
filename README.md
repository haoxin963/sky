# sky
sky是基于spring cloud的微服务接口开发平台，平台的目标是在高并发，大数据场景下能水平扩展和服务高可用。
平台包含API网关、统一权限认证、记录上传分库分表等多个模块，可以作为后端接口的开发脚手架和微服务学习入门框架。

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
## 项目结构
``` lua
sky
├── sky-base -- 基础模块
├    ├── sky-auth -- 统一权限中心
├    ├── sky-common -- 公共模块
├    ├── sky-mc-service -- 消息中心模块
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
![image.png](https://img-blog.csdnimg.cn/20181029172644223.png)
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
## 启动说明
### 环境及工具
- JDK: 1.8+
- MAVEN: 3.3+
- MYSQL: 5.7+
- Redis: 3.0+
- RabbitMQ：3.7+
- IDEA 2018(Lombok插件)
- Postman
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
使用postman调用接口
- 1.用户注册
URL：http://localhost:9999/restApi/record/registerUser
- 2.获取Token
URL：http://localhost:9999/auth/oauth/token
- 3.上传
URL：http://localhost:9999/restApi/record/addRecord
- 4.分页查询
URL：http://localhost:9999/restApi/record/2/page
- 5.详情查询
URL：http://localhost:9999/restApi/record/2

####有问题可以加在下方留言或关于微信公众号
![image.png](https://img-blog.csdnimg.cn/20181029204135821.jpg)




