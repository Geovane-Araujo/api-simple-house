alter table "@@schema_name".shopping_list add constraint fk_shopping_list_into_product foreign key (id_product) references "@@schema_name".products(id);
alter table "@@schema_name".shopping_list add constraint fk_shopping_list_into_category foreign key (id_category) references "@@schema_name".category(id);
alter table "@@schema_name".tasks add constraint fk_tasks_into_priorities foreign key (id_priority) references "@@schema_name".priorities(id);
alter table "@@schema_name".tasks add constraint fk_tasks_into_family_composition_created foreign key (id_user_created) references "@@schema_name".family_composition(id);
alter table "@@schema_name".tasks add constraint fk_tasks_into_family_composition_assignee foreign key (id_user_assignee) references "@@schema_name".family_composition(id);

