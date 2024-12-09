package dpa.helper.korova_image.actions;

import dpa.helper.korova_image.img_process.PartialScreenshot;
import dpa.helper.korova_image.mouse_key_hook.KeyboardHooking;
import dpa.helper.korova_image.mouse_key_tracking.EventTrackerReactive;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.util.ArrayList;
import java.util.List;

public class StartAreaByKey {

    public static void makeAreaActionByKey() {
        System.out.println("Действие 'StartAreaByKey' выполнено.");

        List<GlobalKeyEvent> keyEventList = new ArrayList<>();

        EventTrackerReactive eventTracker = new EventTrackerReactive();

        KeyboardHooking.keyboardListener(eventTracker);

        eventTracker.countFixedKeyboardEvents(1)
                .subscribe(events -> {
                    System.out.println("Собрано событий: " + events.size());
                    keyEventList.addAll(events);
                    // Дополнительная обработка событий
                    for (GlobalKeyEvent event : events) {
                        System.out.println(event);
                    }

                    if (keyEventList.size() == 1) {
                        StartArea.makeAreaAction();
                    }

                }, error -> {
                    System.err.println("Ошибка при сборе событий: " + error);
                });
    }

//    private static void makeScreenByEventsCoords(List<GlobalKeyEvent> mouseEventList) {
//
//        int areaX = mouseEventList.get(0).getX();
//        int areaY = mouseEventList.get(0).getY();
//
//        System.out.println(areaX + "   " + areaY);
//
//        int areaWidth = mouseEventList.get(1).getX() - areaX;
//        int areaHeight = mouseEventList.get(1).getY() - areaY;
//
//        System.out.println("areaWidth " + areaWidth + "   areaHeight " + areaHeight);
//
//        try {
//            PartialScreenshot.takePartialScreenshot(areaX, areaY, areaWidth, areaHeight);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
