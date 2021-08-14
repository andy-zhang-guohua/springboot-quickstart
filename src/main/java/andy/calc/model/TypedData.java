package andy.calc.model;

import java.math.BigDecimal;

/**
 * 带类型的数据
 */
public class TypedData {
    // 数据类型
    private DataType type;
    // 数据的值
    private Object value;


    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * 定义常量，用于表示 0
     */
    public final static TypedData ZERO = zero();

    /**
     * 内部工具方法，用于构造常量0
     *
     * @return
     */
    private static TypedData zero() {
        TypedData zero = new TypedData();

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
    public static TypedData toFloat(BigDecimal value) {
        if (value == null) return ZERO;

        TypedData data = new TypedData();
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
    public static TypedData toInteger(Long value) {
        if (value == null) return ZERO;

        TypedData data = new TypedData();
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
    public TypedData multiply(TypedData another) {
        if (another == null) return TypedData.zero();

        if (getType() != another.getType() // 两个操作数类型不一样的情况(至少有一个是 FLOAT 类型)
                || (getType() == DataType.FLOAT))  // 两个操作数类型都是 FLOAT 的情况
        {
            // 如果有任何一个操作数类型为 FLOAT, 则将另外一个操作数也按照 FLOAT 来处理，
            // 内部使用 Java 的 BigDecimal 类型的乘法执行乘法操作,
            // 这种情况下，结果的数据类型也设置为 FLOAT
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.multiply(b); // 两数相乘得到结果

            TypedData result = TypedData.toFloat(resultValue); // 包装
            return result;
        } else { // 两个操作数类型都是 INTEGER 的情况，结果也设置为 INTEGER
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            TypedData result = TypedData.toInteger(a * b);
            return result;
        }
    }

    /**
     * 除法
     *
     * @param another
     * @return
     */
    public TypedData divide(TypedData another) {
        if (another == null) return TypedData.zero();

        if (getType() != another.getType()  // 两个操作数类型不一样的情况(至少有一个是 FLOAT 类型)
                || (getType() == DataType.FLOAT)) // 两个操作数类型都是 FLOAT 的情况
        {
            // 如果有任何一个操作数类型为 FLOAT, 则将另外一个操作数也按照 FLOAT 来处理，
            // 内部使用 Java 的 BigDecimal 类型的除法执行乘法操作,
            // 这种情况下，结果的数据类型也设置为 FLOAT
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.divide(b); // 两数相除得到结果

            TypedData result = TypedData.toFloat(resultValue); // 包装
            return result;
        } else { // 两个操作数类型都是 INTEGER 的情况，结果也设置为 INTEGER
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            TypedData result = TypedData.toInteger(a / b);
            return result;
        }
    }

    /**
     * 加法
     * @param another
     * @return
     */
    public TypedData add(TypedData another) {
        if (another == null) return TypedData.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.add(b);

            TypedData result = TypedData.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            TypedData result = TypedData.toInteger(a + b);
            return result;
        }
    }

    /**
     * 减法
     * @param another
     * @return
     */
    public TypedData subtract(TypedData another) {
        if (another == null) return TypedData.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.subtract(b);

            TypedData result = TypedData.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            TypedData result = TypedData.toInteger(a - b);
            return result;
        }
    }

    /**
     * 工具方法 : 从数字字面值分析数字，类型可能是浮点数，或者整数
     *
     * @param numberLiteral
     * @return
     */
    public static TypedData parseNumberLiteral(String numberLiteral) {
        if (numberLiteral == null || numberLiteral.trim().isEmpty()) return TypedData.ZERO;

        if (numberLiteral.contains(".")) { // 字面值字符串包含. ==> 这会是一个浮点数
            BigDecimal value = new BigDecimal(numberLiteral);
            TypedData result = new TypedData();
            result.setType(DataType.FLOAT); // <=== 类型设置为 浮点数
            result.setValue(value);
            return result;
        }

        // 否则 ==> 这应该会是一个整数
        TypedData result = new TypedData();
        result.setType(DataType.INTEGER); // <=== 类型设置为 整数
        result.setValue(Long.parseLong(numberLiteral));
        return result;
    }

    public String toString() {
        return "[" + getType() + "]" + getValue();
    }
}
