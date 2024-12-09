package dpa.helper.korova_image.db_layers.objects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectEntity, Integer> {
    // Здесь можно добавить дополнительные методы поиска, если необходимо
}