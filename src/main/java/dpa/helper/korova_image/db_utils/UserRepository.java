package dpa.helper.korova_image.db_utils;

import org.springframework.data.jpa.repository.JpaRepository;
import dpa.helper.korova_image.db_utils.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
