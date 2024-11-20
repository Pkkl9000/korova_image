package dpa.helper.korova_image.db_utils;

import org.springframework.data.jpa.repository.JpaRepository;
import dpa.helper.korova_image.db_utils.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
