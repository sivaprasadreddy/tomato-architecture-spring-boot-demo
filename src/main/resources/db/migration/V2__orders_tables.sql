create sequence order_id_seq start with 100 increment by 50;
create sequence order_item_id_seq start with 100 increment by 50;

create table orders
(
    id                        bigint not null default nextval('order_id_seq'),
    order_number              varchar not null,
    customer_name             varchar not null,
    customer_email            varchar not null,
    customer_phone            varchar not null,
    delivery_address_line1    varchar not null,
    delivery_address_line2    varchar,
    delivery_address_city     varchar not null,
    delivery_address_state    varchar not null,
    delivery_address_zip_code varchar not null,
    delivery_address_country  varchar not null,
    status                    varchar not null,
    comments                  text,
    created_at                timestamp,
    updated_at                timestamp,
    primary key (id)
);

create table order_items
(
    id       bigint  not null default nextval('order_item_id_seq'),
    code     varchar not null,
    name     varchar not null,
    price    numeric not null,
    quantity integer not null,
    order_id bigint  not null references orders (id),
    primary key (id)
);
