/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookstore.jooq.models.tables.records;


import com.sivalabs.bookstore.jooq.models.tables.Orders;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrdersRecord extends UpdatableRecordImpl<OrdersRecord> implements Record15<Long, String, String, String, String, String, String, String, String, String, String, String, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.orders.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.orders.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.orders.order_number</code>.
     */
    public void setOrderNumber(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.orders.order_number</code>.
     */
    public String getOrderNumber() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.orders.customer_name</code>.
     */
    public void setCustomerName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.orders.customer_name</code>.
     */
    public String getCustomerName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.orders.customer_email</code>.
     */
    public void setCustomerEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.orders.customer_email</code>.
     */
    public String getCustomerEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.orders.customer_phone</code>.
     */
    public void setCustomerPhone(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.orders.customer_phone</code>.
     */
    public String getCustomerPhone() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.orders.delivery_address_line1</code>.
     */
    public void setDeliveryAddressLine1(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.orders.delivery_address_line1</code>.
     */
    public String getDeliveryAddressLine1() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.orders.delivery_address_line2</code>.
     */
    public void setDeliveryAddressLine2(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.orders.delivery_address_line2</code>.
     */
    public String getDeliveryAddressLine2() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.orders.delivery_address_city</code>.
     */
    public void setDeliveryAddressCity(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.orders.delivery_address_city</code>.
     */
    public String getDeliveryAddressCity() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.orders.delivery_address_state</code>.
     */
    public void setDeliveryAddressState(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.orders.delivery_address_state</code>.
     */
    public String getDeliveryAddressState() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.orders.delivery_address_zip_code</code>.
     */
    public void setDeliveryAddressZipCode(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.orders.delivery_address_zip_code</code>.
     */
    public String getDeliveryAddressZipCode() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.orders.delivery_address_country</code>.
     */
    public void setDeliveryAddressCountry(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.orders.delivery_address_country</code>.
     */
    public String getDeliveryAddressCountry() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.orders.status</code>.
     */
    public void setStatus(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.orders.status</code>.
     */
    public String getStatus() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.orders.comments</code>.
     */
    public void setComments(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.orders.comments</code>.
     */
    public String getComments() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.orders.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.orders.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(13);
    }

    /**
     * Setter for <code>public.orders.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.orders.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Long, String, String, String, String, String, String, String, String, String, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Long, String, String, String, String, String, String, String, String, String, String, String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Orders.ORDERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Orders.ORDERS.ORDER_NUMBER;
    }

    @Override
    public Field<String> field3() {
        return Orders.ORDERS.CUSTOMER_NAME;
    }

    @Override
    public Field<String> field4() {
        return Orders.ORDERS.CUSTOMER_EMAIL;
    }

    @Override
    public Field<String> field5() {
        return Orders.ORDERS.CUSTOMER_PHONE;
    }

    @Override
    public Field<String> field6() {
        return Orders.ORDERS.DELIVERY_ADDRESS_LINE1;
    }

    @Override
    public Field<String> field7() {
        return Orders.ORDERS.DELIVERY_ADDRESS_LINE2;
    }

    @Override
    public Field<String> field8() {
        return Orders.ORDERS.DELIVERY_ADDRESS_CITY;
    }

    @Override
    public Field<String> field9() {
        return Orders.ORDERS.DELIVERY_ADDRESS_STATE;
    }

    @Override
    public Field<String> field10() {
        return Orders.ORDERS.DELIVERY_ADDRESS_ZIP_CODE;
    }

    @Override
    public Field<String> field11() {
        return Orders.ORDERS.DELIVERY_ADDRESS_COUNTRY;
    }

    @Override
    public Field<String> field12() {
        return Orders.ORDERS.STATUS;
    }

    @Override
    public Field<String> field13() {
        return Orders.ORDERS.COMMENTS;
    }

    @Override
    public Field<LocalDateTime> field14() {
        return Orders.ORDERS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field15() {
        return Orders.ORDERS.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getOrderNumber();
    }

    @Override
    public String component3() {
        return getCustomerName();
    }

    @Override
    public String component4() {
        return getCustomerEmail();
    }

    @Override
    public String component5() {
        return getCustomerPhone();
    }

    @Override
    public String component6() {
        return getDeliveryAddressLine1();
    }

    @Override
    public String component7() {
        return getDeliveryAddressLine2();
    }

    @Override
    public String component8() {
        return getDeliveryAddressCity();
    }

    @Override
    public String component9() {
        return getDeliveryAddressState();
    }

    @Override
    public String component10() {
        return getDeliveryAddressZipCode();
    }

    @Override
    public String component11() {
        return getDeliveryAddressCountry();
    }

    @Override
    public String component12() {
        return getStatus();
    }

    @Override
    public String component13() {
        return getComments();
    }

    @Override
    public LocalDateTime component14() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component15() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getOrderNumber();
    }

    @Override
    public String value3() {
        return getCustomerName();
    }

    @Override
    public String value4() {
        return getCustomerEmail();
    }

    @Override
    public String value5() {
        return getCustomerPhone();
    }

    @Override
    public String value6() {
        return getDeliveryAddressLine1();
    }

    @Override
    public String value7() {
        return getDeliveryAddressLine2();
    }

    @Override
    public String value8() {
        return getDeliveryAddressCity();
    }

    @Override
    public String value9() {
        return getDeliveryAddressState();
    }

    @Override
    public String value10() {
        return getDeliveryAddressZipCode();
    }

    @Override
    public String value11() {
        return getDeliveryAddressCountry();
    }

    @Override
    public String value12() {
        return getStatus();
    }

    @Override
    public String value13() {
        return getComments();
    }

    @Override
    public LocalDateTime value14() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value15() {
        return getUpdatedAt();
    }

    @Override
    public OrdersRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public OrdersRecord value2(String value) {
        setOrderNumber(value);
        return this;
    }

    @Override
    public OrdersRecord value3(String value) {
        setCustomerName(value);
        return this;
    }

    @Override
    public OrdersRecord value4(String value) {
        setCustomerEmail(value);
        return this;
    }

    @Override
    public OrdersRecord value5(String value) {
        setCustomerPhone(value);
        return this;
    }

    @Override
    public OrdersRecord value6(String value) {
        setDeliveryAddressLine1(value);
        return this;
    }

    @Override
    public OrdersRecord value7(String value) {
        setDeliveryAddressLine2(value);
        return this;
    }

    @Override
    public OrdersRecord value8(String value) {
        setDeliveryAddressCity(value);
        return this;
    }

    @Override
    public OrdersRecord value9(String value) {
        setDeliveryAddressState(value);
        return this;
    }

    @Override
    public OrdersRecord value10(String value) {
        setDeliveryAddressZipCode(value);
        return this;
    }

    @Override
    public OrdersRecord value11(String value) {
        setDeliveryAddressCountry(value);
        return this;
    }

    @Override
    public OrdersRecord value12(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public OrdersRecord value13(String value) {
        setComments(value);
        return this;
    }

    @Override
    public OrdersRecord value14(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public OrdersRecord value15(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public OrdersRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, LocalDateTime value14, LocalDateTime value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrdersRecord
     */
    public OrdersRecord() {
        super(Orders.ORDERS);
    }

    /**
     * Create a detached, initialised OrdersRecord
     */
    public OrdersRecord(Long id, String orderNumber, String customerName, String customerEmail, String customerPhone, String deliveryAddressLine1, String deliveryAddressLine2, String deliveryAddressCity, String deliveryAddressState, String deliveryAddressZipCode, String deliveryAddressCountry, String status, String comments, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Orders.ORDERS);

        setId(id);
        setOrderNumber(orderNumber);
        setCustomerName(customerName);
        setCustomerEmail(customerEmail);
        setCustomerPhone(customerPhone);
        setDeliveryAddressLine1(deliveryAddressLine1);
        setDeliveryAddressLine2(deliveryAddressLine2);
        setDeliveryAddressCity(deliveryAddressCity);
        setDeliveryAddressState(deliveryAddressState);
        setDeliveryAddressZipCode(deliveryAddressZipCode);
        setDeliveryAddressCountry(deliveryAddressCountry);
        setStatus(status);
        setComments(comments);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
