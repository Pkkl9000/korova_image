package dpa.helper.korova_image.thread_dispatching;

import java.util.HashMap;
import java.util.Map;

public class ActionStorage {
    // Статическая переменная для хранения единственного экземпляра
    private static ActionStorage instance;

    // HashMap для хранения данных
    private Map<String, String> map;

    // Приватный конструктор для предотвращения создания экземпляров извне
    private ActionStorage() {
        map = new HashMap<>();
    }

    // Метод для получения единственного экземпляра
    public static ActionStorage getInstance() {
        if (instance == null) {
            instance = new ActionStorage();
        }
        return instance;
    }

    // Метод для получения мапы
    public Map<String, String> getMap() {
        return map;
    }

    // Метод для добавления записи в мапу
    public void addEntry(String key, String value) {
        map.put(key, value);
    }

    // Метод для получения значения по ключу
    public String getValue(String key) {
        return map.get(key);
    }
}
