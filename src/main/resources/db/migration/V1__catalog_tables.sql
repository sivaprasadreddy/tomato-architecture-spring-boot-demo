create sequence product_id_seq start with 100 increment by 50;

create table products
(
    id          bigint  not null default nextval('product_id_seq'),
    code        varchar not null unique,
    name        varchar not null,
    description varchar,
    image_url   varchar,
    price       numeric not null,
    primary key (id)
);
