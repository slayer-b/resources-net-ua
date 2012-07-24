# Regions table

# --- !Ups

CREATE TABLE regions(
  id bigserial NOT NULL,
  name TEXT NOT NULL,
  sort BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

CREATE TABLE site_config(
  id bigserial NOT NULL,
  time_offset int NOT NULL default '0',
  site_name_ru text NOT NULL,
  title_text_ru text NOT NULL,
  PRIMARY KEY  (id)
);

CREATE TABLE counters(
  id bigserial NOT NULL,
  name varchar(255) NOT NULL default '',
  text text NOT NULL,
  sort bigint NOT NULL default '0',
  active smallint NOT NULL default 0,
  PRIMARY KEY  (id)
);

# --- !Downs

drop table regions;
drop table site_config;
drop table counters;