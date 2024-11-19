package dpa.helper.korova_image.thread_dispatching;

import java.util.HashMap;
import java.util.Map;

class ThreadListenerAndCounter {
    private static boolean mouseRun = true;
    private static Map<String, Integer> eventsCount = new HashMap<>();

    public void handleEventB(EventB event) {
        if (mouseRun) {
            // Обработка события типа EventB
            System.out.println("Обработано событие EventB");
            incrementEventCount("EventB");
        }
    }

    public void handleEventC(EventC event) {
        if (mouseRun) {
            // Обработка события типа EventC
            System.out.println("Обработано событие EventC");
            incrementEventCount("EventC");
        }
    }

    private void incrementEventCount(String eventType) {
        eventsCount.put(eventType, eventsCount.getOrDefault(eventType, 0) + 1);
    }

    public int getEventCount(String eventType) {
        return eventsCount.getOrDefault(eventType, 0);
    }

    public static void setMouseRun(boolean run) {
        mouseRun = run;
    }
}
