package DavePackage;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 * Created by student on 6/21/17.
 */
public interface HouseRepository extends CrudRepository<House, Long> {
   // @Query("select ownerName, address from house u where u.address = ?1")
    //List<House> findByOwnerName(String owner);
    List<House> findByAddress(String addre);
}
