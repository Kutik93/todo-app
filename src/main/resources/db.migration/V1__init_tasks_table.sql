drop table if exists tasks;
create table tasks(
                      id long primary key auto_increment,
                      description varchar(100) not null,
                      done bit
)