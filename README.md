# dynamic-datasource
基于注解的多数据源动态切换


spring:
  jpa:
    open-in-view: true
    show-sql: true
    hibernate:
      ddl-auto: update
  datasource:
    url: jdbc:mysql://localhost:3306/data1?serverTimezone=UTC
    username: root
    password: 1105lwc
    driverClassName: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    pool:
      initialSize: 10
      minIdle: 0
      maxActive: 1000
      maxWait: 60000
      timeBetweenEvictionRunsMillis: 60000
      minEvictableIdleTimeMillis: 300000
      testWhileIdle: true
      testOnBorrow: false
      testOnReturn: false
      preparedStatement: true
      poolPreparedStatements: true
      connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
dynamic:
  datasource:
    ds1:
      url: jdbc:mysql://localhost:3306/data2?serverTimezone=UTC
      username: root
      password: 1105lwc
      driverClassName: com.mysql.cj.jdbc.Driver
    ds2:
      url: jdbc:mysql://localhost:3306/data3?serverTimezone=UTC
      username: root
      password: 1105lwc
      driverClassName: com.mysql.cj.jdbc.Driver
    ds3:
      url: jdbc:mysql://localhost:3306/data3?serverTimezone=UTC
      username: root
      password: 1105lwc
      driverClassName: com.mysql.cj.jdbc.Driver
      
支持多种数据库连接池，全注解实现。

使用方法

1,导包

 <dependency>
            <groupId>com.g7go</groupId>
            <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
            <version>1.0.0-RELEASE</version>
        </dependency>
        
2,开启

在启动类添加
@EnableDynamicDataSource
