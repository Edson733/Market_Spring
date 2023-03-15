package mx.edu.utez.market.models.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean findById(long id);
    Optional<Person> findByCurp(String curp);
    List<Person> findByGender(String gender);
}
