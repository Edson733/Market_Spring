package mx.edu.utez.market.models.category;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "UPDATE categories SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);

    boolean existsByName(String name);
}
