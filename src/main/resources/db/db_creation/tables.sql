create table if not exists "@@schema_name".category(

    id serial primary key,
    description varchar(50),
);

create table if not exists "@@schema_name".products(

   id serial primary key,
   description_product varchar(50),
);

create table if not exists "@@schema_name".priorities(

   id serial primary key,
   description_priorities varchar(50),
);


create table if not exists "@@schema_name".shopping_list(

    id serial primary key,
    id_product int,
    id_category int,
    amount numeric(18,2),
    status int
);

create table if not exists "@@schema_name".tasks(

    id serial primary key,
    id_product int,
    id_category int,
    amount numeric(18,2),
    status int
);