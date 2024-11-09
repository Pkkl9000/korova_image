package dpa.helper.korova_image.img_process;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Getter
public class ImageComparator {

    private int maxX;
    private int maxY;
    public void anotherMethod(String fileName0, String fileName1) {

        ArrayList<RgbPixel> rgbsDiff = new ArrayList<>();

        try {
            // Load two images to compare
            BufferedImage image0 = ImageIO.read(new File(Utils.getPathToImageFile(fileName0)));
            BufferedImage image1 = ImageIO.read(new File(Utils.getPathToImageFile(fileName1)));

            // Get the dimensions of the images
            int width = image0.getWidth();
            int height = image0.getHeight();

            // Create a new image to store the result of comparison
            BufferedImage diffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Compare the pixel values of the two images
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb1 = image0.getRGB(x, y);
                    int rgb2 = image1.getRGB(x, y);

                    // If the pixel values are the same, set the pixel value of diffImage to white, otherwise set it to black
                    if (rgb1 != rgb2) {
//                        diffImage.setRGB(x, y, rgb2); // white
                        rgbsDiff.add(new RgbPixel(x, y, rgb2));
                    } else {
                        rgbsDiff.add(new RgbPixel(x, y, 0xFFFFFF));
                    }
                }
            }

            findMaxXY(rgbsDiff);

            createImageFromRgbs(rgbsDiff);

            // Save the new image
            ImageIO.write(diffImage, "jpg", new File("diffImage11.jpg"));

            System.out.println("Images compared successfully and new image created.");

        } catch (IOException e) {
            System.out.println("An error occurred while comparing images: " + e.getMessage());
        }
    }

    private void findMaxXY(ArrayList<RgbPixel> rgbsDiff) {

        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;

        // Поиск максимальных значений x и y
        for (RgbPixel pixel : rgbsDiff) {
            if (pixel.getX() > maxX) {
                maxX = pixel.getX();
            }
            if (pixel.getY() > maxY) {
                maxY = pixel.getY();
            }
        }

        // Вывод результатов
//        System.out.println("Максимальное x: " + maxX);
//        System.out.println("Максимальное y: " + maxY);
    }

    private void createImageFromRgbs(ArrayList<RgbPixel> rgbsDiff) {

        // Создание изображения
        int width = maxX + 1; // Ширина изображения
        int height = maxY + 1; // Высота изображения

        System.out.println(maxX + " ... " + maxY);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (RgbPixel pixel : rgbsDiff) {
            image.setRGB(pixel.getX(), pixel.getY(), pixel.getRGB());
        }

        // Сохранение изображения (например, в формате PNG)
        try {
            ImageIO.write(image, "png", new File(Utils.getNextNameForDiffFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}