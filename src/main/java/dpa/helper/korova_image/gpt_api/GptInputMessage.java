package dpa.helper.korova_image.gpt_api;

import lombok.RequiredArgsConstructor;


public class GptInputMessage {

    private String model = "gpt-3.5-turbo";

    private final String role = "user";

    private final String content;

    public GptInputMessage(String content) {
        this.content = content;
    }
}
