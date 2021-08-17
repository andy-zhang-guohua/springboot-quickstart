grammar ZYMBOL;

@header{
    package andy.zymbol;
}

///////////// 语法规则 (首字母小写)
program: stmt+;

stmt : 'print' expr SEMICOLON       # Print // 输出表达式的值
| ID '=' expr SEMICOLON             # Assign // 赋值语句
| SEMICOLON                         # Blank // 空行带注释
;

expr : exprNumerical                # ExpressionNumerical // 数字表达式
| exprString                        # ExpressionString  // 字符串表达式
;

exprNumerical : exprNumerical (MUL|DIV) exprNumerical   # MulDiv // 乘除表达式
| exprNumerical (ADD|SUB) exprNumerical                 # AddSub // 加减表达式
| '('exprNumerical')'                                   # Parenthesis // ()表达式,提升优先级
| ID                                                    # NumericalVariable // 引用其他变量
| valueNumerical                                        # NumericalLiteral // 数字字面值
;

exprString : exprString (ADD) exprString    # StringConcatenation // 拼接字符串
| valueString                               # StringLiteral //  字符串字面值
| ID                                        # StringVariable // 引用其他变量
;

valueNumerical : FLOAT     // 直接是一个浮点数字面值
| INT // 直接是一个整数字面值
;

valueString : STRING     // 直接是一个字符串字面值
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