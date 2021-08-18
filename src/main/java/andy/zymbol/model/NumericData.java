package andy.zymbol.model;

import java.math.BigDecimal;

/**
 * 数值类型数据
 */
public class NumericData extends TypedData {
    /**
     * 定义常量，用于表示 0
     */
    public static NumericData ZERO = zero();

    /**
     * 内部工具方法，用于构造常量0
     *
     * @return
     */
    private static NumericData zero() {
        NumericData zero = new NumericData();

        zero.setType(DataType.INTEGER);
        zero.setValue(0L);

        return zero;
    }

    /**
     * 将 Java BigDecimal 类型的值包装成我们的一个数据对象，类型统一使用 FLOAT
     *
     * @param value
     * @return
     */
    public static NumericData toFloat(BigDecimal value) {
        if (value == null) return ZERO;

        NumericData data = new NumericData();
        data.setType(DataType.FLOAT);
        data.setValue(value);
        return data;
    }

    /**
     * 将 Java Long 类型的值包装成我们的一个数据对象，类型统一使用 INTEGER
     *
     * @param value
     * @return
     */
    public static NumericData toInteger(Long value) {
        if (value == null) return ZERO;

        NumericData data = new NumericData();
        data.setType(DataType.INTEGER);
        data.setValue(value);
        return data;
    }

    /**
     * 乘法
     *
     * @param another
     * @return
     */
    public NumericData multiply(NumericData another) {
        if (another == null) return NumericData.zero();

        if (getType() != another.getType() // 两个操作数类型不一样的情况(至少有一个是 FLOAT 类型)
                || (getType() == DataType.FLOAT)) // 两个操作数类型都是 FLOAT 的情况
        {
            // 如果有任何一个操作数类型为 FLOAT, 则将另外一个操作数也按照 FLOAT 来处理，
            // 内部使用 Java 的 BigDecimal 类型的乘法执行乘法操作,
            // 这种情况下，结果的数据类型也设置为 FLOAT
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.multiply(b); // 两数相乘得到结果

            NumericData result = NumericData.toFloat(resultValue); // 包装
            return result;
        } else { // // 两个操作数类型都是 INTEGER 的情况，结果也设置为 INTEGER
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            NumericData result = NumericData.toInteger(a * b);
            return result;
        }
    }

    /**
     * 除法
     *
     * @param another
     * @return
     */
    public NumericData divide(NumericData another) {
        if (another == null) return NumericData.zero();

        if (getType() != another.getType() // 两个操作数类型不一样的情况(至少有一个是 FLOAT 类型)
                || (getType() == DataType.FLOAT))  // 两个操作数类型都是 FLOAT 的情况
        {
            // 如果有任何一个操作数类型为 FLOAT, 则将另外一个操作数也按照 FLOAT 来处理，
            // 内部使用 Java 的 BigDecimal 类型的除法执行乘法操作,
            // 这种情况下，结果的数据类型也设置为 FLOAT
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.divide(b); // 两数相除得到结果

            NumericData result = NumericData.toFloat(resultValue); // 包装
            return result;
        } else { // 两个操作数类型都是 INTEGER 的情况，结果也设置为 INTEGER
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            NumericData result = NumericData.toInteger(a / b);
            return result;
        }
    }

    /**
     * 加法
     *
     * @param another
     * @return
     */
    public NumericData add(NumericData another) {
        if (another == null) return NumericData.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.add(b);

            NumericData result = NumericData.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            NumericData result = NumericData.toInteger(a + b);
            return result;
        }
    }

    /**
     * 减法
     *
     * @param another
     * @return
     */
    public NumericData subtract(NumericData another) {
        if (another == null) return NumericData.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.subtract(b);

            NumericData result = NumericData.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            NumericData result = NumericData.toInteger(a - b);
            return result;
        }
    }

    /**
     * 从浮点数字面值分析数字
     *
     * @param numberLiteral
     * @return
     */
    public static NumericData parseIntLiteral(String numberLiteral) {
        if (numberLiteral == null || numberLiteral.trim().isEmpty()) return NumericData.ZERO;

        NumericData result = new NumericData();
        result.setType(DataType.INTEGER);// <=== 类型设置为 整数
        result.setValue(Long.parseLong(numberLiteral));
        return result;
    }

    /**
     * 从浮点数字面值分析数字
     *
     * @param numberLiteral
     * @return
     */
    public static NumericData parseFloatLiteral(String numberLiteral) {
        if (numberLiteral == null || numberLiteral.trim().isEmpty()) {
            NumericData result = new NumericData();
            result.setType(DataType.FLOAT);// <=== 类型设置为 浮点数
            result.setValue(BigDecimal.ZERO);
            return result;
        }


        BigDecimal value = new BigDecimal(numberLiteral);
        NumericData result = new NumericData();
        result.setType(DataType.FLOAT); // <=== 类型设置为 浮点数
        result.setValue(value);
        return result;
    }
}
