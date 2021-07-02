package andy.zero.hasor;

import net.hasor.dataql.Hints;
import net.hasor.dataql.Udf;

import java.util.Map;
import java.util.TreeMap;

public class UserByIdUdf implements Udf {
    Map<Integer, User> users = new TreeMap<>();

    public UserByIdUdf() {
        users.put(3, new User(3,"张三", 20, 'F'));
        users.put(4, new User(4,"李四", 31, 'M'));
        users.put(5, new User(5,"王五", 42, 'F'));
    }

    @Override
    public Object call(Hints readOnly, Object... params) throws Throwable {
        if (params.length == 0) return null;

        Map<String, Byte> map = (Map) params[0];

        int intId = map.get("id");
        return users.get(intId);
    }
}
