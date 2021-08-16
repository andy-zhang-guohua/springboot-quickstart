grammar ZYMBOL;

@header{
    package andy.zymbol;
}

///////////// 语法规则 (首字母小写)
program: stmt+;

stmt : 'print' expr SEMICOLON       # print // 输出表达式的值
| ID '=' expr SEMICOLON             # assign // 赋值语句
| SEMICOLON                         # blank // 空行带注释
;

expr : expr (MUL|DIV) expr   # MulDiv // 乘除表达式
| expr (ADD|SUB) expr        # AddSub // 加减表达式
| '('expr')'                 # Parenthesis // ()表达式,提升优先级
| ID                         # Variable // 引用其他变量
| value                      # Literal // 字面值或者表达式
;

value : FLOAT     // 直接是一个浮点数字面值
| INT // 直接是一个整数字面值
;

////////////// 词法规则 (首字母大写)

MUL :   '*'; // 乘法操作符
DIV :   '/'; // 除法操作符
ADD :   '+'; // 加法操作符
SUB :   '-'; // 减法操作符

ID  :   ALPHA(ALPHA|DIGIT)*; // 变量名称

INT :   '-'?[1-9][0-9]*  // 非0整数字面值
        | '0'  // 0
        ;

FLOAT   :   '-'? DIGIT+ '.' DIGIT*  // 浮点数定义 // 1.52、3.14159等
            | '-'? '.' DIGIT+ // .21 (表示0.21)
            ;

STRING: '"' (ESC|.)*? '"' ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ; // 单行注释 : 匹配双斜杠//开头的注释

COMMENT : '/*' .*? '*/' -> skip ; // 多行注释 : 匹配 /* 和 */ 包裹的注释

SEMICOLON   :   ';' ; // 分号，用来作为一个语句的结束

WS      :   [ \t\r\n]+ -> skip;

fragment ALPHA  : [a-zA-Z_]; // 匹配单个英文字母或者_
fragment DIGIT  : [0-9]; // 匹配单个数字
fragment ESC : '\\"' | '\\\\' ; // 转义符号 \" 和 \\