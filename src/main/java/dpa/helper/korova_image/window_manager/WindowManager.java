package dpa.helper.korova_image.window_manager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WindowManager {

    public static void robotKeyMinimize() {
        try {
            // Создаем объект Robot
            Robot robot = new Robot();

            // Нажимаем клавишу Windows + M для сворачивания всех окон
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_WINDOWS);

            // Если хотите свернуть только текущее окно, используйте Alt + Space + N
            // robot.keyPress(KeyEvent.VK_ALT);
            // robot.keyPress(KeyEvent.VK_SPACE);
            // robot.keyPress(KeyEvent.VK_N);
            // robot.keyRelease(KeyEvent.VK_N);
            // robot.keyRelease(KeyEvent.VK_SPACE);
            // robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
