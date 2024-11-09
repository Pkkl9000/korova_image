package dpa.helper.korova_image.img_process;

import dpa.helper.korova_image.proj_utils.SomeUsefulMethods;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Screenshot {

    public static void makeScreenshot(String screenshotName) {
        try {
            Robot robot = new Robot();

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            BufferedImage screenImage = robot.createScreenCapture(screenRect);

            String targetName = SomeUsefulMethods.getRelativePathToFolderInResources(
                    "screenshots").concat(screenshotName).concat(".png");

            ImageIO.write(screenImage, "png", new File(targetName));

            System.out.println("Скриншот сохранен в '" + screenshotName + ".png'.");

        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}