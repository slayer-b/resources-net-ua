# --- Pages table

# --- !Ups

CREATE TABLE pages (
  id bigserial NOT NULL,
  id_pages bigint default NULL,
  name_ru text NOT NULL,
  info_top_ru text NOT NULL,
  info_bottom_ru text NOT NULL,
  title_ru text NOT NULL,
  description_ru text NOT NULL ,
  keywords_ru text NOT NULL,
  sort bigint NOT NULL default 0,
  active boolean NOT NULL default true,
  type varchar(30) NOT NULL default '',
  PRIMARY KEY (id),
  FOREIGN KEY (id_pages) REFERENCES pages (id)
);

insert into pages(id, id_pages, name_ru,  info_top_ru,  info_bottom_ru,  title_ru,  description_ru,  keywords_ru, active, type)
            values(1, null,     'name-1', 'info_top-1', 'info_bottom-1', 'title-1', 'description-1', 'keywords-1', true, 'catalogue');

insert into pages(id, id_pages, name_ru,  info_top_ru,  info_bottom_ru,  title_ru,  description_ru,  keywords_ru, active, type)
            values(2, 1,        'name-2', 'info_top-2', 'info_bottom-2', 'title-2', 'description-2', 'keywords-2', true, 'catalogue');

insert into pages(id, id_pages, name_ru,  info_top_ru,  info_bottom_ru,  title_ru,  description_ru,  keywords_ru, active, type)
            values(3, 1,        'name-3', 'info_top-3', 'info_bottom-3', 'title-3', 'description-3', 'keywords-3', true, 'catalogue');

insert into pages(id, id_pages, name_ru,  info_top_ru,  info_bottom_ru,  title_ru,  description_ru,  keywords_ru, active, type)
            values(4, 1,        'name-4', 'info_top-4', 'info_bottom-4', 'title-4', 'description-4', 'keywords-4', true, 'catalogue');

# --- !Downs

drop table pages;