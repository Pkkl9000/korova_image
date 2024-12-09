package dpa.helper.korova_image.db_layers.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectService {

    private final ObjectRepository objectRepository;

    @Autowired
    public ObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public List<ObjectEntity> findAll() {
        return objectRepository.findAll();
    }

    public Optional<ObjectEntity> findById(int id) {
        return objectRepository.findById(id);
    }

    public ObjectEntity save(ObjectEntity objectEntity) {
        return objectRepository.save(objectEntity);
    }

    public void deleteById(int id) {
        objectRepository.deleteById(id);
    }
}