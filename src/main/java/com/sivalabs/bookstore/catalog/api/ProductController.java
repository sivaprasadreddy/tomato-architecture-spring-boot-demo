package com.sivalabs.bookstore.catalog.api;

import com.sivalabs.bookstore.ApplicationProperties;
import com.sivalabs.bookstore.catalog.CatalogAPI;
import com.sivalabs.bookstore.catalog.FindProductsQuery;
import com.sivalabs.bookstore.catalog.Product;
import com.sivalabs.bookstore.catalog.ProductNotFoundException;
import com.sivalabs.bookstore.common.models.PagedResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final CatalogAPI catalogAPI;
    private final ApplicationProperties properties;

    ProductController(CatalogAPI catalogAPI, ApplicationProperties properties) {
        this.catalogAPI = catalogAPI;
        this.properties = properties;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        log.info("Fetching products for page: {}", pageNo);
        var query = new FindProductsQuery(pageNo, properties.pageSize());
        return catalogAPI.findProducts(query);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code) {
        log.info("Fetching product by code: {}", code);
        return catalogAPI
                .findProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.withCode(code));
    }
}
