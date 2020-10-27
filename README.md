<<<<<<< HEAD
#  SpringMVC 项目

主要理解SpringMVC的流程，重点是DispatchServlet的工作流程

具体笔记见 SpringMVC.md

## 1.配置环境

- JDK 	        1.8.0_261
- Maven       3.3.9
- Spring         2.3.4
- Tomcat       9.0.39
- Idea             2017.3.7

**注意**：部分项目集成了Mybatis，版本如下

- Mybatis（3.5.2）

- mybatis-spring（2.0.2）

- MySQL（5.6.50）

  - 数据库表（数据库-spring_test）

    ```sql
    DROP TABLE IF EXISTS `user`;
    CREATE TABLE `user` (
      `id` int(20) NOT NULL,
      `name` varchar(30) DEFAULT NULL,
      `pwd` varchar(30) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    ```

    

=======
# Spring
Just simple Spring demos
MYSQL
Myeclipse
jdk1.7
>>>>>>> 71c03f24235bb5dc76f46130174f33fe831fa575
