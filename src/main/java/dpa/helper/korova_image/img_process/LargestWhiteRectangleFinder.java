package dpa.helper.korova_image.img_process;

import dpa.helper.korova_image.project_utils.SomeUsefulMethods;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LargestWhiteRectangleFinder {

    private static final int TOLERANCE = 5;

    public static void main(String[] args) {

        String pathToFolder = SomeUsefulMethods.getRelativePathToFolderInResources("screenshots");

        try {
            BufferedImage image = ImageIO.read(new File(pathToFolder + "example0.png"));
            Rectangle largestRectangle = findLargestWhiteRectangle(image);
            if (largestRectangle != null) {
                System.out.println("Координаты верхнего левого угла: (" + largestRectangle.x + ", " + largestRectangle.y + ")");
                System.out.println("Ширина: " + largestRectangle.width);
                System.out.println("Высота: " + largestRectangle.height);
            } else {
                System.out.println("Белые прямоугольники не найдены.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для поиска самого большого белого прямоугольника
    private static Rectangle findLargestWhiteRectangle(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Rectangle largestRectangle = null;

        boolean[][] visited = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!visited[y][x] && isColorWhite(image.getRGB(x, y))) {
                    // Найти границы белого прямоугольника
                    int rectWidth = 0;
                    int rectHeight = 0;

                    // Определяем ширину
                    while (x + rectWidth < width && isColorWhite(image.getRGB(x + rectWidth, y))) {
                        rectWidth++;
                    }

                    // Определяем высоту
                    boolean validRectangle = true;
                    for (int h = 0; h < rectWidth; h++) {
                        int tempHeight = 0;
                        while (y + tempHeight < height && isColorWhite(image.getRGB(x + h, y + tempHeight))) {
                            tempHeight++;
                        }
                        rectHeight = Math.max(rectHeight, tempHeight);
                        if (tempHeight < rectHeight) {
                            validRectangle = false;
                            break;
                        }
                    }

                    // Проверяем, является ли текущий прямоугольник самым большим
                    if (validRectangle) {
                        for (int i = 0; i < rectHeight; i++) {
                            for (int j = 0; j < rectWidth; j++) {
                                visited[y + i][x + j] = true; // Помечаем пиксели как посещенные
                            }
                        }

                        Rectangle currentRectangle = new Rectangle(x, y, rectWidth, rectHeight);
                        if (largestRectangle == null || (currentRectangle.width * currentRectangle.height > largestRectangle.width * largestRectangle.height)) {
                            largestRectangle = currentRectangle;
                        }
                    }
                }
            }
        }

        return largestRectangle;
    }

    // Метод для проверки, является ли цвет белым с учетом толерантности
    private static boolean isColorWhite(int rgb) {
        Color color = new Color(rgb);
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int whiteThreshold = 255 - TOLERANCE;
        return r > whiteThreshold && g > whiteThreshold && b > whiteThreshold;
    }

    // Класс для хранения координат и размеров прямоугольника
    private static class Rectangle {
        int x, y, width, height;

        Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}
