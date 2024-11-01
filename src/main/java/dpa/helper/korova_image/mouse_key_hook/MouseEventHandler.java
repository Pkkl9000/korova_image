package dpa.helper.korova_image.mouse_key_hook;

import lc.kra.system.mouse.event.GlobalMouseEvent;

public class MouseEventHandler {
    public void handleEvent(GlobalMouseEvent event) {
        System.out.println("Обработано событие: " + event.getButton() + " " + event.getX() + " " + event.getY());
        // Здесь можно вызвать другие команды, например, start()
    }
}