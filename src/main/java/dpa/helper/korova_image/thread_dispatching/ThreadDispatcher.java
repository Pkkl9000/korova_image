package dpa.helper.korova_image.thread_dispatching;

public class ThreadDispatcher {
    public static void dispatcher(String[] args) {
        ThreadListenerAndCounter dispatcher = new ThreadListenerAndCounter();

        // Создание событий
        EventB eventB = new EventB();
        EventC eventC = new EventC();

        // Обработка событий
        dispatcher.handleEventB(eventB);
        dispatcher.handleEventC(eventC);
        dispatcher.handleEventB(eventB);

        // Получение количества вызовов
        System.out.println("Количество вызовов для EventB: " + dispatcher.getEventCount("EventB"));
        System.out.println("Количество вызовов для EventC: " + dispatcher.getEventCount("EventC"));

        // Остановка обработки событий
        dispatcher.setMouseRun(false);
        dispatcher.handleEventB(eventB); // Не будет обработано
        dispatcher.handleEventC(eventC); // Не будет обработано

        // Количество вызовов остается прежним
        System.out.println("Количество вызовов для EventB: " + dispatcher.getEventCount("EventB"));
        System.out.println("Количество вызовов для EventC: " + dispatcher.getEventCount("EventC"));
    }
}