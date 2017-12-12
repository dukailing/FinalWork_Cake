# FinalWork_Cake
## 实现功能
1、前台登录与注册

2.注册后可以修改用户信息

3.从index可进入list页面

4.list实现分类分页与查询搜索

5.可进入蛋糕详情页面

6.在详情页可加入购物车

7.可点击购物车图标进入购物车页面

8.购物车页面可提交订单，可删除订单，可清空弄购物车

9.进入订单页面可以查看已提交订单

10.可退出登录进入index页面

11.后台实现管理员登录

12.管理员登陆后可以查看用户，订单与商品

13.管理员对商品可以实现增删改查

14.管理员可以修改和查询订单和用户
 
 
## 框架配置


1.jstl，mysql，commans，io，logining包druid包：连接池√

2.web.xml：删掉welcome其他剩
            添加其他四块web.xml内容√
	    
3.springmvc中修改扫描的包（3处）√
            缺文件上传√
	    
4.spring-bean.xml
    location：classpath.*。properties√
    
5.bonecp  连接池配置：DataSource（外延任务）属性边泪驱动类变了，增加包
（ckeditor副文本框）

<bean id="sessionFactory" class="org.springframework.orm.hibernate.LocalSessionFactoryBean" autowire="autodetect">
	<property name="hibernateProperties">
		<props>
			<prop key="hibernate.connection.provider_class">com.jolbox.bonecp.provider.BoneCPConnectionProvider</prop>
			<prop key="hibernate.connection.driver_class">com.mysql.jdbc.Driver</prop>
			<prop key="hibernate.connection.url">jdbc:mysql://127.0.0.1/yourdb</prop>
			<prop key="hibernate.connection.username">root</prop>
			<prop key="hibernate.connection.password">abcdefgh</prop>
			<prop key="bonecp.idleMaxAge">240</prop>
			<prop key="bonecp.idleConnectionTestPeriod">60</prop>
			<prop key="bonecp.partitionCount">3</prop>
			<prop key="bonecp.acquireIncrement">10</prop>
			<prop key="bonecp.maxConnectionsPerPartition">60</prop>
 			<prop key="bonecp.minConnectionsPerPartition">20</prop>
 			<prop key="bonecp.statementsCacheSize">50</prop>
 			<prop key="bonecp.releaseHelperThreads">3</prop>
		</props>
	</property>
</bean>

7.配置类@entity  @table()  @id√
