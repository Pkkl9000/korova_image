package dpa.helper.korova_image;

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


    @Override
    public void run(ApplicationArguments args) throws IOException {

        System.setProperty("java.awt.headless", "false");


        MouseHooking.MouseListener();



    }
}

