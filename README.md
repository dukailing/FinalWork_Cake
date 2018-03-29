# FinalWork_Cake
## 实现功能
1.前台登录与注册

2.注册后可以修改用户信息并保存

3.从首页index可进入蛋糕list页面

4.list实现从数据库分类分页与查询搜索并显示

5.可进入蛋糕详情页面（蛋糕信息从数据库提取）
 
6.在详情页可加入购物车（存入数据库）
 
7.可点击购物车图标进入购物车页面（可直接跳转）
 
8.购物车页面可提交订单，可删除订单，可清空购物车，从购物车页面进入订单页面（用户在登陆后可各个页面可进入购物车页面） 

9.进入订单页面可以查看已提交订单，对订单进行删除

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
8.进行功能实现
//////////////////////////////////////////////////////////////////////////
作业中练习（未做）

spring与hibernate的实体bean的注解配置（共六种情况）

用户登录表userLogin

账号loginname

密码password

用户真实信息userInfo

    loginname  realNama
    
角色表

权限表

角色权限分配表（多对多）

///////////////////////////////////////////////////////////////////////

11/22

收获：在配置好文件后配置类的注解，报错404原因：注解错误

-->在spring-bean中配置sessionfactory可用bonecp连接池，替换属性和jar包

///////////////////////////////////////////////////////////////////////

11/23

绝对路径：/项目名/类名

添加语句

<%@ taglib uri="http://java.sun.com/jsp/jstl/core " prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

使用${ctx}/文件夹/文件

用户登录：怎样通过姓名查找用户、用assigned生成id方法？？

ctx报错：多写一层文件夹名

bonecp报错

//////////////////////////////////////////////////////////////////////////////////////////////////////

11/25

登录逻辑完成，但仅登录一次，第二次404？？？

错误Unknown column 'users0_.sddress' in 'field list'

解决办法：Users类中的注解错误


	<c:forEach items="${list }" var="cake">
		${cake.gname }<br>
	</c:forEach>

问题：

注册页面跳转不成功Don't know how to iterate over supplied "items" in &lt;forEach&gt;

////////////////////////////////////////////////////////////////////////////////////////////////////////

11-25至11-30使用SpringMVC进行基本功能的实现并完成。 

 
