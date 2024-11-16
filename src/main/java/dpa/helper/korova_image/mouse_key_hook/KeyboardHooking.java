package dpa.helper.korova_image.mouse_key_hook;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class KeyboardHooking {

    private static boolean keyboardRun = true;

    public static void keyboardListener() {
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
            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                System.out.println(event);
                System.out.println("event.getKeyChar(): " + event.getKeyChar());
            }
        });

        try {
            while(keyboardRun) {
                Thread.sleep(128);
            }
        } catch(InterruptedException e) {
            //Do nothing
        } finally {
            keyboardHook.shutdownHook();
        }
    }
}
