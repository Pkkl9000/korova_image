package dpa.helper.korova_image.gpt_api.json_extraction;

public class JsonRequest {
    private String model = "gpt-3.5-turbo";
    private String role = "user";
    private final String content;

    public JsonRequest(String content) {
        this.model = model;
        this.role = role;
        this.content = content;
    }

    // Метод для генерации JSON-строки
    public String toJson() {
        return """
                {
                    "model": "%s",
                    "messages": [
                        {
                            "role": "%s",
                            "content": "%s"
                        }
                    ]
                }
                """.formatted(model, role, content);
    }

    public static void main(String[] args) {
        // Создание объекта JsonRequest
        JsonRequest request = new JsonRequest("i am a java program and human want me to add 2 to 3. What method could you advise me to do that?");

        // Вывод JSON-строки
        String jsonBody = request.toJson();
        System.out.println(jsonBody);
    }
}