package dpa.helper.korova_image.gpt_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

//private static final String apiKey = "AIzaSyDOKCyDSmbUOU4kI-BufpNL9okIS3r7MRo";
//private final String endPointUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey;

public class SimpleResponseSender {
    private static final String apiKey = "AIzaSyDOKCyDSmbUOU4kI-BufpNL9okIS3r7MRo";
    private static final String endPointUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey;

//    public SimpleResponseSender(String url) {
//        this.url = url;
//    }

    public String send(SimpleResponse responseObject) {
        StringBuilder responseBody = new StringBuilder();
        try {
            // Создание URL и открытие соединения
            URL urlObj = new URL(endPointUrl);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Отправка данных
            try (OutputStream os = connection.getOutputStream()) {
                os.write(responseObject.toJson().getBytes("utf-8"));
            }

            // Получение ответа
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Чтение тела ответа
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    String responseLine;
                    while ((responseLine = reader.readLine()) != null) {
                        responseBody.append(responseLine.trim());
                    }
                }
                return responseBody.toString(); // Возвращаем тело ответа
            } else {
                return "Failed to send response. Code: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    // Пример использования
//    public static void main(String[] args) {
//        SimpleResponseSender sender = new SimpleResponseSender();
//        SimpleResponse response = new SimpleResponse("Whats the weather in Sydney?");
//        String result = sender.send(response);
//        System.out.println(result);
//    }
}