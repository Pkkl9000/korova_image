package dpa.helper.korova_image.mouse_key_tracking;

import dpa.helper.korova_image.mouse_key_hook.MouseHooking;
import dpa.helper.korova_image.mouse_key_hook.KeyboardHooking;

public class EventManager {

    private EventTrackerReactive eventTracker;
    private boolean mouseTrackingEnabled;
    private boolean keyboardTrackingEnabled;

    public EventManager(EventTrackerReactive eventTracker) {
        this.eventTracker = eventTracker;
        this.mouseTrackingEnabled = false;
        this.keyboardTrackingEnabled = false;
    }

    public void startMouseTracking() {
        if (!mouseTrackingEnabled) {
            MouseHooking.MouseListener(eventTracker);
            mouseTrackingEnabled = true;
            System.out.println("Отслеживание событий мыши включено.");
        } else {
            System.out.println("Отслеживание событий мыши уже включено.");
        }
    }

    public void stopMouseTracking() {
        if (mouseTrackingEnabled) {
            MouseHooking.setMouseRun(false);
            mouseTrackingEnabled = false;
            System.out.println("Отслеживание событий мыши выключено.");
        } else {
            System.out.println("Отслеживание событий мыши уже выключено.");
        }
    }

    public void startKeyboardTracking() {
        if (!keyboardTrackingEnabled) {
            KeyboardHooking.keyboardListener(eventTracker);
            keyboardTrackingEnabled = true;
            System.out.println("Отслеживание событий клавиатуры включено.");
        } else {
            System.out.println("Отслеживание событий клавиатуры уже включено.");
        }
    }

    public void stopKeyboardTracking() {
        if (keyboardTrackingEnabled) {
            KeyboardHooking.setKeyboardRun(false); // Предполагается, что есть аналогичный метод для клавиатуры
            keyboardTrackingEnabled = false;
            System.out.println("Отслеживание событий клавиатуры выключено.");
        } else {
            System.out.println("Отслеживание событий клавиатуры уже выключено.");
        }
    }
}
