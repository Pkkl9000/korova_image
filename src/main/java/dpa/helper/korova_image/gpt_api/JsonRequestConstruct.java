package dpa.helper.korova_image.gpt_api;

import com.google.gson.JsonObject;

public class JsonRequestConstruct {

    public static JsonObject sdfage(String input) {
        JsonObject requestJson = new JsonObject();
        JsonObject userPart = new JsonObject();
        userPart.addProperty("text", input);

        JsonObject userContent = new JsonObject();
        userContent.addProperty("role", "user");
        userContent.add("parts", userPart);

        requestJson.add("contents", userContent);
        JsonObject generationConfig = new JsonObject();
        generationConfig.addProperty("temperature", 1);
        generationConfig.addProperty("topK", 0);
        generationConfig.addProperty("topP", 0.95);
        generationConfig.addProperty("maxOutputTokens", 8192);
        generationConfig.addProperty("stopSequences", "");

        requestJson.add("generationConfig", generationConfig);

        JsonObject safetySettings = new JsonObject();
        safetySettings.addProperty("category", "HARM_CATEGORY_HARASSMENT");
        safetySettings.addProperty("threshold", "BLOCK_MEDIUM_AND_ABOVE");
        requestJson.add("safetySettings", safetySettings);

        return requestJson;
    }
}
