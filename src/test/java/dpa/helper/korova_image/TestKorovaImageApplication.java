package dpa.helper.korova_image;

import org.springframework.boot.SpringApplication;

public class TestKorovaImageApplication {

    public static void main(String[] args) {
        SpringApplication.from(KorovaImageApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
