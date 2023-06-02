# Spring

## 介绍

### Spring框架是什么
Spring是构建 Java 应用程序的 轻量级框架 

Spring 支持 IoC和 AOP、可以很方便地对数据库进行访问、 可以很方便地集成第三方组件、对单元测试支持比较好、支持 RESTful Java 应用程序的开发。

### Spring模块
● Spring Core： 基础,可以说 Spring 其他所有的功能都需要依赖于该类库。主要提供 IoC 依赖注入功能。  
● Spring Aspects ： 该模块为与 AspectJ 的集成提供支持。  
● Spring AOP ：提供了面向切面的编程实现。  
● Spring JDBC : Java 数据库连接。  
● Spring JMS ：Java 消息服务。  
● Spring ORM : 用于支持 Hibernate 等 ORM 工具。  
● Spring Web : 为创建 Web 应用程序提供支持。  
● Spring Test : 提供了对 JUnit 和 TestNG 测试的支持。  

## Spring IoC
IoC（Inversion of control）控制反转，就是将原本在程序中手动创建对象的控制权，交由 Spring 框架来管理。

将对象之间的相互依赖关系交给 IoC 容器来管理，并由 IoC 容器完成对象的注入。这样可以很大程度上简化应用的开发，把应用从复杂的依赖关系中解放出来。
IoC 容器就像是一个工厂一样，当我们需要创建一个对象的时候，只需要配置好配置文件/注解即可，完全不用考虑对象是如何被创建出来的。

### Spring Bean
Bean 代指的就是那些被 IoC 容器所管理的对象。配置元数据可以是XML文件、注解或者 Java 配置类。

### 将一个类声明为 Bean 的注解有哪些?
- @Component ：通用的注解，可标注任意类为 Spring 组件。如果一个 Bean 不知道属于哪个层，可以使用@Component 注解标注。
- @Repository : 对应持久层即 Dao 层，主要用于数据库相关操作。
- @Service : 对应服务层，主要涉及一些复杂的逻辑，需要用到 Dao 层。
- @Controller : 对应 Spring MVC 控制层，主要用于接受用户请求并调用 Service 层返回数据给前端页面。

### @Component 和 @Bean 的区别？
- @Component 注解作用于类，而@Bean注解作用于方法。
- @Component通常是通过类路径扫描来自动侦测以及自动装配到 Spring 容器中（我们可以使用 @ComponentScan 注解定义要扫描的路径从中找出标识了
需要装配的类自动装配到 Spring 的 bean 容器中）。@Bean 注解通常是我们在标有该注解的方法中定义产生这个 bean,@Bean告诉了 Spring 这是某个类的实例，
当我需要用它的时候还给我。
- @Bean 注解比 @Component 注解的自定义性更强，而且很多地方我们只能通过 @Bean 注解来注册 bean。比如当我们引用第三方库中的类需要
装配到Spring容器时，则只能通过 @Bean来实现。

### 注入 Bean 的注解有哪些？
Spring 内置的 @Autowired 以及 JDK 内置的 @Resource 和 @Inject 都可以用于注入 Bean。

### @Autowired 和 @Resource 的区别是什么？
Autowired 属于 Spring 内置的注解，默认的注入方式为byType（根据类型进行匹配），也就是说会优先根据接口类型去匹配并注入 Bean （接口的实现类）。

当一个接口存在多个实现类的话，byType这种方式就无法正确注入对象了，因为这个时候 Spring 会同时找到多个满足条件的选择，
默认情况下它自己不知道选择哪一个。这种情况下，注入方式会变为 byName（根据名称进行匹配），这个名称通常就是类名（首字母小写）
建议通过 @Qualifier 注解来显式指定名称而不是依赖变量的名称。

@Resource 有两个比较重要且日常开发常用的属性：name（名称）、type（类型）。
如果仅指定 name 属性则注入方式为byName，如果仅指定type属性则注入方式为byType，如果同时指定name 和type属性（不建议这么做）则注入方式为byType+byName。

总结：  
- @Autowired 是 Spring 提供的注解，@Resource 是 JDK 提供的注解。
- Autowired 默认的注入方式为byType（根据类型进行匹配），@Resource默认注入方式为 byName（根据名称进行匹配）。
- 当一个接口存在多个实现类的情况下，@Autowired 和@Resource都需要通过名称才能正确匹配到对应的 Bean。Autowired 可以通过 @Qualifier 
注解来显式指定名称，@Resource可以通过 name 属性来显式指定名称

### Bean 的作用域有哪些?
Spring 中 Bean 的作用域通常有下面几种：
- singleton : IoC 容器中只有唯一的 bean 实例。Spring 中的 bean 默认都是单例的，是对单例设计模式的应用。
- prototype : 每次获取都会创建一个新的 bean 实例。也就是说，连续 getBean() 两次，得到的是不同的 Bean 实例。
- request （仅 Web 应用可用）: 每一次 HTTP 请求都会产生一个新的 bean（请求 bean），该 bean 仅在当前 HTTP request 内有效。
- session （仅 Web 应用可用） : 每一次来自新 session 的 HTTP 请求都会产生一个新的 bean（会话 bean），该 bean 仅在当前 HTTP session 内有效。
- application/global-session （仅 Web 应用可用）： 每个 Web 应用在启动时创建一个 Bean（应用 Bean），该 bean 仅在当前应用启动时间内有效。
- websocket （仅 Web 应用可用）：每一次 WebSocket 会话产生一个新的 bean。

### 单例 Bean 的线程安全问题
主要是因为当多个线程操作同一个对象的时候是存在资源竞争的。

有两种解决办法：
- 在 Bean 中尽量避免定义可变的成员变量。
- 在类中定义一个 ThreadLocal 成员变量，将需要的可变成员变量保存在 ThreadLocal 中（推荐的一种方式）。

### Bean 的声明周期

![](https://www.yuque.com/api/filetransfer/images?url=https%3A%2F%2Fimgs.dreamcat.ink%2Fcache%2Fycdhe93eub1636987878626.png&sign=b0536c072f21ad6acf4e74ddc9adf5d176a0c10670cc4da6ac34fa308b556dc4)

● Bean 容器找到配置文件中 Spring Bean 的定义。  
● Bean 容器利用 Java Reflection API 创建一个 Bean 的实例。  
● 如果涉及到一些属性值 利用 set()方法设置一些属性值。  
● 如果 Bean 实现了 BeanNameAware 接口，调用 setBeanName()方法，传入 Bean 的名字。  
● 如果 Bean 实现了 BeanClassLoaderAware 接口，调用 setBeanClassLoader()方法，传入 ClassLoader对象的实例。  
● 与上面的类似，如果实现了其他 *.Aware接口，就调用相应的方法。  
● 如果有和加载这个 Bean 的 Spring 容器相关的 BeanPostProcessor 对象，执行postProcessBeforeInitialization() 方法  
● 如果 Bean 实现了InitializingBean接口，执行afterPropertiesSet()方法。  
● 如果 Bean 在配置文件中的定义包含 init-method 属性，执行指定的方法。  
● 如果有和加载这个 Bean 的 Spring 容器相关的 BeanPostProcessor 对象，执行postProcessAfterInitialization() 方法  
● 当要销毁 Bean 的时候，如果 Bean 实现了 DisposableBean 接口，执行 destroy() 方法。  
● 当要销毁 Bean 的时候，如果 Bean 在配置文件中的定义包含 destroy-method 属性，执行指定的方法。

## AOP
AOP(Aspect-Oriented Programming:面向切面编程)能够将那些与业务无关，却为业务模块所共同调用的逻辑或责任（例如事务处理、日志管理、权限控制等）
封装起来，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可拓展性和可维护性。

Spring AOP 就是基于动态代理的，如果要代理的对象，实现了某个接口，那么 Spring AOP 会使用 JDK Proxy，去创建代理对象，
而对于没有实现接口的对象，就无法使用 JDK Proxy 去进行代理了，这时候 Spring AOP 会使用 Cglib 生成一个被代理对象的子类来作为代理

使用 AOP 之后我们可以把一些通用功能抽象出来，在需要用到的地方直接使用即可，这样大大简化了代码量。我们需要增加新功能时也方便，
这样也提高了系统扩展性。日志功能、事务管理等等场景都用到了 AOP 。

### Spring AOP 和 AspectJ AOP 有什么区别
Spring AOP 属于运行时增强，而 AspectJ 是编译时增强。 Spring AOP 基于代理(Proxying)，而 AspectJ 基于字节码操作(Bytecode Manipulation)
Spring AOP 已经集成了 AspectJ ，AspectJ 应该算的上是 Java 生态系统中最完整的 AOP 框架了。AspectJ 相比于 Spring AOP 功能更加强大， 但是 Spring AOP 相对来说更简单，
如果我们的切面比较少，那么两者性能差异不大。但是，当切面太多的话，最好选择 AspectJ ，它比 Spring AOP 快很多。

## SpringMVC
MVC 是一种设计模式,Spring MVC 是一款很优秀的 MVC 框架。Spring MVC 可以帮助我们进行更简洁的 Web 层的开发，并且它天生与 Spring 框架集成。
Spring MVC 下我们一般把后端项目分为 Service 层（处理业务）、Dao 层（数据库操作）、Entity 层（实体类）、Controller 层(控制层，返回数据给前台页面)。

### 工作原理
![](https://www.yuque.com/api/filetransfer/images?url=http%3A%2F%2Fmy-blog-to-use.oss-cn-beijing.aliyuncs.com%2F18-10-11%2F49790288.jpg&sign=cfa1eadf1140ff9499f46dc00034b1143f08c3e6c507f66d0ec7931086d5d859)

流程说明（重要）：    
1. 客户端（浏览器）发送请求，直接请求到 DispatcherServlet。  
2. DispatcherServlet 根据请求信息调用 HandlerMapping，解析请求对应的 Handler。  
3. 解析到对应的 Handler（也就是我们平常说的 Controller 控制器）后，开始由 HandlerAdapter 适配器处理。  
4. HandlerAdapter 会根据 Handler来调用真正的处理器开处理请求，并处理相应的业务逻辑。  
5. 处理器处理完业务后，会返回一个 ModelAndView 对象，Model 是返回的数据对象，View 是个逻辑上的 View。  
6. ViewResolver 会根据逻辑 View 查找实际的 View。  
7. DispaterServlet 把返回的 Model 传给 View（视图渲染）。  
8. 把 View 返回给请求者（浏览器）  


## Spring 都用到了哪些设计模式

● 工厂设计模式 : Spring 使用工厂模式通过 BeanFactory、ApplicationContext 创建 bean 对象。  
● 代理设计模式 : Spring AOP 功能的实现。  
● 单例设计模式 : Spring 中的 Bean 默认都是单例的。  
● 模板方法模式 : Spring 中 jdbcTemplate、hibernateTemplate 等以 Template 结尾的对数据库操作的类，它们就使用到了模板模式。  
● 包装器设计模式 : 我们的项目需要连接多个数据库，而且不同的客户在每次访问中根据需要会去访问不同的数据库。这种模式让我们可以根据客户的需求
能够动态切换不同的数据源。
● 观察者模式: Spring 事件驱动模型就是观察者模式很经典的一个应用。  
● 适配器模式 :Spring AOP 的增强或通知(Advice)使用到了适配器模式、spring MVC 中也是用到了适配器模式适配Controller。  
● ......  
 
## Spring 事务

### 管理事物有几种
● 编程式事务，在代码中硬编码。  
● 声明式事务，在配置文件中配置  

### 声明式事务又分为两种：
1. 基于 XML 的声明式事务  
2. 基于注解的声明式事务  

### 隔离级别
隔离级别就跟 mysql 几乎差不多

## Springboot 启动流程