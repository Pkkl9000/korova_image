package dpa.helper.korova_image.thread_dispatching;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager2 {
    public List<ActionConfig> actions = new ArrayList<>();

    public static void main(String[] args) {
        ConfigManager2 myClass = new ConfigManager2();

        // Создание конфигурационного файла
        String configFilename = "config.json";
        myClass.createConfig(configFilename);

        // Загрузка конфигурации из файла
        myClass.loadConfig(configFilename);

        // Выполнение действий на основе загруженной конфигурации
        myClass.executeActions();
    }

    public void loadConfig(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ActionConfig[] actionConfigs = objectMapper.readValue(new File(filename), ActionConfig[].class);
            for (ActionConfig config : actionConfigs) {
                actions.add(config);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createConfig(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Пример набора действий
        ActionConfig[] actionConfigs = {
                new ActionConfig("methodA", true),  // Запуск метода A
                new ActionConfig("eventFromA", false), // Получение события из метода A (позже)
                new ActionConfig("stopMethodA", false), // Остановка метода A
                new ActionConfig("methodB", true),  // Запуск метода B
                new ActionConfig("eventFromB", false), // Получение первого события из метода B (позже)
                new ActionConfig("eventFromB", false), // Получение второго события из метода B (позже)
                new ActionConfig("stopMethodB", false) // Остановка метода B
        };

        try {
            objectMapper.writeValue(new FileWriter(filename), actionConfigs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void executeActions() {
        for (ActionConfig action : actions) {
            switch (action.methodName) {
                case "methodA":
                    if (action.run) methodA();
                    break;
                case "eventFromA":
                    eventFromA();
                    break;
                case "stopMethodA":
                    stopMethodA();
                    break;
                case "methodB":
                    if (action.run) methodB();
                    break;
                case "eventFromB":
                    eventFromB();
                    break;
                case "stopMethodB":
                    stopMethodB();
                    break;
                default:
                    System.out.println("Метод не найден: " + action.methodName);
            }
        }
    }

    public void methodA() {
        System.out.println("Метод A выполняется");
    }

    public void eventFromA() {
        System.out.println("Событие из метода A получено");
    }

    public void stopMethodA() {
        System.out.println("Метод A остановлен");
    }

    public void methodB() {
        System.out.println("Метод B выполняется");
    }

    public void eventFromB() {
        System.out.println("Событие из метода B получено");
    }

    public void stopMethodB() {
        System.out.println("Метод B остановлен");
    }

    // Класс для хранения конфигурации действий
    private static class ActionConfig {
        public String methodName;
        public boolean run;

        public ActionConfig() {}

        public ActionConfig(String methodName, boolean run) {
            this.methodName = methodName;
            this.run = run;
        }
    }
}
