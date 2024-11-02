package unused.callback;

public class EventTrigger {
    private EventCallback callback;

    public EventTrigger(EventCallback callback) {
        this.callback = callback;
    }

    public void triggerEvent() {
        // Логика триггера
        String eventData = "Данные события";
        if (callback != null) {
            callback.onEventTriggered(eventData); // Вызов триггера
        }
    }
}