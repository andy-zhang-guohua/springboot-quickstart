# 项目简介

使用 antlr4 构造一个简单的计算器文法 CALC ，能够解释执行(而不是编译执行)。该计算器文法支持以下能力 :

- 数字的加减乘除
    - 乘除优先
    - ()可以提升优先级
    - 数字可以是 : 整数或者浮点数(非科学计数法)
- 变量赋值
    - 变量名称能使用英文字母和数字
    - 首字母必须是英文
    - 大小写区分
- 每行一个语句
- 输出表达式的值到控制台


# 参考资料

- [antl4r官方地址](https://www.antlr.org)
- [Antlr4 IDEA 计算器入门小例](https://www.jianshu.com/p/628f2a4eb815)
    - 准备语法文件 `AntlrTest.g4`
    - 编译语法文件 `AntlrTest.g4`
        - 在IDEA中文件 `AntlrTest.g4`上右键菜单选项 : Generate ANTLR Recognizer
        - 默认会在根目录下生成新目录 gen, 并在其下多出 6 个文件
- [使用Antlr实现简单的DSL](https://www.cnblogs.com/haoxinyue/p/4225006.html)