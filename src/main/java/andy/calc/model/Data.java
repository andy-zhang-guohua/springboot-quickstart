package andy.calc.model;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@lombok.Data
public class Data {
    DataType type;
    Object value;

    public static Data ZERO = zero();

    private static Data zero() {
        Data zero = new Data();

        zero.setType(DataType.INTEGER);
        zero.setValue(0L);

        return zero;
    }

    public static Data toFloat(BigDecimal value) {
        if (value == null) return ZERO;

        Data data = new Data();
        data.setType(DataType.FLOAT);
        data.setValue(value);
        return data;
    }

    public static Data toInteger(Long value) {
        if (value == null) return ZERO;

        Data data = new Data();
        data.setType(DataType.INTEGER);
        data.setValue(value);
        return data;
    }

    /**
     * 乘法支持
     * @param another
     * @return
     */
    public Data multiply(Data another) {
        if (another == null) return Data.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.multiply(b);

            Data result = Data.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            Data result = Data.toInteger(a * b);
            return result;
        }
    }

    /**
     * 除法支持
     * @param another
     * @return
     */
    public Data divide(Data another) {
        if (another == null) return Data.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.divide(b);

            Data result = Data.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            Data result = Data.toInteger(a / b);
            return result;
        }
    }

    public Data add(Data another) {
        if (another == null) return Data.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.add(b);

            Data result = Data.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            Data result = Data.toInteger(a + b);
            return result;
        }
    }

    public Data subtract(Data another) {
        if (another == null) return Data.zero();

        if (getType() != another.getType() || (getType() == DataType.FLOAT)) {
            BigDecimal a = new BigDecimal(getValue().toString());
            BigDecimal b = new BigDecimal(another.getValue().toString());

            BigDecimal resultValue = a.subtract(b);

            Data result = Data.toFloat(resultValue);
            return result;
        } else {
            Long a = (Long) getValue();
            Long b = (Long) another.getValue();
            Data result = Data.toInteger(a - b);
            return result;
        }
    }

    /**
     * 从数字字面值分析数字，类型可能是浮点数，或者整数
     *
     * @param numberLiteral
     * @return
     */
    public static Data parseNumberLiteral(String numberLiteral) {
        if (StringUtils.isBlank(numberLiteral)) return Data.ZERO;

        if (numberLiteral.contains(".")) {
            BigDecimal value = new BigDecimal(numberLiteral);
            Data result = new Data();
            result.setType(DataType.FLOAT);
            result.setValue(value);
            return result;
        }

        Data result = new Data();
        result.setType(DataType.INTEGER);
        result.setValue(Long.parseLong(numberLiteral));
        return result;
    }

    public String toString() {
        return "[" + type + "]" + value;
    }
}
