package sof3022.java5.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sof3022.java5.dto.ReportInventoryByCategoryName;
import sof3022.java5.entity.Product;
import sof3022.java5.repository.ProductRepository;
import sof3022.java5.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProductsByPriceBetween(Double minPrice, Double maxPrice) {
//        return productRepository.getByPriceBetween(minPrice, maxPrice);
        return productRepository.getAllByPrice(minPrice, maxPrice);
    }

    @Override
    public Page<Product> getAllProductsByProductNameAndPagination(String productName, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 5);
        String keyword = "%" + productName + "%";
        return productRepository.getAllByProductNameAndPagination(keyword, pageable);
    }

    @Override
    public List<ReportInventoryByCategoryName> getAllInventoryByCategoryName() {
        return productRepository.getAllByCategoryName();
    }

    @Override
    public List<Product> getAllProductsByPriceBetweenDSL(Double minPrice, Double maxPrice) {
        return productRepository.getByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public Page<Product> getAllProductsByProductNameAndPaginationDSL(String productName, Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, 5);
        String keyword = "%" + productName + "%";

        return productRepository.getByNameLike(keyword, pageable);
    }
}
