# --- Counters table

# --- !Ups

CREATE TABLE counters(
  id bigserial NOT NULL,
  name varchar(255) NOT NULL default '',
  text text NOT NULL,
  sort bigint NOT NULL default '0',
  active boolean NOT NULL default false,
  PRIMARY KEY  (id)
);

insert into counters(name, text, sort, active) values('1', '<div style="color:blue;">1 - blue</div>', 4, true);
insert into counters(name, text, sort, active) values('1', '<div style="color:red;">2 - red</div>', 3, true);
insert into counters(name, text, sort, active) values('1', '<div style="color:green;">3 - green</div>', 2, true);
insert into counters(name, text, sort, active) values('1', '<div style="color:purple;">4 - purple</div>', 1, true);

# --- !Downs

drop table counters;