package dpa.helper.korova_image.thread_dispatching;

public class MethodSwitcher {
    public static void switcher(String[] args) {
        MethodRuler methodRuler = new MethodRuler();

        // Проверка работы методов до изменения состояния
        methodRuler.methodA(); // Метод A выполняется
        methodRuler.methodB(); // Метод B выполняется
        methodRuler.methodC(); // Метод C выполняется

        // Установка значений run
        methodRuler.setRun("methodA", false);
        methodRuler.setRun("methodB", true);
        methodRuler.setRun("methodC", false);

        // Проверка работы методов после изменения состояния
        methodRuler.methodA(); // Метод A остановлен
        methodRuler.methodB(); // Метод B выполняется
        methodRuler.methodC(); // Метод C остановлен
    }
}
