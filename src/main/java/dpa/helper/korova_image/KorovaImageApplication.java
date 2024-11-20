package dpa.helper.korova_image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("dpa.helper.korova_image.h2_demo_layers.domain.repository")
@EntityScan("dpa.helper.korova_image.h2_demo_layers.domain.entity")
@SpringBootApplication
public class KorovaImageApplication {

    public static void main(String[] args) {
        SpringApplication.run(KorovaImageApplication.class, args);
    }

}
