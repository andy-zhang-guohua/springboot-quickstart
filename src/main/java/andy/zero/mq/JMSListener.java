package andy.zero.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import javax.jms.Destination;
import javax.jms.MessageListener;

/**
 * JMS监听器  创建消费者
 *
 * @author Pen
 * 2020年11月08日
 */
public class JMSListener {
    /**
     * 　　* 开启一个  点对点的 消息队列监听 的消费者
     *
     * @param queueName 队列名称
     * @param listener  监听
     */

    public static synchronized void startJmsQueueListener(String queueName, MessageListener listener) {
        startJmsQueueListener(queueName, null, listener);
    }

    public static synchronized void startJmsQueueListener(String queueName, String subName, MessageListener listener) {
        ActiveMQQueue mq = new ActiveMQQueue(queueName);
        startJmsListener(mq, subName, listener);
    }


    /**
     * 　　* 开启 一对多 主题的 消息监听的消费者     　　*      　　* @param topicName  主题消息名称     　　* @param subName    订阅者的名字     　　* @param listener   监听
     */
    public static synchronized void startJmsTopicListener(String topicName, MessageListener listener) {
        startJmsTopicListener(topicName, null, listener);
    }

    public static synchronized void startJmsTopicListener(String topicName, String subName, MessageListener listener) {
        ActiveMQTopic mq = new ActiveMQTopic(topicName);
        startJmsListener(mq, subName, listener);
    }


    /**
     * 　　* 开始  消息监听器 消费者     　　*      　　* @param dest  		目的地     　　* @param subName 		持久订阅的名字     　　* @param msgListener 	消息监听器
     */
    private static void startJmsListener(Destination dest, String subName, MessageListener msgListener) {
        SimpleMessageListenerContainer listener = new SimpleMessageListenerContainer();
        listener.setConnectionFactory(ConnectionFactory.getInstance());
        listener.setDestination(dest);
        listener.setMessageListener(msgListener);
        if ((subName != null) && (subName != "")) {
            listener.setDurableSubscriptionName(subName);
        }
        listener.start();
    }
}