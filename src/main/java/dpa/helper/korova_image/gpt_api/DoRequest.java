package dpa.helper.korova_image.gpt_api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DoRequest {

    private static final String apiKey = "AIzaSyDOKCyDSmbUOU4kI-BufpNL9okIS3r7MRo";
    private static final String endPointUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey;


    public static void connectAndRequest(JsonObject jsonObject) throws IOException {

        URL url = new URL(endPointUrl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(jsonObject.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            //System.out.println(response.toString());

            String  json = response.toString();
            JsonObject jsonObjectForParsing = JsonParser.parseString(json).getAsJsonObject();
            JsonArray candidatesArray = jsonObjectForParsing.getAsJsonArray("candidates");
            for (JsonElement candidateElement : candidatesArray) {
                JsonObject candidateObject = candidateElement.getAsJsonObject();
                JsonObject contentObject = candidateObject.getAsJsonObject("content");
                JsonArray partsArray = contentObject.getAsJsonArray("parts");
                for (JsonElement partElement : partsArray) {
                    JsonObject partObject = partElement.getAsJsonObject();
                    String text = partObject.get("text").getAsString();
                    System.out.println("\n Text: " + text+"\n");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
