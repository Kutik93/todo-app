create table projects
(
    id long primary key auto_increment,
    description varchar(100) not null
);
create table project_steps (
                               id long primary key auto_increment,
                               description varchar(100) not null,
                               project_id long not null,
                               days_to_deadline int not null,
                               foreign key (project_id) references projects(id)
);

alter table task_groups add column project_id long null ;
alter table task_groups add foreign key (project_id) references projects(id);