package andy.zymbol.model;

/**
 * 布尔类型数据
 */
public class BooleanData extends TypedData {
    /**
     * 定义常量布尔值:真
     */
    public final static BooleanData TRUE = booleanTrue();

    /**
     * 定义常量布尔值:假
     */
    public final static BooleanData FALSE = booleanFalse();

    /**
     * 内部工具方法，用于布尔真值
     *
     * @return
     */
    private static BooleanData booleanTrue() {
        BooleanData v = new BooleanData();

        v.setType(DataType.BOOLEAN);
        v.setValue(Boolean.TRUE);

        return v;
    }

    /**
     * 内部工具方法，用于布尔假值
     *
     * @return
     */
    private static BooleanData booleanFalse() {
        BooleanData v = new BooleanData();

        v.setType(DataType.BOOLEAN);
        v.setValue(Boolean.FALSE);

        return v;
    }

    public static BooleanData of(boolean bool) {
        BooleanData v = new BooleanData();

        v.setType(DataType.BOOLEAN);
        v.setValue(bool);

        return v;
    }

    public boolean isTrue() {
        return (Boolean) getValue() == true;
    }

    public BooleanData and(BooleanData another) {
        if (another == null) return FALSE;

        if (isTrue() && another.isTrue()) return TRUE;

        return FALSE;
    }

    public BooleanData or(BooleanData another) {
        if (another == null) return this;

        if (isTrue()) return TRUE;

        return another;
    }

    public BooleanData not() {
        return (isTrue()) ? FALSE : TRUE;
    }

}
