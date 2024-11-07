package dpa.helper.korova_image.paint_start;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.io.IOException;

public class LaunchPaint {
    // Запуск программы mspaint.exe
    public static void launch() {
        String paintProcessName = "mspaint.exe";
        User32 user32 = User32.INSTANCE;

        // Проверка, открыто ли окно mspaint
        WinDef.HWND hwnd = user32.FindWindow(null, "Безымянный - Paint");

        if (hwnd != null) {
            // Если окно найдено, ставим фокус
            user32.SetForegroundWindow(hwnd);
            System.out.println("Окно Paint уже открыто. Фокус установлен.");
        } else {
            // Если окно не найдено, запускаем mspaint
            try {
                Runtime.getRuntime().exec("C:\\Windows\\System32\\mspaint.exe");
                System.out.println("Запускаем Paint.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
