package andy.zero;


import andy.zymbol.ZYMBOLInterpreter;

/**
 * 使用 CALC v2 的例子
 */
public class Application {
    public static void main(String[] args) {
        ZYMBOLInterpreter interpreter = new ZYMBOLInterpreter();

        String script = ";\n" + // 语句1 : 空语句,为了下面各脚本行对齐添加的一个空语句行,没有什么其他意义
                "a = -1.15   ;\n" + // 语句2 : 定义变量 a ,浮点数, 值为 -1.15
                "b = 2 ;\n" + // 语句3 : 定义变量 b, 整数, 值为 2
                "c = -4;\n" + // 语句4 : 定义变量 c, 整数, 值为 -4
                "d = ( a + b + 1 ) * c ;\n" + // 语句5: 定义变量 d, 为一个表达式，最终结果应该是 -7.4
                "e = d ;\n" + // 语句6 : 定义变量 e, 值复制自 d, 应该为 -7.4
                "print e;\n" + // 语句7 : 输出变量 e 的值, 应该为 -7.4
                "print f;\n" + // 语句8 : 输出变量 f 的值, 应该为 0, 因为 f 是一个未被定义的变量
                "print .4 + 5.1 + 20.8 / 2 ;\n" + // 语句9 : 输出一个直接表达式的值, 应该为 15.9
                "";// 语句10 : 空语句

        System.out.print("脚本为 : \n" + script);

        interpreter.run(script);
    }
}
