-- Populate the department table
INSERT INTO department (name)
VALUES ('Computer Science'),
       ('Mathematics'),
       ('Physics');

-- Populate the courseRequest table
INSERT INTO course (department_id, name, credit_hours)
VALUES (1, 'Introduction to Programming', 3),
       (1, 'Database Management', 4),
       (2, 'Calculus I', 4),
       (2, 'Linear Algebra', 3),
       (3, 'Mechanics', 4);

-- Populate the studentRequest table
INSERT INTO student (first_name, last_name, email, department_id)
VALUES ('John', 'Doe', 'john.doe@example.com', 1),
       ('Alice', 'Smith', 'alice.smith@example.com', 2),
       ('Bob', 'Johnson', 'bob.johnson@example.com', 1),
       ('Emily', 'Brown', 'emily.brown@example.com', 3),
       ('Michael', 'Wilson', 'michael.wilson@example.com', 2);

-- Populate the instructor table
INSERT INTO instructor (first_name, last_name, email)
VALUES ('Sarah', 'Jones', 'sarah.jones@example.com'),
       ('David', 'Lee', 'david.lee@example.com'),
       ('Jennifer', 'Clark', 'jennifer.clark@example.com');
