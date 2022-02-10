create table if not exists "empty".users(

    id serial primary key,
    nome varchar(255),
    nick varchar(50),
    email varchar(70),
    senha varchar(30),
    confirmation bool DEFAULT false,
    tenant varchar(50)
);