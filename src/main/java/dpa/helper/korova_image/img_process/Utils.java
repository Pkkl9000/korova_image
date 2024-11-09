package dpa.helper.korova_image.img_process;

import dpa.helper.korova_image.proj_utils.SomeUsefulMethods;

import java.io.File;

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
}