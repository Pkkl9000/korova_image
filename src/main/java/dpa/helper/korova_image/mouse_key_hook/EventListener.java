package dpa.helper.korova_image.mouse_key_hook;

import lc.kra.system.mouse.event.GlobalMouseEvent;
import reactor.core.publisher.Flux;

public class EventListener {
    private final EventGenerator eventGenerator;

    public EventListener(EventGenerator eventGenerator) {
        this.eventGenerator = eventGenerator;

        // Подписываемся на события
        subscribeToEvents();
    }

    private void subscribeToEvents() {
        // Получаем Flux и подписываемся на него
        eventGenerator.getEventFlux().subscribe(
                event -> handleEvent(event), // Обработчик события
                error -> handleError(error), // Обработка ошибок
                () -> handleComplete()        // Обработка завершения
        );
    }

    private void handleEvent(GlobalMouseEvent event) {
        // Логика обработки события
        System.out.println("Received event: " + event);
    }

    private void handleError(Throwable error) {
        // Логика обработки ошибок
        System.err.println("Error occurred: " + error.getMessage());
    }

    private void handleComplete() {
        // Логика обработки завершения потока
        System.out.println("Event stream completed.");
    }
}