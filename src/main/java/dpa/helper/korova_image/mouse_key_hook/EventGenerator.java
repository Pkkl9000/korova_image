package dpa.helper.korova_image.mouse_key_hook;

import lc.kra.system.mouse.event.GlobalMouseEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Schedulers;

public class EventGenerator {
    private final Sinks.Many<GlobalMouseEvent> sink;
    private final Flux<GlobalMouseEvent> eventFlux;

    public EventGenerator() {
        // Создаем Sinks.Many для отправки событий
        sink = Sinks.many().multicast().directAllOrNothing();

        // Получаем Flux из Sinks
        eventFlux = sink.asFlux().subscribeOn(Schedulers.boundedElastic());
    }

    public void generateEvent(GlobalMouseEvent event) {
        // Отправляем событие в поток
        sink.tryEmitNext(event);
    }

    public Flux<GlobalMouseEvent> getEventFlux() {
        return eventFlux;
    }
}
