//package dpa.helper.korova_image.console_scan;
//
//import dpa.helper.korova_image.console_scan.utils.Command;
//import dpa.helper.korova_image.console_scan.utils.SharedList;
//
//import java.util.concurrent.BlockingQueue;
//
//public class ConsoleInputDispatcher implements Runnable {
//
//    private final SharedList sharedList;
//    private final BlockingQueue<Command> queue;
//
//    public ConsoleInputDispatcher(SharedList sharedList, BlockingQueue<Command> queue) {
//        this.sharedList = sharedList;
//        this.queue = queue;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                Command command = queue.take();
//                String action = command.action();
//                if ("DONE".equals(action)) {
//                    System.out.println("Потребитель завершил работу.");
//                    break;
//                }
//                System.out.println("Consumed: " + sharedList);
//                System.out.println("here we start sugg: " + action);
//            }
//
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}
