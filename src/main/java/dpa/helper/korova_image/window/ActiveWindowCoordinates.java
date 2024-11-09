package dpa.helper.korova_image.window;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;


public class ActiveWindowCoordinates {

    private static final String TARGET_WINDOW_TITLE = "Безымянный - Paint"; // Заголовок окна MS Paint
    private static final int WAIT_TIME = 10000; // 10 секунд в миллисекундах
    public static WindowParams getCoordsAndDimensions() {

        User32 user32 = User32.INSTANCE;

        // Получаем дескриптор активного окна
        WinUser.HWND hwnd = user32.GetForegroundWindow();

        if (!waitForMSPaint()) {
            System.out.println("time for waiting mspaint is out");
            return null;
        }


        // Получаем координаты окна
        WinDef.RECT rect = new WinDef.RECT();
        user32.GetWindowRect(hwnd, rect);

        return new WindowParams(rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
    }

    public static Boolean waitForMSPaint() {
        User32 user32 = User32.INSTANCE;
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < WAIT_TIME) {
            WinDef.HWND hwnd = user32.FindWindow(null, TARGET_WINDOW_TITLE);
            if (hwnd != null) {
                // Проверяем, является ли окно активным
                if (user32.GetForegroundWindow().equals(hwnd)) {
                    return true;
                }
            }

            // Немного подождем, чтобы не нагружать процессор
            try {
                Thread.sleep(500); // Проверяем каждые 500 миллисекунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
