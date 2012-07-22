# Regions table

# --- !Ups

CREATE TABLE `regions` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `sort` BIGINT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET=utf8;

CREATE TABLE `site_config` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `time_offset` int(11) NOT NULL default '0',
  `site_name_ru` text NOT NULL,
  `title_text_ru` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `counters` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL default '',
  `text` text NOT NULL,
  `sort` bigint(20) unsigned NOT NULL default '0',
  `active` char(1) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs

