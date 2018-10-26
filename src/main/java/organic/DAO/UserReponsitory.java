package organic.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import organic.Model.User;

@Repository
public interface UserReponsitory  extends CrudRepository<User, Integer> {

}
