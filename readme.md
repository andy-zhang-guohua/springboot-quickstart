# 项目介绍

- springboot 非 web 项目
- 用于调查使用 jacob 转 docx 到 pdf 文件
- [下载 : jacob-1.20.zip](https://sourceforge.net/projects/jacob-project/files/)
- 解压缩到 D:\programs\jacob-1.20
- mvn install:install-file -Dfile=D:\programs\jacob-1.20\jacob.jar  -DgroupId=com.jacob -DartifactId=jacob  -Dversion=1.20 -Dpackaging=jar
- pom 依赖
```xml
<!-- word转pdf（依赖windows本地的wps） -->
        <dependency>
            <groupId>com.jacob</groupId>
            <artifactId>jacob</artifactId>
            <version>1.20</version>
        </dependency>
```    
- 在jdk/bin目录下引入.dll文件
    - 64位：jacob-1.20-x64.dll       
    - 32位：jacob-1.20-x86.dll