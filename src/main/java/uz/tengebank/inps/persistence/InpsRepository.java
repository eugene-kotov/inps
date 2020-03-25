package uz.tengebank.inps.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.tengebank.inps.model.InpsPersonData;

import java.util.List;

@Repository
public interface InpsRepository extends MongoRepository<InpsPersonData, String> {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public List<InpsPersonData> findAll() {
//        return mongoTemplate.findAll(InpsPersonData.class);
//    }
}
