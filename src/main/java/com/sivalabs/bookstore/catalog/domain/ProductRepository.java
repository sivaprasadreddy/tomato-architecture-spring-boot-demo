package com.sivalabs.bookstore.catalog.domain;

import static com.sivalabs.bookstore.jooq.models.Tables.PRODUCTS;

import com.sivalabs.bookstore.catalog.Product;
import com.sivalabs.bookstore.common.models.PagedResult;
import java.math.BigDecimal;
import java.util.Optional;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
class ProductRepository {
    private final DSLContext dsl;

    ProductRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    Optional<Product> findByCode(String code) {
        return dsl.selectFrom(PRODUCTS)
                .where(PRODUCTS.CODE.equalIgnoreCase(code))
                .fetchOptional(p -> new Product(
                        p.getId(), p.getCode(), p.getName(), p.getDescription(), p.getImageUrl(), p.getPrice()));
    }

    PagedResult<Product> getProducts(int pageNo, int pageSize) {
        long totalElements = dsl.fetchCount(PRODUCTS);
        int totalPages = (int) Math.ceil((double) totalElements / (double) pageSize);

        var products = dsl.selectFrom(PRODUCTS)
                .orderBy(PRODUCTS.NAME)
                .limit(pageSize)
                .offset((pageNo - 1) * pageSize)
                .fetch()
                .map(p -> new Product(
                        p.getId(), p.getCode(), p.getName(), p.getDescription(), p.getImageUrl(), p.getPrice()));

        return new PagedResult<>(
                products,
                totalElements,
                pageNo,
                totalPages,
                pageNo == 1,
                totalPages == pageNo,
                totalPages > pageNo,
                pageNo > 1);
    }

    Long saveProduct(Product product) {
        return dsl.insertInto(PRODUCTS)
                .set(PRODUCTS.CODE, product.code())
                .set(PRODUCTS.NAME, product.name())
                .set(PRODUCTS.DESCRIPTION, product.description())
                .set(PRODUCTS.IMAGE_URL, product.imageUrl())
                .set(PRODUCTS.PRICE, product.price())
                .returning(PRODUCTS.ID)
                .fetchOne(PRODUCTS.ID);
    }

    public void updatePrice(String code, BigDecimal price) {
        dsl.update(PRODUCTS)
                .set(PRODUCTS.PRICE, price)
                .where(PRODUCTS.CODE.equalIgnoreCase(code))
                .execute();
    }
}
