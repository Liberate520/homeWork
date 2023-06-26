package Exercises.Homework1;

import Exercises.Exercise;

public class Exercise1 extends Exercise {
    public Exercise1(String description) {
        super(description);
    }

    @Override
    public boolean Solution() {
        super.cmdManager.PrintText("Задача в разработке...");

        return false;
    }
}