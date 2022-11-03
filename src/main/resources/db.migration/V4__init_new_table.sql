drop table if exists task_groups;
create table task_groups(
                            id          long primary key auto_increment,
                            description varchar(100) not null,
                            done        bit
);

alter table task add column task_group_id int null;
alter table task add foreign key (task_group_id) references task_groups (id);