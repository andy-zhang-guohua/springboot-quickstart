package andy.zero.hasor;

import lombok.extern.slf4j.Slf4j;
import net.hasor.dataway.spi.ApiInfo;
import net.hasor.dataway.spi.PreExecuteChainSpi;
import net.hasor.utils.future.BasicFuture;

@Slf4j
public class MyPreExecuteChainSpi implements PreExecuteChainSpi {
    @Override
    public void preExecute(ApiInfo apiInfo, BasicFuture<Object> future) {
        log.info("将要执行接口 : {}", apiInfo.getApiPath());
    }
}
