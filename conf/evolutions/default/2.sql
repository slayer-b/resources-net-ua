# --- Site config table

# --- !Ups

CREATE TABLE site_config(
  id bigserial NOT NULL,
  site_name_ru text NOT NULL,
  title_text_ru text NOT NULL,
  PRIMARY KEY  (id)
);

insert into site_config(site_name_ru, title_text_ru) values('Site name', 'Title text');

# --- !Downs

drop table site_config;
