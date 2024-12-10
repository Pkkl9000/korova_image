package dpa.helper.korova_image.db_layers.user;

import dpa.helper.korova_image.db_layers.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
