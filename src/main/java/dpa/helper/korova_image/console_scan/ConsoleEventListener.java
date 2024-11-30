package dpa.helper.korova_image.console_scan;

import dpa.helper.korova_image.actions.StartArea;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Scanner;

public class ConsoleEventListener {
    public static void processConsoleInput() {
        // Создаем поток для слушания событий из консоли
        Flux<String> commandStream = Flux.<String>create(sink -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String command = scanner.nextLine();
                sink.next(command);
            }
        }).subscribeOn(Schedulers.boundedElastic());

        // Обрабатываем команды
        commandStream.subscribe(command -> {
            switch (command = command.toLowerCase()) {
                case "start" -> startAction();
                case "makearea" -> StartArea.makeAreaAction();
                case "mkar" -> StartArea.makeAreaAction();
                case "stop" -> stopAction();
                case "exit" -> exitAction();
                default -> System.out.println("Неизвестная команда: " + command);
            }
        });

        // Чтобы приложение не завершалось сразу
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void startAction() {
        System.out.println("Действие 'Start' выполнено.");
    }

    private static void stopAction() {
        System.out.println("Действие 'Stop' выполнено.");
    }

    private static void exitAction() {
        System.out.println("Выход из приложения.");
        System.exit(0);
    }
}
