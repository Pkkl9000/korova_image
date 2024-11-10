package dpa.helper.korova_image.gpt_api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dpa.helper.korova_image.project_utils.SomeUsefulMethods;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class JsonImageConstruct {

    public static JsonObject createJsonObject(String question, String fileName) {

        String pathToImages = SomeUsefulMethods.getRelativePathToFolderInResources("images");
        String imagePath = pathToImages.concat(fileName);

        // Читаем файл изображения и кодируем его в Base64
        String base64Image = encodeImageToBase64(imagePath);

        // Создаем JSON-структуру
        JsonObject jsonObject = new JsonObject();
        JsonArray contentsArray = new JsonArray();
        JsonObject partsObject = new JsonObject();
        JsonArray partsArray = new JsonArray();

        // Добавляем текст
        JsonObject textObject = new JsonObject();
        textObject.addProperty("text", question);
        partsArray.add(textObject);

        // Добавляем данные изображения
        JsonObject inlineDataObject = new JsonObject();
        inlineDataObject.addProperty("mime_type", "image/jpeg");
        inlineDataObject.addProperty("data", base64Image);

        JsonObject inlineDataWrapper = new JsonObject();
        inlineDataWrapper.add("inline_data", inlineDataObject);
        partsArray.add(inlineDataWrapper);

        // Добавляем parts в основной объект
        partsObject.add("parts", partsArray);
        contentsArray.add(partsObject);
        jsonObject.add("contents", contentsArray);

        return jsonObject;
    }

    private static String encodeImageToBase64(String imagePath) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(imagePath));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}