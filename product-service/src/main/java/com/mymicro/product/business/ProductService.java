package com.mymicro.product.business;

import com.mymicro.product.dataAccess.ProductRepository;
import com.mymicro.product.eDto.ProductCreateRequest;
import com.mymicro.product.eDto.ProductResponse;
import com.mymicro.product.entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    @Transactional
    public void createProduct(ProductCreateRequest request) {
        Product product = new Product(
                request.getProductName(),
                request.getDescription(),
                request.getPrice()
        );
        productRepository.saveAndFlush(product);
        log.info("Product {} is saved.", product.getId());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getProductName(),
                        product.getDescription(),
                        product.getPrice()
                )).toList();
    }
}
