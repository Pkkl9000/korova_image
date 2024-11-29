package dpa.helper.korova_image.mouse_key_hook;


import dpa.helper.korova_image.mouse_key_tracking.EventTrackerReactive;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;

//uses system-hook library from https://github.com/kristian/system-hook
public class MouseHooking {

    private static boolean mouseRun = true;

    public static void MouseListener(EventTrackerReactive eventTracker) {
        // Might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
        GlobalMouseHook mouseHook = new GlobalMouseHook(); // Add true to the constructor, to switch to raw input mode

        System.out.println("Global mouse hook successfully started, press [middle] mouse button to shutdown.");

        mouseHook.addMouseListener(new GlobalMouseAdapter() { // Передаем eventTracker в адаптер
            @Override
            public void mousePressed(GlobalMouseEvent event) {
                // Проверяем, нажата ли левая кнопка мыши
                if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO) {
                    System.out.println("from system_hook: " + event.getButton() + " " + event.getX() + " " + event.getY());

                    // Отправляем событие в EventTracker
                    eventTracker.sendMouseEvent(event);
                }
                // Проверяем, нажата ли средняя кнопка мыши для завершения
                if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
                    mouseRun = false; // Останавливаем выполнение
                }

                if (event.getButton()==GlobalMouseEvent.BUTTON_MIDDLE) {
                    mouseRun = false;
                }
            }
        });

        new Thread(() -> {
            try {
                while (mouseRun) {
                    Thread.sleep(128);
                }
            } catch (InterruptedException e) {
                // Do nothing
            } finally {
                System.out.println("MouseListener stopped");
                mouseHook.shutdownHook(); // Останавливаем хук
            }
        }).start();
    }

    public static boolean isMouseRun() {
        return mouseRun;
    }

    public static void setMouseRun(boolean mouseRun) {
        MouseHooking.mouseRun = mouseRun;
    }
}
