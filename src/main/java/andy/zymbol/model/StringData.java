package andy.zymbol.model;

/**
 * 字符串类型数据
 */
public class StringData extends TypedData {
    /**
     * 定义常量空字符串(0长度字符串)
     */
    public static StringData EMPTY = empty();

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

    /**
     * 获取字符串长度
     *
     * @return
     */
    public int getLength() {
        return ((String) getValue()).length();
    }
}
