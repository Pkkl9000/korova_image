package dpa.helper.korova_image.actions;

import dpa.helper.korova_image.mouse_key_hook.MouseHooking;
import dpa.helper.korova_image.mouse_key_tracking.EventTrackerReactive;
import lc.kra.system.mouse.event.GlobalMouseEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class StartArea {

    public static void makeAreaAction() {
        System.out.println("Действие 'Start' выполнено.");

        EventTrackerReactive eventTracker = new EventTrackerReactive();

        MouseHooking.MouseListener(eventTracker);

        eventTracker.countFixedMouseEvents(2)
                .subscribe(events -> {
                    System.out.println("Собрано событий: " + events.size());
                    // Дополнительная обработка событий
                    for (GlobalMouseEvent event : events) {
                        System.out.println(event);
                    }
                }, error -> {
                    System.err.println("Ошибка при сборе событий: " + error);
                });
    }
}
