package dpa.helper.korova_image;

import dpa.helper.korova_image.mouse_key_hook.MouseEventHandler;
import dpa.helper.korova_image.paint_start.LaunchPaint;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import dpa.helper.korova_image.gpt_api.DoRequest;

import java.io.IOException;
import java.util.Scanner;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final MouseEventHandler handler = new MouseEventHandler();

    @Override
    public void run(ApplicationArguments args) throws IOException, InterruptedException {

//        DoRequest.connectAndRequest(JsonImageConstruct.createJsonObject("What is this picture?", "example0.jpg"));

      //  LaunchPaint.launch();

        listenForCommands();
    }


    // Метод для ожидания команд   + "\n"
    public static void listenForCommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду (введите 'ex' для выхода):");

        while (true) {
            String command = scanner.nextLine(); // Чтение команды от пользователя

            if (command.equalsIgnoreCase("ex")) {
                System.out.println("Выход из программы.");
                break; // Завершение цикла при вводе 'exit'
            }

            // Отправка команды в другой метод для обработки
            String response = processCommand(command);
            // Выводим ответ на консоль
            System.out.println("Ответ: " + response);
        }

        scanner.close();
    }

    // Метод для обработки команды
    public static String processCommand(String command) {
        // Здесь можно добавить логику обработки команды
        // Пример: выполнение команды или вызов других методов
        return "Команда '" + command + "' успешно обработана."; // Возвращаем ответ
    }

}

