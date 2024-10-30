package dpa.helper.korova_image;

import dpa.helper.korova_image.command_pattern.MethodCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

//    private final MyService myService;
//    SharedList sharedList = new SharedList();
//    BlockingQueue<Command> queue = new LinkedBlockingQueue<>();
//
//    BrowserService browserService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        new MethodCaller().callMethod("sign");



//        OpenExample openExample = new OpenExample();
//        openExample.openPage();

//        browserService.interactWithApp();





//        System.out.println("Приложение запущено с аргументами: ");
//        for (String name : args.getOptionNames()) {
//            System.out.println(name + ": " + args.getOptionValues(name));
//        }

//        myService.myMethod("myService started", 42);

//        InputReadRunner.startReading();



//// +++++++++++++++++
//
//        ThreadStartObserver observer = new ThreadStartObserver();
//        ExampleThread exampleThread = new ExampleThread(observer);
//
//        Thread thread = new Thread(exampleThread);
//        thread.start();
//
//        Thread reader = new Thread(new ConsoleReader(sharedList, queue));
//        Thread dispatcher = new Thread(new ConsoleInputDispatcher(sharedList, queue));
//
//        reader.start();
//        dispatcher.start();
//
//        // +++++++++++++++++

//        System.out.println(MethodInspector.getMethodsInfo("dpa.helper.sugg0.action_box"));

    }
}




//@Component
//public class AppRunner implements CommandLineRunner {
//
//    private final MyService myService;
//
//    public AppRunner(MyService myService) {
//        this.myService = myService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        myService.myMethod("Hello, World!", 42);
//    }
//}
