# ShardingSphere
<br /><br />
# 初期阶段：垂直分库和垂直分表
# 后期阶段：水平分库和水平分表

<br />

# 垂直拆分
將業務的不同分類，不同的業務劃分到不同的應用。這種拆分往往是根據系統的改造，將原來的功能模組依照更細粒度的拆分成多個弱耦合的服務

## 垂直分库：
按照业务模块将数据分散到不同的数据库中，每个数据库存储一个业务模块的数据。

假设我们有一个外賣系统，包含 商品管理 订单管理 用户管理 三个主要业务模块。我们可以按照业务将数据垂直拆分成三个数据库：
![image](https://github.com/lzz0826/EventualConsistency/blob/main/img/10.png)

## 垂直分表：
将一个表中的列按照不同的业务逻辑拆分成多个表，以减少单个表的宽度，提高查询性能。

设我们有一个用户表 users，包含用户的基本信息和详细信息。为了优化查询，我们可以将用户表垂直拆分成两个表：


![image](https://github.com/lzz0826/EventualConsistency/blob/main/img/10.png)

# 水平拆分

## 库内分表：
![image](https://github.com/lzz0826/EventualConsistency/blob/main/img/10.png)

## 分库分表：
![image](https://github.com/lzz0826/EventualConsistency/blob/main/img/10.png)


