//package dpa.helper.korova_image.console_scan.utils;
//
//import lombok.Getter;
//import lombok.ToString;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@ToString
//public class SharedList {
//    private final List<String> list = new ArrayList<>();
//
//    public synchronized void add(String item) {
//        list.add(item);
//        System.out.println("Added: " + item);
//        notify(); // Уведомляем потребителя
//    }
//
//    public synchronized String remove() {
//        while (list.isEmpty()) {
//            try {
//                wait(); // Ожидаем, пока производитель добавит элементы
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
////        return list.remove(0);
//        return "";
//    }
//}