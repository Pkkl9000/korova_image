package dpa.helper.korova_image;

import dpa.helper.korova_image.img_process.ImageComparator;
import dpa.helper.korova_image.mouse_key_hook.MouseEventHandler;
import dpa.helper.korova_image.proj_utils.SomeUsefulMethods;
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

//        LaunchPaint.launch();
//
//        WindowParams windowParams = ActiveWindowCoordinates.getCoordsAndDimensions();
//
//        if (windowParams == null) {
//            throw new NullPointerException("windowParams is null");
//        }
//
//        try {
//            System.setProperty("java.awt.headless", "false");
//            ScreenshotAndCrop.takeScreenshotAndCrop("qqqfhgr", windowParams);
//        } catch (AWTException e) {
//            throw new RuntimeException(e);
//        }

//        Screenshot.makeScreenshot("example1");

        String q0 = SomeUsefulMethods
                .getRelativePathToFolderInResources("screenshots")
                .concat("example0.png");
        String q1 = SomeUsefulMethods
                .getRelativePathToFolderInResources("screenshots")
                .concat("example1.png");
//        ImageDifference.tryIt(q0, q1);


        ImageComparator imageComparator = new ImageComparator();
        imageComparator.anotherMethod("example0", "example1");



    }
}

