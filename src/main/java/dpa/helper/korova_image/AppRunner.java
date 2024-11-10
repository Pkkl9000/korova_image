package dpa.helper.korova_image;

import dpa.helper.korova_image.mouse_key_hook.MouseEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final MouseEventHandler handler = new MouseEventHandler();

    @Override
    public void run(ApplicationArguments args) throws IOException {

        System.setProperty("java.awt.headless", "false");
    }
}

