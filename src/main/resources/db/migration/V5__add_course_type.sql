ALTER TABLE course
    ADD COLUMN course_type VARCHAR(50)  DEFAULT NULL,
    ADD COLUMN topics      varchar(255) DEFAULT NULL;
