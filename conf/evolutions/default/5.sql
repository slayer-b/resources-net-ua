# --- Sites table

# --- !Ups

CREATE TABLE sites (
  id bigserial NOT NULL,
  id_users bigint,
  id_pages bigint NOT NULL,
  id_regions bigint NOT NULL,
  title_ru text NOT NULL,
  description_ru text NOT NULL,
  info_ru text NOT NULL,
  keywords_ru text NOT NULL,
  url varchar(250) NOT NULL,
  back_url varchar(250) NOT NULL default '',
  sort bigint NOT NULL default '0',
  email varchar(250) NOT NULL default '',
  PRIMARY KEY  (id),
--   FOREIGN KEY (id_users) REFERENCES users (id),
  FOREIGN KEY (id_pages) REFERENCES pages (id),
  FOREIGN KEY (id_regions) REFERENCES regions (id)
);

INSERT INTO sites(id, id_pages, id_regions ,title_ru, description_ru, info_ru, keywords_ru, url, back_url, sort, email) VALUES
 (1, 2,1,'title-1', 'descr-1', 'info-1', 'keywords-1', 'http://main.com.ua','',2,'ukr@ukr.net'),
 (2, 3,2,'title-2', 'descr-2', 'info-2', 'keywords-2', 'http://category2.1.com','',2,'asdjk@i.ua'),
 (3, 4,3,'title-3', 'descr-3', 'info-3', 'keywords-3', 'http://category2.2.com','',3,'asdjk@i.ua'),
 (4, 2,4,'title-4', 'descr-4', 'info-4', 'keywords-4', 'http://category2.3.com','',4,'asdjk@i.ua'),
 (5, 3,1,'title-5', 'descr-5', 'info-5', 'keywords-5', 'http://category1.1.com','',1,'asdjk@i.ua'),
 (6, 4,2,'title-6', 'descr-6', 'info-6', 'keywords-6', 'http://category1.2.com','',5,'asdjk@i.ua'),
 (7, 2,3,'title-7', 'descr-7', 'info-7', 'keywords-7', 'http://category1.3.com','',6,'asdjk@i.ua'),
 (8, 3,4,'title-8', 'descr-8', 'info-8', 'keywords-8', 'http://category1.sites1.com','',1,'asdjk@i.ua'),
 (9, 4,1,'title-9', 'descr-9', 'info-9', 'keywords-9', 'http://category1.sites1.2.com','',1,'asdjk@i.ua'),
 (10,2,2,'title-10','descr-10','info-10','keywords-10','http://category1.sites1.3.com','',5,'asdjk@i.ua'),
 (11,3,3,'title-11','descr-11','info-11','keywords-11','http://category1.sites2.1.com','',4,'asdjk@i.ua'),
 (12,4,4,'title-12','descr-12','info-12','keywords-12','http://category1.sites2.2.com','',5,'asdjk@i.ua');

# --- !Downs

drop table sites;