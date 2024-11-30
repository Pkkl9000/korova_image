package dpa.helper.korova_image.img_process;

import dpa.helper.korova_image.project_utils.SomeUsefulMethods;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

///**
// * Делает часть скриншота по заданным параметрам.
// *
// * @param x      координата X верхнего левого угла области скриншота
// * @param y      координата Y верхнего левого угла области скриншота
// * @param width  ширина области скриншота
// * @param height высота области скриншота
// * @param file   файл, в который будет сохранен скриншот
// * @throws AWTException если не удается создать скриншот
// * @throws Exception    если происходит ошибка при сохранении изображения
// */
public class PartialScreenshot {

    private static final String screensFolderName = "area_screens";


    public static void takePartialScreenshot(int x, int y, int width, int height) throws AWTException, Exception {

        File filePath = new File(getNextNameForAreaFile());

        // Получаем объект Robot для создания скриншота
        Robot robot = new Robot();

        // Создаем прямоугольник для области скриншота
        Rectangle screenRect = new Rectangle(x, y, width, height);

        // Делаем скриншот
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

        // Сохраняем скриншот в файл
        ImageIO.write(screenFullImage, "png", filePath);
        System.out.println("Скриншот сохранен: " + filePath);
    }

    public static void main(String[] args) {
        try {
            // Пример использования метода
            takePartialScreenshot(100, 100, 400, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void getScreenPath() {
//        String pathToScreens = SomeUsefulMethods.getRelativePathToFolderInResources(screensFolderName);
//
//        return pathToImageSource.concat(filename).concat(".png");
//    }

    public static String getNextNameForAreaFile() {

        String folderName = screensFolderName;

        String newFileName = SomeUsefulMethods
                .getRelativePathToFolderInResources(folderName)
                .concat("screenpart")
                .concat(String.valueOf(ImageUtils.getFilesNumber(folderName)))
                .concat(".png");

        return newFileName;
    }


}