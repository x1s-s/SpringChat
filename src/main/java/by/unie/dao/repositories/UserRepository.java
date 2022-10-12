package by.unie.dao.repositories;

import by.unie.chat.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //@Query("select u from User u where u.name = :name")
    User findByName(String name);
}
