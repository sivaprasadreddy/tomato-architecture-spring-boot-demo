package com.sivalabs.bookstore.catalog;

import com.sivalabs.bookstore.common.models.PagedResult;
import java.math.BigDecimal;
import java.util.Optional;

public interface CatalogAPI {

    Long createProduct(CreateProductCommand cmd);

    PagedResult<Product> findProducts(FindProductsQuery query);

    Optional<Product> findProductByCode(String code);

    void updatePrice(String code, BigDecimal price);
}
