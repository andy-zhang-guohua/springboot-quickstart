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

```yaml
server.servlet.encoding.charset=UTF-8
server.servlet.encoding.force=true
```     

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
  




