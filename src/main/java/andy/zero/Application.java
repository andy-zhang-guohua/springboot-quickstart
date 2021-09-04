package andy.zero;


import andy.zymbol.ZYMBOLInterpreter;

/**
 * 使用 ZYMBOL v3 的例子
 */
public class Application {
    public static void main(String[] args) {
        ZYMBOLInterpreter interpreter = new ZYMBOLInterpreter();

        String script = "" +
                "boolT = true;\n" +
                "boolF = false;\n" +
                "bool1 = !false;\n" +
                "bool2 = false && true;\n" +
                "bool3 = true || true && boolF;\n" +
                "bool4 = boolT || boolF;\n" +
                "boolA = 1 < 3;\n" +
                "boolB = 1 <= 3;\n" +
                "boolC = 1 == 3;\n" +
                "boolD = 1 >= 3;\n" +
                "boolE = (1 > 0.9);\n" +
                "print boolT;\n" +
                "print boolF;\n" +
                "print bool1;\n" +
                "print bool2;\n" +
                "print bool3;\n" +
                "print bool4;\n" +
                "print boolA;\n" +
                "print boolB;\n" +
                "print boolC;\n" +
                "print boolD;\n" +
                "print boolE;\n" +
                "print boolF;\n" +
                "";

        String script1 = "" +
                "varNumeric = ((21+9) -(-(-10))) * (32 + -2) * 0.05;\n" +
                "varBool = ((1+19) - 0) == (19);\n" +
                "varString= \"abc\"..\"123\";\n" +
                "print varNumeric;\n" +
                "print varBool;\n" +
                "print varString;\n" +
                "";

        System.out.print("脚本为 : \n" + script + "\n<==脚本结束\n");

        interpreter.run(script);
    }
}
