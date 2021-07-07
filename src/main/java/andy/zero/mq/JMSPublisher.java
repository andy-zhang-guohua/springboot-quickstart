package andy.zero.mq;

/**
 * 创建 jms生产者
 *
 * @author Pen
 * 2020年11月08日
 */
public class JMSPublisher {
    /**
     * 　　* 发送消息	 　　* Topic 生产者 	 　　* 	 　　* @param dest  目的地	 　　* @param msg   消息内容
     */
    public static void sendTopicMessage(String dest, String msg) {
        JmsTemplateFactory.getInstance().getTopicJmsTemplate().send(dest, session -> session.createTextMessage(msg));
    }


    /**
     * 　　* 发送消息	 　　* Queue 生产者 	 　　* 	 　　* @param dest  目的地	 　　* @param msg   消息内容
     */
    public static void sendQueueMessage(String dest, String msg) {
        JmsTemplateFactory.getInstance().getQueueJmsTemplate().send(dest, session -> session.createTextMessage(msg));
    }
}