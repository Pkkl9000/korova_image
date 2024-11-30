package dpa.helper.korova_image.actions;

import dpa.helper.korova_image.img_process.PartialScreenshot;
import dpa.helper.korova_image.mouse_key_hook.MouseHooking;
import dpa.helper.korova_image.mouse_key_tracking.EventTrackerReactive;
import lc.kra.system.mouse.event.GlobalMouseEvent;

import java.util.ArrayList;
import java.util.List;

public class StartArea {

    public static void makeAreaAction() {
        System.out.println("Действие 'StartArea' выполнено.");

        List<GlobalMouseEvent> mouseEventList = new ArrayList<>();

        EventTrackerReactive eventTracker = new EventTrackerReactive();

        MouseHooking.MouseListener(eventTracker);

        eventTracker.countFixedMouseEvents(2)
                .subscribe(events -> {
                    System.out.println("Собрано событий: " + events.size());
                    mouseEventList.addAll(events);
                    // Дополнительная обработка событий
                    for (GlobalMouseEvent event : events) {
                        System.out.println(event);
                    }

                    if (mouseEventList.size() == 2) {
                        makeScreenByEventsCoords(mouseEventList);
                    }

                }, error -> {
                    System.err.println("Ошибка при сборе событий: " + error);
                });
    }

    private static void makeScreenByEventsCoords(List<GlobalMouseEvent> mouseEventList) {

        int areaX = mouseEventList.get(0).getX();
        int areaY = mouseEventList.get(0).getY();

        System.out.println(areaX + "   " + areaY);

        int areaWidth = mouseEventList.get(1).getX() - areaX;
        int areaHeight = mouseEventList.get(1).getY() - areaY;

        System.out.println("areaWidth " + areaWidth + "   areaHeight " + areaHeight);

        try {
            PartialScreenshot.takePartialScreenshot(areaX, areaY, areaWidth, areaHeight);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
