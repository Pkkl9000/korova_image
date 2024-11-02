package dpa.helper.korova_image.gpt_api.json_extraction;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JsonExtractor {
    public static void main(String[] args) {
        String jsonResponse = "{\"id\":\"chatcmpl-M8Gqe49HtISWBTUuc4Lt7\",\"object\":\"chat.completion\",\"created\":1730015361,\"model\":\"gpt-3.5-turbo\",\"choices\":[{\"index\":0,\"message\":{\"role\":\"assistant\",\"content\":\"You can use the addition operator (+) in Java to add 2 to 3. Here's an example snippet of code:\\n\\nint result = 2 + 3;\\nSystem.out.println(\\\"The result is: \\\" + result);\\n\\nThis will output \\\"The result is: 5\\\" to the console..\"}}],\"usage\":{\"prompt_tokens\":31,\"completion_tokens\":66,\"total_tokens\":97}}";

        // Parse JSON
        JSONObject jsonObject = new JSONObject(jsonResponse);
        String content = jsonObject.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");

        // Write content to file
        writeToFile(content, "output.txt");
    }

    private static void writeToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content successfully written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
