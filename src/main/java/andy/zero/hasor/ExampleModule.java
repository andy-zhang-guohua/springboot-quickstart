package andy.zero.hasor;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.spi.Module;
import net.hasor.core.ApiBinder;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class ExampleModule implements Module {
    @Autowired
    DataSource dataSource;

    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .创建数据源
        DataSource dataSource = null;
        // .初始化Hasor Jdbc 模块，并配置数据源
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
    }

    @Override
    public ObjectDeserializer createDeserializer(ParserConfig parserConfig, Class aClass) {
        return null;
    }

    @Override
    public ObjectSerializer createSerializer(SerializeConfig serializeConfig, Class aClass) {
        return null;
    }
}
