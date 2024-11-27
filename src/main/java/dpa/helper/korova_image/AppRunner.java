package dpa.helper.korova_image;

import dpa.helper.korova_image.gpt_api.DoRequest;
import dpa.helper.korova_image.gpt_api.JsonRequestConstruct;
import dpa.helper.korova_image.gpt_api.SimpleResponse;
import dpa.helper.korova_image.gpt_api.SimpleResponseSender;
import dpa.helper.korova_image.mouse_key_hook.MouseAndKeyboardEventHandler;
import dpa.helper.korova_image.mouse_key_hook.MouseHooking;
import unused.tracking.some_track.gigarx.EventStream;
import unused.tracking.some_track.gigarx.EventTrackerG;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final MouseAndKeyboardEventHandler eventHandler = new MouseAndKeyboardEventHandler();

//  http://localhost:8082/h2-console
    @Override
    public void run(ApplicationArguments args) throws IOException {

        System.setProperty("java.awt.headless", "false");

//        DoRequest.connectAndRequest(JsonRequestConstruct.makeJson("hi!"));

        SimpleResponseSender sender = new SimpleResponseSender();
        SimpleResponse response = new SimpleResponse("Hi!");
        String result = sender.send(response);
        System.out.println(result);




//        MouseHooking.MouseListener();



    }
}

