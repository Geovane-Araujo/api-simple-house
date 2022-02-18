create table if not exists "@@schema_name".category(

    id serial primary key,
    description varchar(50)
);

create table if not exists "@@schema_name".products(

   id serial primary key,
   description_product varchar(50)
);

create table if not exists "@@schema_name".priorities(

   id serial primary key,
   description_priorities varchar(50)
);


create table if not exists "@@schema_name".shopping_list(

    id serial primary key,
    id_product int,
    id_category int,
    amount numeric(18,2),
    status int
);

create table if not exists "@@schema_name".family_composition(

    id serial primary key,
    user_master_id int,
    status int,
    score int
);

create table if not exists "@@schema_name".tasks(

    id serial primary key,
    title_task varchar(100),
    description_task varchar(1000),
    id_priority int,
    initial_date timestamp,
    finish_date timestamp,
    score int,
    id_user_created int,
    id_user_assignee int
);




