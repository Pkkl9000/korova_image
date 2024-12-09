package dpa.helper.korova_image;

import dpa.helper.korova_image.actions.StartAreaByKey;
import dpa.helper.korova_image.console_scan.ConsoleEventListener;
import dpa.helper.korova_image.mouse_key_hook.KeyboardHooking;
import dpa.helper.korova_image.mouse_key_hook.MouseHooking;
import dpa.helper.korova_image.mouse_key_tracking.*;
import dpa.helper.korova_image.paint_start.LaunchPaint;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

//  http://localhost:8082/h2-console
    @Override
    public void run(ApplicationArguments args) throws IOException {

        System.setProperty("java.awt.headless", "false");

//        DoRequest.connectAndRequest(JsonRequestConstruct.makeJson("hi!"));

//        SimpleResponseSender sender = new SimpleResponseSender();
//        SimpleResponse response = new SimpleResponse("Hi!");
//        String result = sender.send(response);
//        System.out.println(result);

//        WindowManager.robotKeyMinimize();

//        LaunchPaint.launch();

//        ConsoleEventListener.processConsoleInput();

//        MouseEventListener.startMouseListener(2, GlobalMouseEvent.class);

//        MouseHooking2.registerMouseListener();

//        MouseEventListener.startMouseListener(2, GlobalMouseEvent.class);

//        MouseHooking.MouseListener(eventTracker);

//        getCountedMouseEvents(2);

//        ConsoleEventListener.processConsoleInput();

//        MethodGroupBuilder methodBuilder = new MethodGroupBuilder();
//
//        // Добавляем микрометоды
//        methodBuilder.addMicroMethod(new PrintHello());
//        methodBuilder.addMicroMethod(new PrintWorld());
//        methodBuilder.addMicroMethod(new AddNumbers(5, 10));
//
//        // Выполняем все собранные микрометоды
//        methodBuilder.executeAll();



        LaunchPaint.launch();

//        ConsoleEventListener.processConsoleInput();

//        doCountedKeyboardEvents(1);

        StartAreaByKey.makeAreaActionByKey();

        //  нужен метод getCountedAction(type, count)




    }

    private void doCountedMouseEvents(int count) {

        EventTrackerReactive eventTracker = new EventTrackerReactive();

        MouseHooking.MouseListener(eventTracker);
        eventTracker.countFixedMouseEvents(count);
    }

    private void doCountedKeyboardEvents(int count) {

        EventTrackerReactive eventTracker = new EventTrackerReactive();

        KeyboardHooking.keyboardListener(eventTracker);
        Mono<List<GlobalKeyEvent>> result = eventTracker.countFixedKeyboardEvents(count);
    }
}

