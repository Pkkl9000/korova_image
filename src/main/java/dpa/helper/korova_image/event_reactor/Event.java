package dpa.helper.korova_image.event_reactor;

public class Event {
    private final String message;

    public Event(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
