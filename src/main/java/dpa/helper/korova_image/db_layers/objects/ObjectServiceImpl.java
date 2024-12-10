package dpa.helper.korova_image.db_layers.objects;

import dpa.helper.korova_image.db_layers.objects.entity.ObjectEntity;
//import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectServiceImpl implements ObjectService{

    private final ObjectRepository objectRepository;

    @Autowired
    public ObjectServiceImpl(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Override
    public List<ObjectEntity> findAll() {
        return objectRepository.findAll();
    }

    @Override
    public Optional<ObjectEntity> findById(int id) {
        return objectRepository.findById(id);
    }

    @Transactional
    @Override
    public ObjectEntity createObject(ObjectEntity objectEntity) {
        // Проверка на существование объекта с таким же именем
        objectRepository.findByName(objectEntity.getName()).
                ifPresent(existingObject -> {
            throw new IllegalArgumentException("Object with name " + objectEntity.getName() + " already exists");
        }); return objectRepository.save(objectEntity);
    }

    @Override
    public ObjectEntity getObjectById(int id) {
        return objectRepository.findById(id) .orElseThrow(() ->
                new IllegalArgumentException("Object with id " + id + " not found"));
    }

//    @Override
//    @Transactional
//    public Optional<ObjectEntity> save(ObjectEntity objectEntity) {
//        ObjectEntity existingEntity = objectRepository.findByNameUsingQuery(objectEntity.getName());
//        if (existingEntity != null) {
//            System.out.println("Запись с таким именем уже существует");
//            return Optional.of(existingEntity); // Возвращаем существующую запись
//        }
//        return Optional.of(objectRepository.save(objectEntity));
//    }

//    @Override
//    public Optional<ObjectEntity> findByName(String name) {
//        return Optional.ofNullable(objectRepository.findByName(name));
//    }

    @Override
    public void deleteById(int id) {
        objectRepository.deleteById(id);
    }
}