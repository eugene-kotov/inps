package uz.tengebank.inps.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.tengebank.inps.model.InpsPersonData;

import java.util.List;

@Repository
public interface InpsRepository extends MongoRepository<InpsPersonData, String> {

    List<InpsPersonData> findByInps(String inps);

    List<InpsPersonData> findByName(String name);

    List<InpsPersonData> findByPassNum(String passNum);
}
