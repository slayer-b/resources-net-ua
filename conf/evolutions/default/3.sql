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

# --- !Downs

drop table counters;