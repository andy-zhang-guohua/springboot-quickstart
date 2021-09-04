grammar ZYMBOL;

@header{
    package andy.zymbol;
}

///////////// 语法规则 (首字母小写)
program: stmt+;

stmt : 'print' expr SEMICOLON       # Print // 输出表达式的值
| expr SEMICOLON                    # SimplePrint // 同样输出表达式的值
| ID '=' expr SEMICOLON             # Assign // 赋值语句 : 变量
| SEMICOLON                         # Blank // 空行带注释
;

expr : expr (MUL|DIV) expr             # MulDiv // 数字乘除表达式(结果是数值)
| expr (ADD|SUB) expr                  # AddSub // 数字加减表达式(结果是数值)
| expr (GT|GE|LT|LE|EQ|NE|NE_2) expr   # NumericalComparator // 数字比较表达式(结果是布尔值)
| expr (AND) expr                      # BooleanAnd // 布尔变量的二元操作表达式AND(结果是布尔值)
| expr (OR) expr                       # BooleanOr // 布尔变量的二元操作表达式OR(结果是布尔值)
| '!'expr                              # BooleanNot // 布尔值取反(结果是布尔值)
| '-'expr                              # NumericNegative // 数值取负数(结果是数值)
| expr (CONCAT) expr                   # StringConcatenation // 拼接字符串(结果是字符串)
| '('expr')'                           # Parenthesis // ()表达式,提升优先级
|ID                                    # Variable // 引用其他变量
| valueNumerical                       # NumericalLiteral // 数字字面值
| valueBoolean                         # BooleanLiteral // 布尔变量字面值
| valueString                          # StringLiteral //  字符串字面值
;


valueNumerical : FLOAT     # FloatLiteral // 直接是一个浮点数字面值
| INT # IntLiteral // 直接是一个整数字面值
;

valueString : STRING     // 直接是一个字符串字面值
;

valueBoolean : 'true'      # BooleanTrueLiteral     // 布尔变量真值字面值
|'false'                   # BooleanFalseLiteral    // 布尔变量假值字面值
;

////////////// 词法规则 (首字母大写)

MUL :   '*'; // (数字)乘法操作符
DIV :   '/'; // (数字)除法操作符
ADD :   '+'; // (数字)加法操作符
SUB :   '-'; // (数字)减法操作符

//// 数字之间进行比较的二元操作符
GT         : '>' ; // 大于
GE         : '>=' ; // 大于等于
LT         : '<' ; // 小于
LE         : '<=' ; // 小于等于
EQ         : '==' ; // 等于
NE         : '!=' ; // 不等于
NE_2        : '<>' ; // 不等于

//// 布尔变量的二元操作符
AND        : '&&' ;
OR         : '||' ;

CONCAT : '..'; // (字符串)连接

ID  :   ALPHA(ALPHA|DIGIT)*; // 变量名称

INT :   [1-9][0-9]*  // 非0整数字面值
        | '0'  // 0
        ;

FLOAT   :   DIGIT+ '.' DIGIT*  // 浮点数定义 // 1.52、3.14159等
            | '.' DIGIT+ // .21 (表示0.21)
            ;

STRING: '"' (ESC|.)*? '"' ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ; // 单行注释 : 匹配双斜杠//开头的注释

COMMENT : '/*' .*? '*/' -> skip ; // 多行注释 : 匹配 /* 和 */ 包裹的注释

SEMICOLON   :   ';' ; // 分号，用来作为一个语句的结束

WS      :   [ \t\r\n]+ -> skip;

fragment ALPHA  : [a-zA-Z_]; // 匹配单个英文字母或者_
fragment DIGIT  : [0-9]; // 匹配单个数字
fragment ESC : '\\"' | '\\\\' ; // 转义符号 \" 和 \\