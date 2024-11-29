package dpa.helper.korova_image.mouse_key_tracking;

import lc.kra.system.mouse.event.GlobalMouseEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import dpa.helper.korova_image.mouse_key_hook.MouseHooking;

public class EventTrackerReactive {
    private final Sinks.Many<GlobalMouseEvent> sink;
    private final Flux<GlobalMouseEvent> eventFlux;

    public EventTrackerReactive() {
        sink = Sinks.many().multicast().directAllOrNothing();
        eventFlux = sink.asFlux();
    }

    public void sendMouseEvent(GlobalMouseEvent event) {
        sink.tryEmitNext(event); // Отправляем событие в поток
    }

    public void countFixedMouseEvents(int count) {
        eventFlux
                .take(count) // Берем только нужное количество событий
                .subscribe(event -> {
                    // Обработка события
                    System.out.println("Обрабатываем событие: " + event.getButton() + " " + event.getX() + " " + event.getY());
                }, error -> {
                    System.err.println("Ошибка: " + error);
                }, () -> {
                    System.out.println("Отслеживание завершено.");
                    MouseHooking.setMouseRun(false);
                });
    }
}
