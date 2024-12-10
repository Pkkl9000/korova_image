package dpa.helper.korova_image.draw_processing;

import dpa.helper.korova_image.project_utils.SomeUsefulMethods;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class AreaExtractor {
    public static void main(String[] args) {

        OpenCV.loadLocally();

        // Путь к исходному изображению
        String pathToFolder = SomeUsefulMethods.getRelativePathToFolderInResources("screencrops");

        String pathToFile = pathToFolder.concat("dotSource0.png");

        // Загрузка изображения
        Mat image = Imgcodecs.imread(pathToFile);

        if (image.empty()) {
            System.out.println("Не удалось загрузить изображение");
            return;
        }

        // Преобразование изображения в серую шкалу
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        // Установка порога для выделения областей
        int threshold = 254; // Все пиксели, отличные от почти белого (255)

        // Применение бинаризации для получения маски
        Mat mask = new Mat();
        Imgproc.threshold(grayImage, mask, threshold, 255, Imgproc.THRESH_BINARY_INV);

        // Поиск контуров
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(mask, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        // Находим наибольший контур
        double maxContourArea = 0;
        MatOfPoint largestContour = null;
        for (MatOfPoint contour : contours) {
            double area = Imgproc.contourArea(contour);
            if (area > maxContourArea) {
                maxContourArea = area;
                largestContour = contour;
            }
        }

        // Если найдена область, создаём новую матрицу с её размерами
        if (largestContour != null) {
            Rect boundingRect = Imgproc.boundingRect(largestContour);
            Mat croppedImage = new Mat(image, boundingRect);

            // Создаём новое изображение с альфа-каналом (RGBA)
            Mat rgbaImage = new Mat(croppedImage.rows(), croppedImage.cols(), croppedImage.type(), new Scalar(0, 0, 0, 0));

            // Копируем найденную область в новое изображение
            croppedImage.copyTo(rgbaImage, mask.submat(boundingRect));

            // Сохраняем результат
            Imgcodecs.imwrite(pathToFolder.concat("dot.png"), rgbaImage);

            System.out.println("Область небелого цвета успешно сохранена в файл 'dot.png'.");
        } else {
            System.out.println("Не найдено подходящих областей.");
        }
    }
}