
-- Drop table

-- DROP TABLE public.incidence_types;

CREATE TABLE public.incidence_types (
                                        "name" varchar NOT NULL,
                                        "uuid" uuid NOT NULL,
                                        id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                        created timestamp NOT NULL,
                                        updated timestamp NOT NULL,
                                        active bool DEFAULT true NOT NULL,
                                        CONSTRAINT type_incidence_pk PRIMARY KEY (id)
);


-- public.manager definition

-- Drop table

-- DROP TABLE public.manager;

CREATE TABLE public.manager (
                                "name" varchar NOT NULL,
                                last_name varchar NOT NULL,
                                phone varchar(10) NOT NULL,
                                email varchar NOT NULL,
                                "uuid" uuid NOT NULL,
                                id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                active bool DEFAULT false NOT NULL,
                                created timestamp NOT NULL,
                                updated timestamp NOT NULL,
                                "password" varchar NOT NULL,
                                "user" varchar(40) NOT NULL,
                                CONSTRAINT management_pk PRIMARY KEY (id),
                                CONSTRAINT manager_unique UNIQUE ("user")
);


-- public.incidences definition

-- Drop table

-- DROP TABLE public.incidences;

CREATE TABLE public.incidences (
                                   "uuid" uuid NULL,
                                   id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                   incidence_type_id int8 NULL,
                                   created timestamp NOT NULL,
                                   "activeI" bool DEFAULT true NOT NULL,
                                   incidence_date_start date NOT NULL,
                                   incidence_date_finish date NOT NULL,
                                   CONSTRAINT incidencia_pk PRIMARY KEY (id),
                                   CONSTRAINT incidencia_type_incidence_fk FOREIGN KEY (incidence_type_id) REFERENCES public.incidence_types(id)
);