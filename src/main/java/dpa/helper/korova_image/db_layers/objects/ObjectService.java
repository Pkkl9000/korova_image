package dpa.helper.korova_image.db_layers.objects;

import dpa.helper.korova_image.db_layers.objects.entity.ObjectEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ObjectService {

    List<ObjectEntity> findAll();

    Optional<ObjectEntity> findById(int id);

//    Optional<ObjectEntity> save(ObjectEntity objectEntity);

//    Optional<ObjectEntity> findByName(String name);

    @Transactional
    ObjectEntity createObject(ObjectEntity objectEntity);

    ObjectEntity getObjectById(int id);

    void deleteById(int id);
}