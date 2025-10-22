package sof3022.java5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sof3022.java5.dto.ReportInventoryByCategoryName;
import sof3022.java5.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Bài 1
    @Query(value = "FROM Product p WHERE p.price between :minPrice AND :maxPrice", nativeQuery = false)
    List<Product> getAllByPrice(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    // Bài 2
    @Query("FROM Product p WHERE p.name LIKE :keyword")
    Page<Product> getAllByProductNameAndPagination(@Param("keyword")String keyword, Pageable pageable);

    // Bài 3
    @Query("SELECT p.category.name AS categoryName, SUM(p.price) AS totalPrices, count(p.id) AS numberOfProducts FROM Product p GROUP BY p.category.name")
    List<ReportInventoryByCategoryName> getAllByCategoryName();

    // Bài 4
    List<Product> getByPriceBetween(Double priceMin, Double priceMax);

    // Bài 5
    Page<Product> getByNameLike(String keyword, Pageable pageable);

}
