# --- Regions table

# --- !Ups

CREATE TABLE regions(
  id bigserial NOT NULL,
  name TEXT NOT NULL,
  sort BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

insert into regions(name, sort) values('region 1', 4);
insert into regions(name, sort) values('region 2', 3);
insert into regions(name, sort) values('region 3', 2);
insert into regions(name, sort) values('region 4', 1);

# --- !Downs

drop table regions;
