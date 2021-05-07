# 基于 Hasor Dataway + DataSQL 功能实验

## 项目特点
   - Spring Boot
   - Spring Web 
        - Undertow
   - Spring Web MVC
   - Hasor Dataway
   - Druid 
   - MySQL

## 功能界面地址
   - [Druid 管理地址 : http://localhost:8080/druid/sql.html](http://localhost:8080/druid/sql.html)
    - admin/druid (可以通过配置文件配置)
   - [Dataway 访问地址 : http://127.0.0.1:8080/interface-ui/](http://127.0.0.1:8080/interface-ui/)
    - admin/admin

## Dataway 使用

### 基于SQL进行查询
- SQL 语句
```sql
-- 注意这里 \#{path_pattern} 是一个参数
select * from interface_info where api_path = #{path_pattern} 
```
> 注意上面注释的写法，以及注释中对#的转义处理

- 对应参数
```json
{
  "path_pattern": "/api/echo"
}
```

### 基于DataQL进行查询
- DataQL 脚本
```javascript
// 定义一个sql查询函数,有一个参数表示 api_path 的值
var query = @@sql(arg)<%
    select * from interface_info where api_path = #{arg}
%>

// 执行所定义的查询函数，实参使用参数中的 path_pattern
return query(${path_pattern})
```

- 对应参数
```json
{
  "path_pattern": "/api/echo"
}
```

## 学习总结
   - Dataway API 机制是如何工作的 
     - 基于 DataQL/SQL 定义查询脚本，可以带有一定的逻辑，指定一个API路径，定义为一个API保存
        - Dataway 提供 API 管理界面
     - 指定 API 路径 + 查询参数 到后端，后端执行相应的查询脚本返回数据给前端,JSON 格式        
   - 中文乱码处理
   - Dataway 不用于数据库表创建，而是用于聚合查询        
      - 可以结合其他得数据库表创建和修改工具工作
   - Dataway 的优势
      - 前端定义数据查询 API，可以带有一定的逻辑
      - 不再依赖后端开发基本的数据CRUD API   
    - 如何让Hasor共享使用 Spring Boot 的配置
        - 启用 : `@EnableHasor(useProperties = true)`
        - 使用 : `appContext.getEnvironment().getSettings().getString("hasor.dataway.authorization.username")`

```yaml
server.servlet.encoding.charset=UTF-8
server.servlet.encoding.force=true
```     

## 原理分析

### 管理界面的登录逻辑

- 管理界面的登录逻辑主要被 `AdminUiAuthorization.doInvoke` 控制
```java
    // 实现在类 AdminUiAuthorization
    @Override
    public Object doInvoke(Invoker invoker, InvokerChain chain) throws Throwable {
        if (!invoker.getRequestPath().startsWith(this.adminBaseUri) || !this.enableAdminAuthorization) {
            // 不需要认证，或者当前访问路径不被 this.adminBaseUri 覆盖的情况
            return chain.doNext(invoker);
        }

        // check ok.
        if (checkDwAuthData(invoker)) {
            // 检查 cookie 中的登录数据，如果已经登录，继续其他的 Filter
            // cookie 中的登录数据 : DW_AUTH_DATA
            return chain.doNext(invoker);
        }

        // process login action
        // 经过前面的检查，发现当前访问尚未登录
        if (invoker.getRequestPath().equalsIgnoreCase(this.loginActionUri)) {
            // 当前访问的是登录处理逻辑，则执行登录逻辑，然后跳转
            if (doLogin(invoker)) {
                String contextPath = DatawayUtils.getDwContextPath(invoker, null);
                String redirect = fixUrl(contextPath + "/" + this.adminBaseUri);
                invoker.getHttpResponse().sendRedirect(redirect);
                return null;
            }
        }

        // 如果当前访问的页面未登录，并且不是登录处理页面，一律返回登录页面
        // response login page.
        return responseLoginPage(invoker);
    }

```

- `AdminUiAuthorization`被`DatawayModule`模块在模块加载`loadModule`时配置
- [`DatawayModule`被加载的时机](https://www.hasor.net/doc/pages/viewpage.action?pageId=1573158)

## 参考资料
  - [绝了！这款工具让SpringBoot不再需要Controller、Service、DAO、Mapper！](https://mp.weixin.qq.com/s/R6iFojDlch_Vq8ZIRTHzFQ)  
    - [Dataway接口配置服务](https://www.hasor.net/doc/pages/viewpage.action?pageId=7241795)
    - [a. Spring Boot整合](https://www.hasor.net/doc/pages/viewpage.action?pageId=1573294)
  - [DataQL 聚合查询引擎](https://www.hasor.net/doc/pages/viewpage.action?pageId=1573208)
    - [b. 执行 SQL](https://www.hasor.net/doc/pages/viewpage.action?pageId=1573258)
        - 可以执行 insert, delete, update, select
        - 单条执行 : `@@sql()`
        - 批量执行 : `@@sql[]()`
        - 分页查询
        - 结果列名拼写转换    
  - [生命周期](https://www.hasor.net/doc/pages/viewpage.action?pageId=1573158)  




