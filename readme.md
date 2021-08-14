# 项目简介

基于 CALC v2 的增强DSL语言，增强点 :
- 数据可以是字符串类型
- 支持对字符串进行加法操作,字符串加法操作符:+
- 支持字符串乘法操作,字符串可以乘以一个整数n，表示将n个这样的字符串进行拼接
- 支持字符串和其他数据类型(整数，浮点数)的加法，这种情况下将其它类型的数据转换成字符串形式跟字符串拼接
- 支持注释


# 参考资料

- [antl4r官方地址](https://www.antlr.org)
- [Antlr4 IDEA 计算器入门小例](https://www.jianshu.com/p/628f2a4eb815)
    - 准备语法文件 `AntlrTest.g4`
    - 编译语法文件 `AntlrTest.g4`
        - 在IDEA中文件 `AntlrTest.g4`上右键菜单选项 : Generate ANTLR Recognizer
        - 默认会在根目录下生成新目录 gen, 并在其下多出 6 个文件
- [使用Antlr实现简单的DSL](https://www.cnblogs.com/haoxinyue/p/4225006.html)