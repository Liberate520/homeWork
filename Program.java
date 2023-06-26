import Exercises.Exercise;
import Exercises.ExerciseBuilder;
import Exercises.ExerciseData;
import MenuRender.ConsoleManager;
import MenuRender.MenuRender;

public class Program {
    public static void main(String[] args) {
        final int CONST_MENU_COUNT = 30;
        int taskId = 1;

        var cm = new ConsoleManager();

        var exData = new ExerciseData();
        var menu = new MenuRender(exData.descriptions, CONST_MENU_COUNT, true, true,
                "", "", "", "");

        boolean startApp = true;
        while (startApp) {
            cm.ConsoleClear();
            taskId = menu.StartRenderMenu(taskId - 1);
            menu.footerText = "";
            try {
                Exercise exercise = ExerciseBuilder.GetExerciseObject(exData, taskId);
                if (exercise != null) {
                    exercise.Start();
                }
            } catch (Exception e) {
                menu.footerText = e.getMessage();
            }

            startApp = taskId != 0;

        }

        cm.ConsoleClear();
        cm.PrintText("Программа закрыта.");
    }
}