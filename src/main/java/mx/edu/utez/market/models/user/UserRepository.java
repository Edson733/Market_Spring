package mx.edu.utez.market.models.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByPersonCurp(String curp);

    @Query(value = "UPDATE users SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);
}
