grammar CALC;

@header{
    package andy.calc;
}

///////////// 语法规则 (首字母小写)
program: stmt+;

stmt: 'print' expr NEWLINE          # print // 输出表达式的值
|ID '=' expr NEWLINE                # assign // 赋值语句
|NEWLINE                            # blank // 空行
;

expr:expr (MUL|DIV) expr    # MulDiv // 乘除表达式
|expr (ADD|SUB) expr        # AddSub // 加减表达式
|'('expr')'                 # Parenthesis // ()表达式,提升优先级
|ID                         # Variable    // 表达式指向另外一个变量
|value                      # IntLiteral // 字面值或者变量方式表达式
;

value:INT     // 直接是一个整数字面值
;

////////////// 词法规则 (首字母大写)

MUL : '*';  // 乘法操作符
DIV : '/';  // 除法操作符
ADD : '+';  // 加法操作符
SUB : '-';  // 减法操作符
ID  : [a-z]+; // 变量名称
INT : [1-9]+; // 整数字面值
NEWLINE : '\r'?'\n'; // 换行符号
WS : [ \t\r\n] -> skip; // 忽略空白，跳格和换行符