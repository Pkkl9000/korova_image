package dpa.helper.korova_image;

import dpa.helper.korova_image.mouse_key_hook.MouseEventHandler;
import dpa.helper.korova_image.paint_start.LaunchPaint;
import dpa.helper.korova_image.window.ActiveWindowCoordinates;
import dpa.helper.korova_image.window.ScreenshotAndCrop;
import dpa.helper.korova_image.window.WindowParams;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;


@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final MouseEventHandler handler = new MouseEventHandler();

    @Override
    public void run(ApplicationArguments args) throws IOException {

        LaunchPaint.launch();

        WindowParams windowParams = ActiveWindowCoordinates.getCoordsAndDimensions();
        assert windowParams != null : "windowParams should not be null";

        try {
            System.setProperty("java.awt.headless", "false");
            ScreenshotAndCrop.takeScreenshotAndCrop("qqqfhgr", windowParams);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


    }
}

