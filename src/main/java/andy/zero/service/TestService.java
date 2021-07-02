package andy.zero.service;

import andy.zero.hasor.DataQueryContext;
import andy.zero.hasor.UserByIdUdf;
import lombok.extern.slf4j.Slf4j;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.dataql.DataQL;
import net.hasor.dataql.Query;
import net.hasor.dataql.QueryModule;
import net.hasor.dataql.QueryResult;
import net.hasor.dataql.domain.DataModel;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;

/**
 * 参考文档 : https://www.hasor.net/doc/pages/viewpage.action?pageId=1573249
 */
@Slf4j
@Service
public class TestService {
    @Autowired
    DataSource dataSource;

    public void testUDF() throws IOException {
        // 自定义一个 UDF, 用于根据 ID 查询用户
        AppContext appContext = Hasor.create().build((QueryModule) apiBinder -> {
            apiBinder.addShareVarInstance("userByID", new UserByIdUdf());

        });
        DataQL dataQL = appContext.getInstance(DataQL.class);
        QueryResult queryResult = dataQL.createQuery(
                "return userByID({'id': 4}) => {" +
                        "    'name'," +
                        "    'sex' : (sex == 'F') ? '男' : '女' ," +
                        "    'age' : age + '岁'" +
                        "}"
        ).execute();
        DataModel dataModel = queryResult.getData();

        log.info("userByID : {}", dataModel.unwrap());
    }

    public void testDataQL() throws IOException {
        HashMap<String, Object> tempData = new HashMap<String, Object>() {{
            put("uid", "uid is 123");
            put("sid", "sid is 456");
        }};

        DataQL dataQL = DataQueryContext.getDataQL();
        Query dataQuery = dataQL.createQuery("return [${uid},${sid}]");
        QueryResult queryResult = dataQuery.execute(tempData);
        DataModel dataModel = queryResult.getData();

        log.info("user info : {}", dataModel.unwrap());
    }

    public void testExecuteSQL() throws IOException {
        String sql = "// 声明一个 SQL\n" +
                "var dataSetFun = @@sql() <%\n" +
                "    select * from interface_info limit 10;\n" +
                "%>\n" +
                " \n" +
                "// 执行这个 SQL，并返回结果\n" +
                "return dataSetFun();";

        AppContext appContext = Hasor.create().build((QueryModule) apiBinder -> {
            // .初始化Hasor Jdbc 模块，并配置数据源
            apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
        });
        DataQL dataQL = appContext.getInstance(DataQL.class);
        Query dataQuery = dataQL.createQuery(sql);
        QueryResult queryResult = dataQuery.execute();
        DataModel dataModel = queryResult.getData();

        log.info("user info : {}", dataModel.unwrap());
    }
}
