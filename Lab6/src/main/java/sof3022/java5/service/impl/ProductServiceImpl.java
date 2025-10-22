package sof3022.java5.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sof3022.java5.entity.Product;
import sof3022.java5.repository.ProductRepository;
import sof3022.java5.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProductsWithFieldSort(String fieldSort) {
        Sort sort = Sort.by(Sort.Direction.DESC, fieldSort);
        return productRepository.findAll(sort);
    }

    @Override
    public Page<Product> getAllProductsWithPagination(Integer pageNumber) {
        return productRepository.findAll(PageRequest.of(pageNumber, 5));
    }

    @Override
    public Page<Product> getAllProductsWithPaginationAndSort(Integer pageNumber, String directionSort, String fieldSort) {

        Sort.Direction direction = directionSort.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, fieldSort);

        return productRepository.findAll(PageRequest.of(pageNumber, 5, sort));
    }


}
