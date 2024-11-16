package dpa.helper.korova_image.mouse_key_hook;

import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.event.GlobalMouseEvent;

public class MouseAndKeyboardEventHandler {
    public void mouseHandleEvent(GlobalMouseEvent event) {
        System.out.println("Обработано событие: " + event.getButton() + " " + event.getX() + " " + event.getY());
        // Здесь можно вызвать другие команды, например, start()
    }

    public void keyboardHandleEvent(GlobalKeyEvent event) {
        System.out.println("Обработано событие: " + "");
        // Здесь можно вызвать другие команды, например, start()
    }
}