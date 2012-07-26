# --- Regions table

# --- !Ups

CREATE TABLE regions(
  id bigserial NOT NULL,
  name TEXT NOT NULL,
  sort BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

# --- !Downs

drop table regions;