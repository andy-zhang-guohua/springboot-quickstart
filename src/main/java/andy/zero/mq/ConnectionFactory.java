package andy.zero.mq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.connection.CachingConnectionFactory;

/**
 * 连接工厂 配置
 *
 * @author Pen
 * 2020年11月08日
 */
public class ConnectionFactory {

    /*

    tcp://10.88.3.12:61608,tcp://10.88.3.11:61608,tcp://10.88.3.10:61608
     private static final String URL = "failover:(tcp://10.88.3.12:61608,tcp://10.88.3.11:61608,tcp://10.88.3.10:61608)?randomize=false";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final int SESSIONCACHESIZE = 20;

     */

    private static final String APP_ID = "com.awspass.user.apps.common";
    private static final String URL = "failover:(tcp://10.88.3.12:61608,tcp://10.88.3.11:61608,tcp://10.88.3.10:61608)?randomize=false";
    private static final String USERNAME = "USERNAME";
    private static final String PASSWORD = "PASSWORD";
    private static final String SESSIONCACHESIZE = "20";
    private javax.jms.ConnectionFactory factory;

    public static synchronized javax.jms.ConnectionFactory getInstance() {
        if (SingletonHolder.INSTANCE.factory == null) {
            SingletonHolder.INSTANCE.build();
        }
        return SingletonHolder.INSTANCE.factory;
    }

    private void build() {
        AMQConfigBean bean = loadConfigure();
        this.factory = buildConnectionFactory(bean);
    }

    private javax.jms.ConnectionFactory buildConnectionFactory(AMQConfigBean bean) {
        javax.jms.ConnectionFactory targetFactory = new ActiveMQConnectionFactory(bean.getUserName(), bean.getPassword(), bean.getBrokerURL());

        CachingConnectionFactory connectoryFacotry = new CachingConnectionFactory();
        connectoryFacotry.setTargetConnectionFactory(targetFactory);
        connectoryFacotry.setSessionCacheSize(bean.getSessionCacheSize());

        return connectoryFacotry;
    }

    private AMQConfigBean loadConfigure() {
        try {
            return new AMQConfigBean(URL, "", "", 20);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("load amq config error!");
        }
    }

    private static class AMQConfigBean {
        private String brokerURL;
        private String userName;
        private String password;
        private int sessionCacheSize;

        public AMQConfigBean() {
        }

        public AMQConfigBean(String brokerURL, String userName, String password, int sessionCacheSize) {
            this.brokerURL = brokerURL;
            this.userName = userName;
            this.password = password;
            this.sessionCacheSize = sessionCacheSize;
        }

        public String getBrokerURL() {
            return this.brokerURL;
        }

        public void setBrokerURL(String brokerURL) {
            this.brokerURL = brokerURL;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getSessionCacheSize() {
            return this.sessionCacheSize;
        }

        public void setSessionCacheSize(int sessionCacheSize) {
            this.sessionCacheSize = sessionCacheSize;
        }
    }

    private static class SingletonHolder {
        static ConnectionFactory INSTANCE = new ConnectionFactory();
    }
}