package sof3022.java5.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sof3022.java5.dto.ReportInventoryByCategoryName;
import sof3022.java5.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductsByPriceBetween(Double minPrice, Double maxPrice);

    Page<Product> getAllProductsByProductNameAndPagination(String productName, Integer pageNumber);

    List<ReportInventoryByCategoryName> getAllInventoryByCategoryName();

    List<Product> getAllProductsByPriceBetweenDSL(Double minPrice, Double maxPrice);

    Page<Product> getAllProductsByProductNameAndPaginationDSL(String productName, Integer pageNumber);
}
