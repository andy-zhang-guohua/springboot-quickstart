# 项目简介

基于 ZYMBOL v2 的增强DSL语言，增强点 :
- 布尔类型支持 : true , false
- 数值比较 : <, <=, ==, >=, >, !=, <>
- 数值取负数 : - 一元操作符
- 布尔逻辑操作 
    - 布尔一元操作符 : NOT
    - 布尔二元操作符 : AND, OR 

# 参考资料

- [antl4r官方地址](https://www.antlr.org)
- [Antlr4 IDEA 计算器入门小例](https://www.jianshu.com/p/628f2a4eb815)
    - 准备语法文件 `AntlrTest.g4`
    - 编译语法文件 `AntlrTest.g4`
        - 在IDEA中文件 `AntlrTest.g4`上右键菜单选项 : Generate ANTLR Recognizer
        - 默认会在根目录下生成新目录 gen, 并在其下多出 6 个文件
- [使用Antlr实现简单的DSL](https://www.cnblogs.com/haoxinyue/p/4225006.html)