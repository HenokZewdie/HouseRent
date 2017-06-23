package DavePackage;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 * Created by student on 6/21/17.
 */
public interface HouseRepository extends CrudRepository<House, Long> {
    List<House> findByOwnerName(String owner);
}
