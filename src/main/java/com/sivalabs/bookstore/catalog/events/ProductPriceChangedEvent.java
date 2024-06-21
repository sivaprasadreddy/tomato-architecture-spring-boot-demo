package com.sivalabs.bookstore.catalog.events;

import java.math.BigDecimal;

record ProductPriceChangedEvent(String code, BigDecimal price) {}
