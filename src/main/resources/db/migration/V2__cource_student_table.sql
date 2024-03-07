CREATE TABLE course_student
(
    course_id  BIGINT,
    student_id BIGINT,
    PRIMARY KEY (course_id, student_id),
    FOREIGN KEY (course_id) REFERENCES course (id),
    FOREIGN KEY (student_id) REFERENCES student (id)
);
