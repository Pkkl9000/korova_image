package dpa.helper.korova_image.command_pattern;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MethodCaller {
    private Map<String, Command> commandMap = new HashMap<>();

    public MethodCaller() {
        commandMap.put("signal1", new Method1Command());
        commandMap.put("signal2", new Method2Command());
    }

    public void callMethod(String signal) {
        Command command = commandMap.getOrDefault(signal, () -> System.out.println("Default command executed"));
        command.execute();
    }
}
