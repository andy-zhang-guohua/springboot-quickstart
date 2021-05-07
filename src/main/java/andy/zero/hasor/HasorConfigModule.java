package andy.zero.hasor;

import lombok.extern.slf4j.Slf4j;
import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.DimModule;
import net.hasor.dataql.QueryApiBinder;
import net.hasor.dataway.spi.ApiInfo;
import net.hasor.dataway.spi.PreExecuteChainSpi;
import net.hasor.dataway.spi.ResultProcessChainSpi;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 对 Hasor Dataway 进行配置的一个模块
 */
@Slf4j
@DimModule
@Component
public class HasorConfigModule implements SpringModule {
    @Autowired
    private DataSource dataSource = null;

    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .DataSource form Spring boot into Hasor
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));


        // 绑定一个API执行前生命周期事件逻辑
        apiBinder.bindSpiListener(PreExecuteChainSpi.class, new MyPreExecuteChainSpi());

        // 所有返回的结果，都把 API 的 Method 和 path 返回
        apiBinder.bindSpiListener(ResultProcessChainSpi.class, new ResultProcessChainSpi() {
            /**
             * 在API正常执行后对结果做包装然后返回
             * @param formPre
             * @param apiInfo
             * @param result
             * @return
             */
            public Object callAfter(boolean formPre, ApiInfo apiInfo, Object result) {
                Map newResult = new HashMap<String, Object>() {{
                    put("method", apiInfo.getMethod());
                    put("path", apiInfo.getApiPath());
                    put("result", result);
                }};

                return newResult;
            }

            /**
             * 在API执行错误时，包装一个返回结果
             * @param formPre
             * @param apiInfo
             * @param e
             * @return
             */
            public Object callError(boolean formPre, ApiInfo apiInfo, Throwable e) {
                return new HashMap<String, Object>() {{
                    put("method", apiInfo.getMethod());
                    put("path", apiInfo.getApiPath());
                    put("errorMessage", e.getMessage());
                }};
            }
        });

        // .custom DataQL
        // apiBinder.tryCast(QueryApiBinder.class).loadUdfSource(apiBinder.findClass(DimUdfSource.class));
        //apiBinder.tryCast(QueryApiBinder.class).bindFragment("sql", SqlFragment.class);
    }

    @Override
    public void onStart(AppContext appContext) throws Throwable {
        log.info("Hasor 模块正在启动");
    }
}
