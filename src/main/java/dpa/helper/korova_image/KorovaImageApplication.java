package dpa.helper.korova_image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = {"dpa.helper.korova_image.db_utils"})
//@EntityScan("dpa.helper.korova_image.db_layers.user.entities.entity")
//@ComponentScan(basePackages = {"dpa.helper.korova_image.db_layers"})
//@EntityScan(basePackages = {"dpa.helper.korova_image.db_layers.objects"})
//@EnableJpaRepositories(basePackages = {"dpa.helper.korova_image.db_layers.objects"})

@SpringBootApplication
public class KorovaImageApplication {

    public static void main(String[] args) {
        SpringApplication.run(KorovaImageApplication.class, args);
    }

}
