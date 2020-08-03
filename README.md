# README

## 项目简介

## 模块设计

### 模块设计基本原则

| 原则 | 采用原则原因 |
| ---- | ------------ |
|      |              |
|      |              |
|      |              |

### 模块的基本命名规范

顶级域名.公司或组织域名，例子如下：

```java
com.ecommerce
```

### 领域模型的命名规范

接下一层模块命名定位为限界上下文，不用品牌命名的原因是品牌名比限界上下文易变，例子如下：

```
com.ecommerce.oder
```

接下来，下一层模块的命名规范根据业务或架构都可以，分层架构如下：

```
com.ecommerce.oder.domain 领域层
com.ecommerce.oder.domain.model 聚合根层
com.ecommerce.oder.domain.service 领域服务层
com.ecommerce.oder.application 应用服务层
com.ecommerce.oder.application.command 命令对象层
com.ecommerce.oder.application.representation 展示对象层
com.ecommerce.oder.adapter 适配器层
com.ecommerce.oder.adapter.datasource 数据源
com.ecommerce.oder.adapter.transport 传输层
com.ecommerce.oder.common 公共组件
com.ecommerce.oder.common.spring spring配置层
com.ecommerce.oder.common.spring.messaging
com.ecommerce.oder.common.spring.exception
com.ecommerce.oder.common.utils
com.ecommerce.oder.common.exception
com.ecommerce.oder.common.event
com.ecommerce.oder.common.service
com.ecommerce.oder.common.domain.model
```

