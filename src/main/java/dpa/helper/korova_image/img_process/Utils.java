package dpa.helper.korova_image.img_process;

import dpa.helper.korova_image.project_utils.SomeUsefulMethods;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

    public static int getFilesNumber(String folderName) {

        String directoryPath = SomeUsefulMethods.getRelativePathToFolderInResources(folderName);
        File directory = new File(directoryPath);

        // Проверяем, является ли путь директорией
        if (directory.isDirectory()) {
            // Получаем список файлов в директории
            File[] files = directory.listFiles();
            if (files != null) {
                return files.length;
            }
        }
        return 0;
    }

    public static String getNextNameForDiffFile() {

        String diffFolderName = "diffs";

        String newFileName = SomeUsefulMethods
                .getRelativePathToFolderInResources(diffFolderName)
                .concat("diffImage")
                .concat(String.valueOf(getFilesNumber(diffFolderName)))
                .concat(".png");

        return newFileName;
    }

    public static String getPathToImageFile(String filename) {

        String pathToImageSource = SomeUsefulMethods
                .getRelativePathToFolderInResources("screenshots");

        return pathToImageSource.concat(filename).concat(".png");
    }

    public static void cropImage(String outputFileName, BufferedImage inputImage, SubImageParams subImageParams) {

        String pathToScreencrops = SomeUsefulMethods.getRelativePathToFolderInResources("screencrops");

        String resultPath = pathToScreencrops.concat(outputFileName).concat(".png");

        // Вырезаем прямоугольник из скриншота
        BufferedImage croppedImage = inputImage.getSubimage(
                subImageParams.getX(), subImageParams.getY(), subImageParams.getWidth(), subImageParams.getHeight());

        // Сохраняем вырезанную часть в файл
        try {
            ImageIO.write(croppedImage, "png", new File(resultPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Скриншот успешно сохранен в " + outputFileName + ".png");
    }
}