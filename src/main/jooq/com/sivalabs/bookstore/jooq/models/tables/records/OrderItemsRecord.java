/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookstore.jooq.models.tables.records;


import com.sivalabs.bookstore.jooq.models.tables.OrderItems;

import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderItemsRecord extends UpdatableRecordImpl<OrderItemsRecord> implements Record6<Long, String, String, BigDecimal, Integer, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.order_items.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.order_items.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.order_items.code</code>.
     */
    public void setCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.order_items.code</code>.
     */
    public String getCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.order_items.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.order_items.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.order_items.price</code>.
     */
    public void setPrice(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.order_items.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.order_items.quantity</code>.
     */
    public void setQuantity(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.order_items.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.order_items.order_id</code>.
     */
    public void setOrderId(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.order_items.order_id</code>.
     */
    public Long getOrderId() {
        return (Long) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, BigDecimal, Integer, Long> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, String, String, BigDecimal, Integer, Long> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return OrderItems.ORDER_ITEMS.ID;
    }

    @Override
    public Field<String> field2() {
        return OrderItems.ORDER_ITEMS.CODE;
    }

    @Override
    public Field<String> field3() {
        return OrderItems.ORDER_ITEMS.NAME;
    }

    @Override
    public Field<BigDecimal> field4() {
        return OrderItems.ORDER_ITEMS.PRICE;
    }

    @Override
    public Field<Integer> field5() {
        return OrderItems.ORDER_ITEMS.QUANTITY;
    }

    @Override
    public Field<Long> field6() {
        return OrderItems.ORDER_ITEMS.ORDER_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getCode();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public BigDecimal component4() {
        return getPrice();
    }

    @Override
    public Integer component5() {
        return getQuantity();
    }

    @Override
    public Long component6() {
        return getOrderId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getCode();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public BigDecimal value4() {
        return getPrice();
    }

    @Override
    public Integer value5() {
        return getQuantity();
    }

    @Override
    public Long value6() {
        return getOrderId();
    }

    @Override
    public OrderItemsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public OrderItemsRecord value2(String value) {
        setCode(value);
        return this;
    }

    @Override
    public OrderItemsRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public OrderItemsRecord value4(BigDecimal value) {
        setPrice(value);
        return this;
    }

    @Override
    public OrderItemsRecord value5(Integer value) {
        setQuantity(value);
        return this;
    }

    @Override
    public OrderItemsRecord value6(Long value) {
        setOrderId(value);
        return this;
    }

    @Override
    public OrderItemsRecord values(Long value1, String value2, String value3, BigDecimal value4, Integer value5, Long value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderItemsRecord
     */
    public OrderItemsRecord() {
        super(OrderItems.ORDER_ITEMS);
    }

    /**
     * Create a detached, initialised OrderItemsRecord
     */
    public OrderItemsRecord(Long id, String code, String name, BigDecimal price, Integer quantity, Long orderId) {
        super(OrderItems.ORDER_ITEMS);

        setId(id);
        setCode(code);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setOrderId(orderId);
        resetChangedOnNotNull();
    }
}
