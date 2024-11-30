package dpa.helper.korova_image.mouse_key_tracking;

import lc.kra.system.mouse.event.GlobalMouseEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import dpa.helper.korova_image.mouse_key_hook.MouseHooking;

import java.util.ArrayList;
import java.util.List;

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

    public Mono<List<GlobalMouseEvent>> countFixedMouseEvents(int count) {
        List<GlobalMouseEvent> events = new ArrayList<>();
        Mono<List<GlobalMouseEvent>> mono = Mono.create(sink -> {
            eventFlux
                    .take(count)
                    .subscribe(event -> {
                        System.out.println("Обрабатываем событие: " + event.getButton() + " " + event.getX() + " " + event.getY());
                        events.add(event);
                    }, error -> {
                        System.err.println("Ошибка: " + error);
                        sink.error(error); // Завершаем с ошибкой
                    }, () -> {
                        System.out.println("Отслеживание завершено.");
                        MouseHooking.setMouseRun(false);
                        sink.success(events); // Завершаем успешно с собранными событиями
                    });
        });

        return mono;
    }
}
