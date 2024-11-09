package dpa.helper.korova_image.window;

import dpa.helper.korova_image.proj_utils.SomeUsefulMethods;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotAndCrop {

    public static void takeScreenshotAndCrop(String outputFilePath, WindowParams windowParams) throws IOException, AWTException {

        String pathToScreencrops = SomeUsefulMethods.getRelativePathToFolderInResources("screencrops");

        System.out.println(pathToScreencrops);

        String resultPath = pathToScreencrops.concat(outputFilePath);

        // Снимаем скриншот
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenImage = robot.createScreenCapture(screenRect);

        // Вырезаем прямоугольник из скриншота
        BufferedImage croppedImage = screenImage.getSubimage(
                windowParams.getX(), windowParams.getY(), windowParams.getWidth(), windowParams.getHeight());

        // Сохраняем вырезанную часть в файл
        ImageIO.write(croppedImage, "png", new File(resultPath));
        System.out.println("Скриншот успешно сохранен в " + outputFilePath);
    }
}
