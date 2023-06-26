package Exercises;

import Exercises.Homework1.Exercise1;

public class ExerciseBuilder {
    public static Exercise GetExerciseObject(ExerciseData exerciseData, int taskNum) throws Exception {
        int taskDataIndex = taskNum - 1;
        String taskText = exerciseData.GetTaskText(taskDataIndex);
        switch (taskNum) {
            case 1:
                return new Exercise1(taskText);
            default:
                String nameTask = taskText.length() < 51 ? taskText : taskText.substring(0, 47) + "...";
                throw new Exception("ЗАДАЧА <" + nameTask + "> ЕЩЕ НЕ РЕАЛИЗОВАНА");
        }
    }
}
