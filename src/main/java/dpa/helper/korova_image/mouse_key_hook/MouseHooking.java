package dpa.helper.korova_image.mouse_key_hook;


import dpa.helper.korova_image.mouse_key_tracking.EventTracker;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;

//uses system-hook library from https://github.com/kristian/system-hook
public class MouseHooking {

    private static boolean mouseRun = true;

    private static final EventTracker eventTracker = new EventTracker();


    public static void MouseListener() {

        // Might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
        GlobalMouseHook mouseHook = new GlobalMouseHook(); // Add true to the constructor, to switch to raw input mode

        System.out.println("Global mouse hook successfully started, press [middle] mouse button to shutdown.");

//        for (Map.Entry<Long,String> mouse:GlobalMouseHook.listMice().entrySet()) {
//            System.out.format("%d: %s\n", mouse.getKey(), mouse.getValue());
//        }

        mouseHook.addMouseListener(new GlobalMouseAdapter() {

            @Override
            public void mousePressed(GlobalMouseEvent event)  {
//                System.out.println(event);
//                if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO
//                        && (event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
//                    System.out.println("Both mouse buttons are currently pressed!");
//                }

                // разобраться, что за баттон_но
//                public static final int BUTTON_NO = 0;
                if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO) {
                    System.out.println("from system_hook: " + event.getButton() + " " + event.getX() + " " + event.getY());

                    eventTracker.sendMouseEvent(event);
                }
                if (event.getButton()==GlobalMouseEvent.BUTTON_MIDDLE) {
                    mouseRun = false;
                }
            }

            @Override
            public void mouseReleased(GlobalMouseEvent event)  {
//                System.out.println(event);
            }

            @Override
            public void mouseMoved(GlobalMouseEvent event) {
//                System.out.println(event);
            }

//            @Override
//            public void mouseWheel(GlobalMouseEvent event) {
//                System.out.println(event);
//            }
        });

        try {
            while(mouseRun) {
                Thread.sleep(128);
            }
        } catch(InterruptedException e) {
            //Do nothing
        } finally {
            mouseHook.shutdownHook();
        }
    }



//    public static void keyboardListener() {
//        // Might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
//        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // Use false here to switch to hook instead of raw input
//
//        System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown.");
//
////        for (Map.Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet()) {
////            System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());
////        }
//
//        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
//
//            @Override
//            public void keyPressed(GlobalKeyEvent event) {
//                System.out.println(event);
//                System.out.println("ffgg555555g");
//                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
//                    keyboardRun = false;
//                }
//                System.out.println("event.getKeyChar(): " + event.getKeyChar());
//            }
//
//            @Override
//            public void keyReleased(GlobalKeyEvent event) {
//                System.out.println(event);
//                System.out.println("event.getKeyChar(): " + event.getKeyChar());
//            }
//        });
//
//        try {
//            while(keyboardRun) {
//                Thread.sleep(128);
//            }
//        } catch(InterruptedException e) {
//            //Do nothing
//        } finally {
//            keyboardHook.shutdownHook();
//        }
//    }
}
