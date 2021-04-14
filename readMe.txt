Crm-智能办公管理系统（客户关系管理系统）
SpringMVC执行流程:
1.用户发送请求至前端控制器DispatcherServlet
2.DispatcherServlet收到请求调用处理器映射器HandlerMapping。
3.处理器映射器根据请求url找到具体的处理器，生成处理器执行链HandlerExecutionChain(包括处理器对象和处理器拦截器)一并返回给DispatcherServlet。
4.DispatcherServlet根据处理器Handler获取处理器适配器HandlerAdapter执行HandlerAdapter处理一系列的操作，如：参数封装，数据格式转换，数据验证等操作
5.执行处理器Handler(Controller，也叫页面控制器)。
6.Handler执行完成返回ModelAndView
7.HandlerAdapter将Handler执行结果ModelAndView返回到DispatcherServlet
8.DispatcherServlet将ModelAndView传给ViewReslover视图解析器
9.ViewReslover解析后返回具体View
10.DispatcherServlet对View进行渲染视图（即将模型数据model填充至视图中）。
11.DispatcherServlet响应用户。

名词解释:
1.DispatcherServlet：前端控制器。用户请求到达前端控制器，它就相当于mvc模式中的c，dispatcherServlet是整个流程控制的中心，由它调用其它组件处理用户的请求，dispatcherServlet的存在降低了组件之间的耦合性,系统扩展性提高。由框架实现
2.HandlerMapping：处理器映射器。HandlerMapping负责根据用户请求的url找到Handler即处理器，springmvc提供了不同的映射器实现不同的映射方式，根据一定的规则去查找,例如：xml配置方式，实现接口方式，注解方式等。由框架实现
3.Handler：处理器。Handler 是继DispatcherServlet前端控制器的后端控制器，在DispatcherServlet的控制下Handler对具体的用户请求进行处理。由于Handler涉及到具体的用户业务请求，所以一般情况需要程序员根据业务需求开发Handler。
4.HandlAdapter：处理器适配器。通过HandlerAdapter对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理器进行执行。由框架实现。
5.ModelAndView是springmvc的封装对象，将model和view封装在一起。
6.ViewResolver：视图解析器。ViewResolver负责将处理结果生成View视图，ViewResolver首先根据逻辑视图名解析成物理视图名即具体的页面地址，再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户。
7View:是springmvc的封装对象，是一个接口, springmvc框架提供了很多的View视图类型，包括：jspview，pdfview,jstlView、freemarkerView、pdfView等。一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户，需要由程序员根据业务需求开发具体的页面。

Servlet生命周期： 1.实例化（构造方法创建）
                 2.初始化（执行init(ServletConfig servletConfig)方法）
                   interface ServletConfig{
                                   String getServletName();
                                   ServletContext getServletContext();
                                   String getInitParameter(String var1);
                                   Enumeration<String> getInitParameterNames();
                                  // Enumeration接口中定义了一些方法,通过这些方法可以枚举(一次获得一个)对象集合中的元素
                    }
                 3.服务（执行service（ServletRequest servletRequest, ServletResponse servletResponse）方法）
                 4.摧毁（执行destory(）方法）
                 //当停止tomcat时也就销毁的servlet。
首页index.ftl:
进入主界面：访问IndexController
进行登录Login,以及记住密码：
登录： index.ftl——————>index.js——————>form表单提交——————>UserController
       ——————>参数校验——————>login——————>index.js——————>将用户信息存储在Cookie中
       ——————>记住功能(创建Cookie/清除Cookie)——————>IndexController中获得Cookie
       ——————>转发到Main.ftl中,并且展示当前用户的真实姓名

未登录拦截：NoLoginInterceptor未登录拦截——————>继承了HandlertercepterAdapter
           ——————>通过获取Cookie解析用户Id看是否登录——————>通过MvcConfig装配NoLoginInterceptor
           ——————>拦截非法访问请求,不包括静态资源以及index.ftl  ——————>未登录抛出自定义异常NoLoginException

全局异常处理：GlobalExceptionResolver——————>覆盖为登录异常,参数异常并且做出相应的处理
            ——————>实现了HandlerExceptionResolver——————>通过HandlerMethod获得对应控制器方法判
            断是否是JSON错误还是视图找不到——————>配置全局异常,不用在ResultInfo中声明异常消息







