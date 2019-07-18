# 2019-07-18
## 实验在`Spring MVC`中使用`Validator`验证控制器方法的参数
* 实现代码参考控制器 `UserController`/`UserForm`
* 只要引入了包 `spring-boot-starter-web` , 它隐含引入 `hibernate-validator`
* `Spring MVC`使用`Validator`验证控制器方法参数格式的代码在`ModelAttributeMethodProcessor`
* `Spring MVC`使用的`Validator`缺省由`ValidationAutoConfiguration`提供
* `Spring MVC`使用的`Validator`通过`WebMvcAutoConfiguration`的`bean`定义方法`#mvcValidator`引入,
  实际使用的还是`ValidationAutoConfiguration`所提供的
* `WebMvcAutoConfiguration`定义`bean RequestMappingHandlerAdapter`调用`#getConfigurableWebBindingInitializer`
* `#getConfigurableWebBindingInitializer`进而调用`#mvcValidator`
# 2019-03-01
静态资源文件映射配置 :
```java
    /**
     * 静态资源文件映射配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 注意 :
        // 1. addResourceHandler 参数可以有多个
        // 2. addResourceLocations 参数可以是多个，可以混合使用 file: 和 classpath : 资源路径
        // 3. addResourceLocations 参数中资源路径必须使用 / 结尾，如果没有此结尾则访问不到

        // 映射到文件系统中的静态文件(应用运行时，这些文件无业务逻辑，但可能被替换或者修改)
        registry.addResourceHandler("/repo/**").addResourceLocations("file:/tmp/");

        // 映射到jar包内的静态文件(真正的静态文件，应用运行时，这些文件无业务逻辑，也不能被替换或者修改)
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").resourceChain(true);
    }
```

对静态资源配置讲解比较透彻的一篇文章:[深入 Spring 系列之静态资源处理](https://blog.coding.net/blog/spring-static-resource-process)

# 2019-02-28
`WebMvcConfig#addViewControllers` 演示`Spring MVC`快捷控制视图控制器。

# 2019-02-27

## `BeanNameUrlHandlerMapping`如何工作的例子 ?
使用 `WelcomeController` 和 `ControllerBeanConfig` 演示 `BeanNameUrlHandlerMapping`和`SimpleControllerHandlerAdapter`的工作配合。
访问地址 : (`/welcome*`)
    * `http://localhost:8080/welcome`
    * `http://localhost:8080/welcome.html`
    * `http://localhost:8080/welcome.do`

# 2019-02-01

此分支在master分支的基础扩展建立，主要目的是为了便于分析Spring MVC 中的各个组件如何工作 :

Spring boot web 应用中 Request 的处理流程 :
ApplicationFilterChain.internalDoFilter
    => FrameworkServlet.service()
    => HttpServlet.service()
    => FrameworkServlet.doGet()/doPost() // 根据方法决定调用哪个方法
    => FrameworkServlet.processRequest() // 最终都会回到这个方法
    => DispatcherServlet.doService() // 准备各种工作组件然后继续
    => DispatcherServlet.doDispatch()

然后核心方法 SpringMVC DispatcherServlet.doDispatch() :
    1. HandlerExecutionChain : mappedHandler = getHandler(processedRequest);
    2. HandlerAdapter : HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
    3. mappedHandler apply PreHandle
    4. ModelAndView mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
    5. applyDefaultViewName(processedRequest, mv); // 如果mv不为空但是没有指定view，使用request相应的缺省view名称
    6. mappedHandler apply PostHandle
    7. processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException); // 处理结果
