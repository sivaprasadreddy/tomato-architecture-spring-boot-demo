package com.sivalabs.bookstore.catalog.domain;

import com.sivalabs.bookstore.catalog.CatalogAPI;
import com.sivalabs.bookstore.catalog.CreateProductCommand;
import com.sivalabs.bookstore.catalog.FindProductsQuery;
import com.sivalabs.bookstore.catalog.Product;
import com.sivalabs.bookstore.common.models.PagedResult;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
class CatalogService implements CatalogAPI {
    private final ProductRepository productRepository;

    CatalogService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Long createProduct(CreateProductCommand cmd) {
        Product product = new Product(null, cmd.code(), cmd.name(), cmd.description(), cmd.imageUrl(), cmd.price());
        return productRepository.saveProduct(product);
    }

    @Override
    public PagedResult<Product> findProducts(FindProductsQuery query) {
        return productRepository.getProducts(query.pageNo(), query.pageSize());
    }

    @Override
    public Optional<Product> findProductByCode(String code) {
        return productRepository.findByCode(code);
    }

    @Override
    @Transactional
    public void updatePrice(String code, BigDecimal price) {
        productRepository.updatePrice(code, price);
    }
}
