/* CREATE HIBERNATE SEQUENCE */

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 7
  CACHE 1;

/* CREATE PAGE TABLE */
  
CREATE TABLE page
(
  id bigint NOT NULL,
  home boolean NOT NULL,
  template character varying(255),
  slug character varying(255),
  text character varying(255),
  CONSTRAINT page_pkey PRIMARY KEY (id)
);

/* CREATE PAGE FIELD VALUES */

CREATE TABLE page_field_values
(
  page_id bigint NOT NULL,
  name character varying(255),
  value character varying(255),
  CONSTRAINT fk_76wrco5uasej533ewrukuowbf FOREIGN KEY (page_id)
      REFERENCES page (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

/* CREATE LOCALE CONFIGURATION */

CREATE TABLE locale_configuration
(
  id bigint NOT NULL,
  country character varying(255),
  default_locale boolean NOT NULL,
  language character varying(255),
  CONSTRAINT locale_configuration_pkey PRIMARY KEY (id)
);

/* CREATE LODGING TABLE */

CREATE TABLE lodging
(
  id bigint NOT NULL,
  address_line1 character varying(255),
  address_line2 character varying(255),
  address_line3 character varying(255),
  address_line4 character varying(255),
  address_line5 character varying(255),
  address character varying(255),
  landline character varying(255),
  image character varying(255),
  url character varying(1000),
  mobile character varying(255),
  name character varying(255),
  CONSTRAINT lodging_pkey PRIMARY KEY (id)
);

/* CREATE DATA LOAD TABLE */

CREATE TABLE data_load
(
  id bigint NOT NULL,
  type integer,
  CONSTRAINT data_load_pkey PRIMARY KEY (id)
)
