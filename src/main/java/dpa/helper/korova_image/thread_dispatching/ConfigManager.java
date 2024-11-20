package dpa.helper.korova_image.thread_dispatching;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class ConfigManager {
    public boolean runMethodA = true;
    public boolean runMethodB = true;
    public boolean runMethodC = true;

    public static void main(String[] args) {
        ConfigManager configManager = new ConfigManager();

        // Создание конфигурационного файла
        String configFilename = "config.json";
        configManager.createConfig(configFilename);

        // Загрузка конфигурации из файла
        configManager.loadConfig(configFilename);

        // Проверка работы методов после загрузки конфигурации
        configManager.methodA(); // Метод A остановлен
        configManager.methodB(); // Метод B выполняется
        configManager.methodC(); // Метод C остановлен
    }

    public void loadConfig(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Config config = objectMapper.readValue(new File(filename), Config.class);
            runMethodA = config.methodA;
            runMethodB = config.methodB;
            runMethodC = config.methodC;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createConfig(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        Config config = new Config();
        config.methodA = false; // Установите необходимые значения
        config.methodB = true;
        config.methodC = false;

        try {
            objectMapper.writeValue(new FileWriter(filename), config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void methodA() {
        if (runMethodA) {
            System.out.println("Метод A выполняется");
        } else {
            System.out.println("Метод A остановлен");
        }
    }

    public void methodB() {
        if (runMethodB) {
            System.out.println("Метод B выполняется");
        } else {
            System.out.println("Метод B остановлен");
        }
    }

    public void methodC() {
        if (runMethodC) {
            System.out.println("Метод C выполняется");
        } else {
            System.out.println("Метод C остановлен");
        }
    }

    private static class Config {
        public boolean methodA;
        public boolean methodB;
        public boolean methodC;
    }
}
