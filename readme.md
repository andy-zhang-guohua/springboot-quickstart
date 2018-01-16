此分支在master分支的基础上增加了freemarker模版视图的例子，
此分支的主要目的是为了便于分析Spring MVC 中的各个组件如何工作 :

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
