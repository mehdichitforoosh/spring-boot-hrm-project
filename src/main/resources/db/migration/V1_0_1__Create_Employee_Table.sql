CREATE TABLE "hrm".employees
(
  id character varying(255) NOT NULL,
  creation_date timestamp without time zone NOT NULL,
  creator_id character varying(255) NOT NULL,
  deleted boolean NOT NULL,
  description character varying(255),
  job_title_id character varying(255),
  department_id character varying(255),
  joining_date timestamp without time zone,
  modification_date timestamp without time zone NOT NULL,
  modifier_id character varying(255) NOT NULL,
  name character varying(255) NOT NULL,
  personnel_id character varying(255),
  version bigint NOT NULL,
  work_shift_id character varying(255),
  CONSTRAINT employees_pkey PRIMARY KEY (id)
)