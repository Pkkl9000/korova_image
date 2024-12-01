package dpa.helper.korova_image.window;

//import com.sun.jna.platform.win32.WinDef.HWND;
//import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

        import java.util.HashMap;
import java.util.Map;

public class WindowManager {

    private static final Map<Long, WinDef.HWND> windowMap = new HashMap<>();
    private static long currentId = 0;

    public static void minimizeActualWindow(String[] args) {
        User32 user32 = User32.INSTANCE;

        // Получение дескриптора активного окна
        WinDef.HWND hWnd = user32.GetForegroundWindow();

        // Запоминаем идентификатор окна
        long id = getNextId();
        windowMap.put(id, hWnd);

        // Минимизируем окно
        boolean minimized = user32.ShowWindow(hWnd, User32.SW_MINIMIZE);

        if (minimized) {
            System.out.println("Окно свернуто. Идентификатор: " + id);
        } else {
            System.out.println("Не удалось свернуть окно.");
        }
    }

    private static long getNextId() {
        return ++currentId;
    }

    public static void restoreWindow(long id) {
        if (windowMap.containsKey(id)) {
            WinDef.HWND hWnd = windowMap.get(id);
            boolean restored = User32.INSTANCE.ShowWindow(hWnd, User32.SW_RESTORE);
            if (restored) {
                System.out.println("Окно восстановлено.");
            } else {
                System.out.println("Не удалось восстановить окно.");
            }
        } else {
            System.out.println("Идентификатор окна не найден.");
        }
    }
}
