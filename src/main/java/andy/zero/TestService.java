package andy.zero;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Slf4j
@Service
public class TestService {
    public void test(){
      log.info("This is a test of Spring bean service");
    }
}
