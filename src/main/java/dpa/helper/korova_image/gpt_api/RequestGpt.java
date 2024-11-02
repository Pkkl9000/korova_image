package dpa.helper.korova_image.gpt_api;

import dpa.helper.korova_image.gpt_api.json_extraction.JsonRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestGpt {

    public void doRequest() throws IOException, InterruptedException {

        GptInputMessage gptInputMessage = new GptInputMessage("something to ask");
//        var apiKey = "sk-b0OOWE57r6tOuY2X4f161aA2D36b4f22A78d8a968d38A451";
        var apiKey = "sk-wEwXmMgHD7wzQ4ru1a6cC69aF9B24d5fAc0778244a3aB67d";

//        "model": "gpt-3.5-turbo",
        var body = """
                {
                    "model": "gpt-3.5-turbo",
                    "messages": [
                        {
                            "role": "user",
                            "content": "i am a java program and human want me to add 2 to 3. What method could you advise me to do that?"
                        }
                    ]
                }""";

 //       https://neuroapi.host

        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
//                .uri(URI.create("https://lk.neuroapi.host/v1/chat/completions"))
                .uri(URI.create("https://neuroapi.host/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

//        JsonRequest jsonRequest = new JsonRequest("Tell me a good joke about cats");
//
//        // Вывод JSON-строки
//        String jsonBody = jsonRequest.toJson();
//        System.out.println(jsonBody);

    }
}


//    JsonRequest jsonRequest = new JsonRequest("i am a java program and human want me to add 2 to 3. What method could you advise me to do that?");