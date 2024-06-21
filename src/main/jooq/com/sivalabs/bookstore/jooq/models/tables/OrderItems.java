/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookstore.jooq.models.tables;


import com.sivalabs.bookstore.jooq.models.Keys;
import com.sivalabs.bookstore.jooq.models.Public;
import com.sivalabs.bookstore.jooq.models.tables.records.OrderItemsRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderItems extends TableImpl<OrderItemsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.order_items</code>
     */
    public static final OrderItems ORDER_ITEMS = new OrderItems();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderItemsRecord> getRecordType() {
        return OrderItemsRecord.class;
    }

    /**
     * The column <code>public.order_items.id</code>.
     */
    public final TableField<OrderItemsRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.order_items.code</code>.
     */
    public final TableField<OrderItemsRecord, String> CODE = createField(DSL.name("code"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.order_items.name</code>.
     */
    public final TableField<OrderItemsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.order_items.price</code>.
     */
    public final TableField<OrderItemsRecord, BigDecimal> PRICE = createField(DSL.name("price"), SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.order_items.quantity</code>.
     */
    public final TableField<OrderItemsRecord, Integer> QUANTITY = createField(DSL.name("quantity"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.order_items.order_id</code>.
     */
    public final TableField<OrderItemsRecord, Long> ORDER_ID = createField(DSL.name("order_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private OrderItems(Name alias, Table<OrderItemsRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderItems(Name alias, Table<OrderItemsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.order_items</code> table reference
     */
    public OrderItems(String alias) {
        this(DSL.name(alias), ORDER_ITEMS);
    }

    /**
     * Create an aliased <code>public.order_items</code> table reference
     */
    public OrderItems(Name alias) {
        this(alias, ORDER_ITEMS);
    }

    /**
     * Create a <code>public.order_items</code> table reference
     */
    public OrderItems() {
        this(DSL.name("order_items"), null);
    }

    public <O extends Record> OrderItems(Table<O> child, ForeignKey<O, OrderItemsRecord> key) {
        super(child, key, ORDER_ITEMS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<OrderItemsRecord, Long> getIdentity() {
        return (Identity<OrderItemsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<OrderItemsRecord> getPrimaryKey() {
        return Keys.ORDER_ITEMS_PKEY;
    }

    @Override
    public List<ForeignKey<OrderItemsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ORDER_ITEMS__ORDER_ITEMS_ORDER_ID_FKEY);
    }

    private transient Orders _orders;

    /**
     * Get the implicit join path to the <code>public.orders</code> table.
     */
    public Orders orders() {
        if (_orders == null)
            _orders = new Orders(this, Keys.ORDER_ITEMS__ORDER_ITEMS_ORDER_ID_FKEY);

        return _orders;
    }

    @Override
    public OrderItems as(String alias) {
        return new OrderItems(DSL.name(alias), this);
    }

    @Override
    public OrderItems as(Name alias) {
        return new OrderItems(alias, this);
    }

    @Override
    public OrderItems as(Table<?> alias) {
        return new OrderItems(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderItems rename(String name) {
        return new OrderItems(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderItems rename(Name name) {
        return new OrderItems(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderItems rename(Table<?> name) {
        return new OrderItems(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, BigDecimal, Integer, Long> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Long, ? super String, ? super String, ? super BigDecimal, ? super Integer, ? super Long, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Long, ? super String, ? super String, ? super BigDecimal, ? super Integer, ? super Long, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
