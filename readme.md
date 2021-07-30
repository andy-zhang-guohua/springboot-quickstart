# 项目介绍

- springboot 非 web 项目
- 用于调查 docxj 有关功能
    - 动态插入新的一页
        - 控制分页符号
    - 动态控制页眉页脚内的页码
    - 动态插入多栏
    - 动态插入表格
    - 动态隐藏表格
    
- 用于调查程序化直接操作 docx 文件内的xml

- 有关文档
    - [Docx Templating With docx4j: Tips and Tricks](https://dzone.com/articles/word-docx-templating-with-docx4j)
    - [docx-stamper](https://github.com/thombergs/docx-stamper)
    - [docx4j-multiple-table-example](https://github.com/iwan41/docx4j-multiple-table-example)
    - [Create complex Word (.docx) documents programatically with docx4j](http://www.smartjava.org/content/create-complex-word-docx-documents-programatically-docx4j/)
    - [Docx 文档和下载地址](https://www.docx4java.org/docx4j/)
    - [An Informal Introduction to DOCX](https://www.toptal.com/xml/an-informal-introduction-to-docx)
    

# 问题跟踪

## 2021-07-30
- 使用 docx4j 8.x+ 版本默认方式生成页眉有问题，相反，使用 docx4j 6.x 生成页眉页脚没有问题。
    -  docx4j 6.x 使用  (Java 8 也可以使用)

    ```xml
        <!-- https://mvnrepository.com/artifact/org.docx4j/docx4j -->
        <dependency>
            <groupId>org.docx4j</groupId>
            <artifactId>docx4j</artifactId>
            <version>6.1.2</version>
        </dependency>
    ```
    -  docx4j 8.x 使用 (面向 Java 8)

    ```xml
        <!-- https://mvnrepository.com/artifact/org.docx4j/docx4j-core -->
        <dependency>
            <groupId>org.docx4j</groupId>
            <artifactId>docx4j-core</artifactId>
            <version>8.2.7</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.docx4j/docx4j-JAXB-ReferenceImpl -->
        <dependency>
            <groupId>org.docx4j</groupId>
            <artifactId>docx4j-JAXB-Internal</artifactId>
            <version>8.2.7</version>
        </dependency>
    ```    