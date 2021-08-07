package andy.calc.model;

import java.math.BigDecimal;

/**
 * 带类型的数据
 */
public class TypedData {
    private DataType type;
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

    public static TypedData ZERO = zero();

    private static TypedData zero() {
        TypedData zero = new TypedData();

        zero.setType(DataType.INTEGER);
        zero.setValue(0L);

        return zero;
    }

    public static TypedData toFloat(BigDecimal value) {
        if (value == null) return ZERO;

        TypedData data = new TypedData();
        data.setType(DataType.FLOAT);
        data.setValue(value);
        return data;
    }

    public static TypedData toInteger(Long value) {
        if (value == null) return ZERO;

        TypedData data = new TypedData();
        data.setType(DataType.INTEGER);
        data.setValue(value);
        return data;
    }

    /**
     * 乘法支持
     *
     * @param another
     * @return
     */
    public TypedData multiply(TypedData another) {
        if (another == null) return TypedData.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.multiply(b);

            TypedData result = TypedData.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            TypedData result = TypedData.toInteger(a * b);
            return result;
        }
    }

    /**
     * 除法支持
     *
     * @param another
     * @return
     */
    public TypedData divide(TypedData another) {
        if (another == null) return TypedData.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.divide(b);

            TypedData result = TypedData.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            TypedData result = TypedData.toInteger(a / b);
            return result;
        }
    }

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
     * 从数字字面值分析数字，类型可能是浮点数，或者整数
     *
     * @param numberLiteral
     * @return
     */
    public static TypedData parseNumberLiteral(String numberLiteral) {
        if (numberLiteral == null || numberLiteral.trim().isEmpty()) return TypedData.ZERO;

        if (numberLiteral.contains(".")) {
            BigDecimal value = new BigDecimal(numberLiteral);
            TypedData result = new TypedData();
            result.setType(DataType.FLOAT);
            result.setValue(value);
            return result;
        }

        TypedData result = new TypedData();
        result.setType(DataType.INTEGER);
        result.setValue(Long.parseLong(numberLiteral));
        return result;
    }

    public String toString() {
        return "[" + getType() + "]" + getValue();
    }
}
