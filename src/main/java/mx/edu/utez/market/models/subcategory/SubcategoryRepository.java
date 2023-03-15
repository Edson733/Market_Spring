package mx.edu.utez.market.models.subcategory;

import mx.edu.utez.market.models.category.Category;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    @Query(value = "UPDATE subcategories SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);

    boolean existsByName(String name);

    boolean existsById(Long id);

    List<Subcategory> findAllByCategoryId(Long id);
}
