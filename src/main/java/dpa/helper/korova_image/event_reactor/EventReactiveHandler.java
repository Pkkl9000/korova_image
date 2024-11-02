package dpa.helper.korova_image.event_reactor;

public class EventReactiveHandler {
    public void start(Event event) {
        System.out.println("Запуск команды для события: " + event.getMessage());
        // Дополнительная логика обработки
    }
}
