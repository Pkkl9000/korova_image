package unused.callback;

public class EventHandler implements EventCallback {
    @Override
    public void onEventTriggered(String eventData) {
        System.out.println("Событие обработано: " + eventData);
    }
}
