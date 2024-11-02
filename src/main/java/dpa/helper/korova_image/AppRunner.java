package dpa.helper.korova_image;

//import dpa.helper.korova_image.event_reactor.EventGenerator;
import dpa.helper.korova_image.gpt_api.JsonRequestConstruct;
import dpa.helper.korova_image.mouse_key_hook.MouseEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import dpa.helper.korova_image.gpt_api.DoRequest;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final MouseEventHandler handler = new MouseEventHandler();

    @Override
    public void run(ApplicationArguments args) throws IOException, InterruptedException {


        System.out.println(JsonRequestConstruct.sdfage("Tell me another joke about cats"));

//        new asbshbDoRequest.connectAndRequest("Tell me another joke about cats");

        DoRequest.connectAndRequest("Tell me another joke about cats");


//        new RequestGpt().doRequest();


//        eventListener работает
//        MouseAndKeyboardHooking.MouseListener();
//        eventListener работает

    }
}

