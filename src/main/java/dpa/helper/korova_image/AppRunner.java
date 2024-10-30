package dpa.helper.korova_image;

import dpa.helper.korova_image.command_pattern.MethodCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        new MethodCaller().callMethod("sign");

    }
}

