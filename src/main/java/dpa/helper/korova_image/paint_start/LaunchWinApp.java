package dpa.helper.korova_image.paint_start;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.awt.*;
import java.io.File;

public class LaunchWinApp {

        public static void startCalc() {
        try {
            String calcProcessName = "Calculator"; // Имя процесса для калькулятора
            WinDef.HWND hWnd = findWindow(calcProcessName);

            if (hWnd != null) {
                // Если окно найдено, активируем его
                User32.INSTANCE.SetForegroundWindow(hWnd);
            } else {
                // Если окно не найдено, открываем калькулятор
                File calc = new File("C:\\Windows\\System32\\calc.exe");
                Desktop.getDesktop().open(calc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static WinDef.HWND findWindow(String title) {
        WinDef.HWND hWnd = User32.INSTANCE.FindWindow(null, title);
        return hWnd;
    }






//    public static void check() {
//        if (isCalcOpen()) {
//            System.out.println("Калькулятор уже открыт.");
//        } else {
//            System.out.println("Калькулятор не открыт.");
//        }
//    }
//
//    public static boolean isCalcOpen() {
//        return ProcessHandle.allProcesses()
//                .filter(ph -> ph.info().command().isPresent() &&
//                        ph.info().command().get().endsWith("calc.exe"))
//                .findAny()
//                .isPresent();
//    }
//
//    public static void startCalc() {
//        try {
//            String calcPath = "C:\\Windows\\System32\\calc.exe";
//            ProcessHandle.allProcesses()
//                    .filter(ph -> ph.info().command().isPresent() &&
//                            ph.info().command().get().contains(calcPath))
//                    .findAny()
//                    .ifPresentOrElse(
//                            ph -> {
//                                // Если калькулятор уже запущен, активируем его
//                                try {
//                                    // Используем Windows API для активации окна
//                                    String command = "cmd /c nircmd win activate ititle \"Calculator\"";
//                                    Runtime.getRuntime().exec(command);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            },
//                            () -> {
//                                // Если калькулятор не запущен, открываем его
//                                try {
//                                    File calc = new File(calcPath);
//                                    Desktop.getDesktop().open(calc);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                    );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



//    public static void startPaint() {
//        try {
////            File paint = new File("C:\\Windows\\System32\\mspaint.exe");
//            File calc = new File("C:\\Windows\\System32\\calc.exe");
//            Desktop.getDesktop().open(calc);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
