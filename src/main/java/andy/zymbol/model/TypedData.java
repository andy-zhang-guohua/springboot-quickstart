package andy.zymbol.model;

/**
 * 建模带类型的数据 -- 基类
 */
public abstract class TypedData {
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


    public String toString() {
        return "[" + getType() + "]" + getValue();
    }
}
