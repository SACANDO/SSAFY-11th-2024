# Mybatis

# 설정하기

## xml + annotation 방식

### servlet-context.xml

- 뷰리졸버
- 컨트롤러

```java
<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Spring MVC가 동작하는데 @Controller에 요청 보내기 위한 기본 설정 진행 (HandlerMapping, HandlerAdapter, ViewResolver 등 빈 등록 -->
	<annotation-driven />

	<!-- 리소스 설정 : /resources/로 시작하는 모든 요청은 /resources/ 디렉토리에서 처리한다. /upload/로 시작하는 모든 요청은 /upload/ 디렉토리에서 처리한다. -->
	<resources mapping="/resources/**" location="/resources/" />
	<resources mapping="/upload/**" location="/upload/" />

	<!-- 리졸브 설정 : 모든 뷰 이름에 대해 /WEB-INF/views/ 디렉토리에서 .jsp 파일을 찾는다. -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<!-- Component Scan 설정 : com.ssafy.ws.controller 패키지에서 특정 어노테이션이 붙은 클래스를 찾아서 빈으로 등록한다. (차후에는 com.ssafy.ws.interceptor 패키지에서도 빈으로 등록할 것) -->
	<context:component-scan
		base-package="com.ssafy.ws.controller" /> 
```

### root-context.xml

- DB관련
    - 다오
    - dataSource
    - sqlSessionFactory
- service

```java
	<context:component-scan
		base-package="com.ssafy.ws.service"></context:component-scan>

	<!-- 데이터베이스 연결을 위한 dataSource를 등록한다. -->
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<!-- 데이터베이스 연결을 위한 드라이버 클래스명, url, 사용자 이름, 비밀번호를 설정한다. -->
		<property name="driverClassName" value="com.mysql.cj.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC"></property>
		<property name="username" value="ssafy"></property>
		<property name="password" value="ssafy"></property>
	</bean>

	<!--  MyBatis를 사용하기 위한 sqlSessionFactory를 등록한다. -->
	<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<!--데이터베이스 연결을 위한 dataSource를 설정한다. -->
		<property name="dataSource" ref="dataSource" />
		<!-- mapper xml 파일의 경로를 지정합니다. (ant 형식) -->
		<property name="mapperLocations" value="classpath*:mappers/boardMapper.xml" />
		<!-- mapper에서 사용할 DTO들의 기본 패키지를 등록한다. -->
		<property name="typeAliasesPackage" value="com.ssafy.ws.model.dto"></property>
	</bean>

<!-- 다오 등록--> 
	<mybatis-spring:scan base-package="com.ssafy.ws.model.dao"/>
```

## SpringBoot방식

### applictaion.properties

```java
#dataSource
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC
spring.datasource.username=ssafy
spring.datasource.password=ssafy

#MyBatis 
mybatis.mapper-locations=classpath:mappers/*.xml
mybatis.type-aliases-package=com.ssafy.board.model.dto
mybatis.configuration.map-underscore-to-camel-case=true
```