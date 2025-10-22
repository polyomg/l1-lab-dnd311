package sof3022.java5.service;

import org.springframework.data.domain.Page;
import sof3022.java5.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductsWithFieldSort(String fieldSort);

    Page<Product> getAllProductsWithPagination(Integer pageNumber);

    Page<Product> getAllProductsWithPaginationAndSort(Integer pageNumber, String directionSort, String fieldSort);
}
