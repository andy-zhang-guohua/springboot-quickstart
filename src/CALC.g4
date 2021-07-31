grammar CALC;

///////////// 语法规则 (首字母小写)
program: stat+;

stat: 'print' expr NEWLINE          # print // 输出表达式的值
|ID '=' expr NEWLINE                # assign // 赋值语句
|NEWLINE                            # blank // 空行
;

expr:expr (MULTIPLY|DIVIDE) expr    # MulDiv // 乘除表达式
|expr (PLUS|MINUS) expr             # AddSub // 加减表达式
|'('expr')'                         # Parenthesis // ()表达式,提升优先级
|value                              # IdInt // 字面值或者变量方式表达式
;

value:INT     // 直接是一个整数字面值
|ID         // 引用另外一个变量
;

////////////// 词法规则 (首字母大写)

MULTIPLY:'*';  // 乘法操作符
DIVIDE:'/'; // 除法操作符
PLUS:'+'; // 加法操作符
MINUS:'-'; // 减法操作符
ID:[a-z]+; // 变量名称
INT:[1-9]+; // 整数字面值
NEWLINE:'\r'?'\n'; // 换行符号
WS:[ \t\r\n] -> skip;