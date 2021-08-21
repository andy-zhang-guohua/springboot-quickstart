package andy.zymbol.model;

/**
 * 字符串类型数据
 */
public class StringData extends TypedData {
    /**
     * 定义常量空字符串(0长度字符串)
     */
    public final static StringData EMPTY = empty();

    /**
     * 内部工具方法，用于构造空字符串(0长度字符串)
     *
     * @return
     */
    private static StringData empty() {
        StringData empty = new StringData();

        empty.setType(DataType.STRING);
        empty.setValue("");

        return empty;
    }

    /**
     * 从一个Java字符串构造一个 StringData 对象
     * @param text
     * @return
     */
    public static StringData of(String text) {
        if (text == null) return EMPTY;

        StringData newStringData = new StringData();
        newStringData.setType(DataType.STRING);
        newStringData.setValue(text);
        return newStringData;
    }

    /**
     * 从另外一个 StringData 对象复制构造一个新的 StringData 对象
     *
     * 该方法对 null 做了特殊处理，所有 null 被转换成 EMPTY
     * @param another
     * @return
     */
    public static StringData of(StringData another) {
        if (another == null) return EMPTY;

        StringData newStringData = new StringData();
        newStringData.setType(DataType.STRING);
        newStringData.setValue(another.getValue().toString());
        return newStringData;
    }

    /**
     * 字符串拼接
     *
     * @param another 要拼接的另外一个字符串
     * @return 返回一个新的字符串，也是字符串类型
     */
    public StringData concatenate(StringData another) {
        String newValue = another == null ? (String) getValue() : getValue() + (String) another.getValue();

        StringData newStringData = new StringData();

        newStringData.setType(DataType.STRING);
        newStringData.setValue(newValue);

        return newStringData;
    }
}
