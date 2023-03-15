
-- Workout 1
insert into workout (id, creationdate, name, updatedate)
values (nextval('workout_seq'), '2023-02-21 00:00:00', 'Treino A', '2023-02-21 00:00:00');
    -- Exercise 1
insert into exercise (id, creationdate, name, updatedate, workout_id)
values (nextval('exercise_seq'), '2023-02-21 00:00:00', 'Supino Reto', '2023-02-21 00:00:00', 1);
insert into exercise_configuration (id, cadence, method, rangeofmotion, restbetweenexercises, restbetweenreps, restbetweensets, sets, weight, exercise_id)
values (nextval('exercise_configuration_seq'), '2020', 'DROPSET', 30, 30, 30, 30, 3, 30, 1);
--
-- Workout 2
insert into workout (id, creationdate, name, updatedate)
values (nextval('workout_seq'), '2023-02-21 00:00:00', 'Treino A', '2023-02-21 00:00:00');
--
    -- Exercise 2
insert into exercise (id, creationdate, name, updatedate, workout_id)
values (nextval('exercise_seq'), '2023-02-21 00:00:00', 'Supino Reto', '2023-02-21 00:00:00', 2);
insert into exercise_configuration (id, cadence, method, rangeofmotion, restbetweenexercises, restbetweenreps, restbetweensets, sets, weight, exercise_id)
values (nextval('exercise_configuration_seq'), '2020', 'DROPSET', 30, 30, 30, 30, 3, 30, 2);
--
--     -- Exercise 3
insert into exercise (id, creationdate, name, updatedate, workout_id)
values (nextval('exercise_seq'), '2023-02-21 00:00:00', 'Supino Reto', '2023-02-21 00:00:00', 2);
insert into exercise_configuration (id, cadence, method, rangeofmotion, restbetweenexercises, restbetweenreps, restbetweensets, sets, weight, exercise_id)
values (nextval('exercise_configuration_seq'), '2020', 'DROPSET', 30, 30, 30, 30, 3, 30, 3);
--
--     -- Exercise 4
insert into exercise (id, creationdate, name, updatedate, workout_id)
values (nextval('exercise_seq'), '2023-02-21 00:00:00', 'Supino Reto', '2023-02-21 00:00:00', 2);
insert into exercise_configuration (id, cadence, method, rangeofmotion, restbetweenexercises, restbetweenreps, restbetweensets, sets, weight, exercise_id)
values (nextval('exercise_configuration_seq'), '2020', 'DROPSET', 30, 30, 30, 30, 3, 30, 4);
--
--     -- Exercise 5
insert into exercise (id, creationdate, name, updatedate, workout_id)
values (nextval('exercise_seq'), '2023-02-21 00:00:00', 'Supino Reto', '2023-02-21 00:00:00', 2);
insert into exercise_configuration (id, cadence, method, rangeofmotion, restbetweenexercises, restbetweenreps, restbetweensets, sets, weight, exercise_id)
values (nextval('exercise_configuration_seq'), '2020', 'DROPSET', 30, 30, 30, 30, 3, 30, 5);





