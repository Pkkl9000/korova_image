package dpa.helper.korova_image;

import dpa.helper.korova_image.mouse_key_hook.MouseHooking;
import dpa.helper.korova_image.mouse_key_tracking.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;


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

        getCountedMouseEvents(2);



    }

    private void getCountedMouseEvents(int count) {

        EventTrackerReactive eventTracker = new EventTrackerReactive();

        MouseHooking.MouseListener(eventTracker);
        eventTracker.countFixedMouseEvents(count);
    }
}

