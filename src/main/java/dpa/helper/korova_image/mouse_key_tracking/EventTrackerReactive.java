package dpa.helper.korova_image.mouse_key_tracking;

import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.event.GlobalMouseEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import dpa.helper.korova_image.mouse_key_hook.MouseHooking;

import java.util.ArrayList;
import java.util.List;

public class EventTrackerReactive {
    private final Sinks.Many<GlobalMouseEvent> mouseSink;

    private final Sinks.Many<GlobalKeyEvent> keyboardSink;
    private final Flux<GlobalMouseEvent> eventMouseFlux;

    private final Flux<GlobalKeyEvent> eventKeyboardFlux;

    public EventTrackerReactive() {
        keyboardSink = Sinks.many().multicast().directAllOrNothing();
        mouseSink = Sinks.many().multicast().directAllOrNothing();
        eventMouseFlux = mouseSink.asFlux();
        eventKeyboardFlux = keyboardSink.asFlux();
    }

    public void sendMouseEvent(GlobalMouseEvent event) {
        mouseSink.tryEmitNext(event); // Отправляем событие в поток
    }

    public Mono<List<GlobalMouseEvent>> countFixedMouseEvents(int count) {
        List<GlobalMouseEvent> events = new ArrayList<>();
        Mono<List<GlobalMouseEvent>> mono = Mono.create(sink -> {
            eventMouseFlux
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

    public void sendKeyboardEvent(GlobalKeyEvent event) {
        keyboardSink.tryEmitNext(event);
    }

    public Mono<List<GlobalKeyEvent>> countFixedKeyboardEvents(int count) {
        List<GlobalKeyEvent> events = new ArrayList<>();
        Mono<List<GlobalKeyEvent>> mono = Mono.create(sink -> {
            eventKeyboardFlux
                    .take(count)
                    .subscribe(event -> {
                        System.out.println("Обрабатываем событие: " + event.getKeyChar());
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
