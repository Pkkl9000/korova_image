package dpa.helper.korova_image.mouse_key_hook;

import dpa.helper.korova_image.mouse_key_tracking.EventTrackerReactive;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class KeyboardHooking {

    //    private static boolean keyboardRun = true;
    private static boolean keyboardRun;

    public static void keyboardListener(EventTrackerReactive eventTracker) {
        // Might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // Use false here to switch to hook instead of raw input

        System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown.");

//        for (Map.Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet()) {
//            System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());
//        }

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {

            @Override
            public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
                    keyboardRun = false;
                }
                System.out.println("event.getKeyChar(): " + event.getKeyChar());
                eventTracker.sendKeyboardEvent(event);
            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                System.out.println(event);
                System.out.println("event.getKeyChar(): " + event.getKeyChar());
            }
        });

//        try {
//            while(keyboardRun) {
//                Thread.sleep(128);
//            }
//        } catch(InterruptedException e) {
//            //Do nothing
//        } finally {
//            keyboardHook.shutdownHook();
//        }

        new Thread(() -> {
            try {
                while (keyboardRun) {
                    Thread.sleep(128);
                }
            } catch (InterruptedException e) {
                // Do nothing
            } finally {
                System.out.println("KeyboardListener stopped");
                keyboardHook.shutdownHook(); // Останавливаем хук
            }
        }).start();
    }

    public static boolean isKeyboardRun() {
        return keyboardRun;
    }

    public static void setKeyboardRun(boolean keyboardRun) {
        KeyboardHooking.keyboardRun = keyboardRun;
    }
}
