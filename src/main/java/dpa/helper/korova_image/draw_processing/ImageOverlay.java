package dpa.helper.korova_image.draw_processing;

import dpa.helper.korova_image.project_utils.SomeUsefulMethods;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageOverlay {

    public static void main(String[] args) throws IOException {

        String pathToFolder = SomeUsefulMethods.getRelativePathToFolderInResources("screencrops");

        String pathToTarget = pathToFolder.concat("dotOutput.png");

        System.out.println(pathToTarget);

        String pathToAddition = pathToFolder.concat("dot.png");
        // Загружаем основное изображение
        BufferedImage background = ImageIO.read(new File(pathToTarget));

        // Загружаем изображение, которое нужно наложить
        BufferedImage overlay = ImageIO.read(new File(pathToAddition));

        // Проверка размеров изображений
        System.out.println("Размеры фона: " + background.getWidth() + "x" + background.getHeight());
        System.out.println("Размеры оверлея: " + overlay.getWidth() + "x" + overlay.getHeight());

        if (overlay.getWidth() > background.getWidth() || overlay.getHeight() > background.getHeight()) {
            throw new IllegalArgumentException("Малое изображение больше основного!");
        }

        // Создаем графику для рисования
        Graphics2D g = background.createGraphics();

        // Определяем координаты для вставки маленького изображения
        int xOffset = 30; // Левый край
        int yOffset = 30;  // Верхний край

        // Рисуем маленькое изображение поверх большого
        g.drawImage(overlay, xOffset, yOffset, null);

        // Освобождаем ресурсы графики
        g.dispose();

        // Сохраняем результат
        ImageIO.write(background, "png", new File(pathToFolder.concat("dotOutput.png")));
    }
}
