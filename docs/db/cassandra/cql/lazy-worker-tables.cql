-- Mar.25/2017
CREATE TABLE lazy_worker.registration (
	id uuid,
	creation_date timestamp,
	user_id_number varchar,
	PRIMARY KEY (id)
);

CREATE INDEX inx_user_id_number ON lazy_worker.registration (user_id_number);

