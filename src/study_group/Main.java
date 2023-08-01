package study_group;

import study_group.model.Service;
import study_group.model.StudyGroup;
import study_group.model.Teacher;
import study_group.view.ConsoleUI;
import study_group.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
