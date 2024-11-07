package dpa.helper.korova_image.console_scan;

import dpa.helper.korova_image.console_scan.utils.Command;
//import dpa.helper.korova_image.console_scan.utils.SharedList;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

@NoArgsConstructor(force = true)
public class ConsoleReader implements Runnable {

//    private final SharedList sharedList;
//    private final BlockingQueue<Command> queue;

    private final List<String> tempList = new ArrayList<>();

//    public ConsoleReader(SharedList sharedList, BlockingQueue<Command> queue) {
//        this.sharedList = sharedList;
//        this.queue = queue;
//    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hi. in?");

        while (true) {
            String userInput = scanner.nextLine();

            if ("ex".equalsIgnoreCase(userInput)) {
                System.out.println("Выход из программы.");
//                Command exit = new Command("DONE");
                System.exit(0);
            }

//            String result = scanner.nextLine();

            inputTokenizer(userInput);

            System.out.println(tempList);

//            Command command = new Command(result);

//            try {
//                queue.put(command);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Производитель отправил: " + command.getAction());
        }

//        scanner.close();
    }

    private void inputTokenizer(String input) {

        String[] splitTokens = input.split(" ");

        for (String token : splitTokens) {
            if (!token.isEmpty()) {
                tempList.add(token);
            }
        }
    }
}
