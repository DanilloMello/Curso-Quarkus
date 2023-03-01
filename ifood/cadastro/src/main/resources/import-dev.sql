insert into workout (id, creationdate, nome, updatedate)
values (1, '2023-02-21 00:00:00', 'Treino A', '2023-02-21 00:00:00');

insert into exercise (id, creationdate, name, updatedate, workout_id)
values (1, '2023-02-21 00:00:00', 'Supino Reto', '2023-02-21 00:00:00', 1);

insert into exercise_configuration (id, cadence, method, rangeofmotion, restbetweenexercises, restbetweenreps, restbetweensets, sets, weight, exercise_id)
values (1, '2020', 'DROPSET', 30, 30, 30, 30, 3, 30, 1);

insert into public.reps (reps, "time", exerciseconfiguration_id)
values (30,30,1);







