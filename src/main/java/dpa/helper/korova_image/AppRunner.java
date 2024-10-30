package dpa.helper.korova_image;

import dpa.helper.korova_image.command_pattern.MethodCaller;
import dpa.helper.korova_image.mouse_key_hook.MouseAndKeyboardHooking;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {

        new MethodCaller().callMethod("sign");

        MouseAndKeyboardHooking.MouseListener();

    }
}

