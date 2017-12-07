# FinalWork_Cake
框架配置

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
