package dpa.helper.korova_image.db_layers.objects;

import dpa.helper.korova_image.db_layers.objects.entity.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectEntity, Integer> {

    Optional<ObjectEntity> findByName(String name);


}