package andy.bpmn.flowable.event;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.event.AbstractFlowableEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEntityEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.springframework.stereotype.Service;

import static org.flowable.common.engine.api.delegate.event.FlowableEngineEventType.ENTITY_CREATED;

@Service
@Slf4j
public class MyEventListener extends AbstractFlowableEventListener {
    @Override
    public void onEvent(FlowableEvent event) {
        String eventName = event.getType().name();
        if (eventName.startsWith("ENGINE")) {
            log.info("监听到 ENGINE 事件: {}", event.getType());
        } else if (eventName.startsWith("PROCESS")) {
            log.info("监听到 PROCESS 事件: {}", event.getType());
        } else if (eventName.startsWith("ENTITY")) {
            dumpFlowableEngineEntityEvent((FlowableEngineEntityEvent) event);
        } else if (eventName.startsWith("ACTIVITY")) {
            log.info("监听到 ACTIVITY 事件: {}", event.getType());
        } else if (eventName.startsWith("TASK")) {
            log.info("监听到 TASK 事件: {}", event.getType());
        } else if (eventName.startsWith("VARIABLE")) {
            log.info("监听到 VARIABLE 事件: {}", event.getType());
        } else if (eventName.startsWith("SEQUENCEFLOW")) {
            log.info("监听到 SEQUENCEFLOW 事件: {}", event.getType());
        } else if (eventName.startsWith("HISTORIC_ACTIVITY_INSTANCE")) {
            log.info("监听到 HISTORIC_ACTIVITY_INSTANCE 事件: {}", event.getType());
        } else if (eventName.startsWith("HISTORIC_PROCESS_INSTANCE")) {
            log.info("监听到 HISTORIC_PROCESS_INSTANCE 事件: {}", event.getType());
        } else {
            log.info("监听到事件: {}", event.getType());
        }
    }

    private void dumpFlowableEngineEntityEvent(FlowableEngineEntityEvent event) {
        log.info("监听到 ENTITY 事件: {}", event.getType());
    }

    @Override
    public boolean isFailOnException() {
        // The logic in the onEvent method of this listener is not critical, exceptions
        // can be ignored if logging fails...
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}
