package ru.home_work.cherevichenko_sergey;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.service_tree.ServiceTree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.View;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws Exception {
        View view = new  ConsoleUi();
        view.start();

    }
}




