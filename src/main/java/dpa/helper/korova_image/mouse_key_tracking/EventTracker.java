package dpa.helper.korova_image.mouse_key_tracking;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.event.GlobalMouseEvent;

public class EventTracker {

    private final PublishSubject<GlobalMouseEvent> mouseEventSubject = PublishSubject.create();
    private final PublishSubject<GlobalKeyEvent> keyEventSubject = PublishSubject.create();

    public EventTracker() {
        trackEvents();
    }

    private void trackEvents() {
        // Берем только одно событие мыши
        Observable<GlobalMouseEvent> mouseEvents = mouseEventSubject
                .take(1);

        mouseEvents
                .subscribeOn(Schedulers.io())
                .subscribe(mouseEvent -> {
                    executeCommand(mouseEvent);
                });
    }

//    private void trackEvents() {
//        Observable<GlobalMouseEvent> mouseEvents = mouseEventSubject
//                .take(1); // Берем только одно событие
//
//        Observable<GlobalKeyEvent> keyEvents = keyEventSubject
//                .take(1); // Берем только одно событие
//
//        mouseEvents
//                .zipWith(keyEvents, (mouseEvent, keyEvent) -> {
//                    executeCommand(mouseEvent, keyEvent);
//                    return true;
//                })
//                .subscribeOn(Schedulers.io())
//                .subscribe();
//    }

    private void executeCommand(GlobalMouseEvent mouseEvent) {
        System.out.println("Одно событие  получено!");
        // Здесь можно выполнять необходимые команды
    }

    public void sendMouseEvent(GlobalMouseEvent event) {
        mouseEventSubject.onNext(event);
    }

    public void sendKeyEvent(GlobalKeyEvent event) {
        keyEventSubject.onNext(event);
    }

//    public static class GlobalMouseEvent {
//        // Данные события мыши
//    }
//
//    public static class GlobalKeyEvent {
//        // Данные события клавиатуры
//    }
}
