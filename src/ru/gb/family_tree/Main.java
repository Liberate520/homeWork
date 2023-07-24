package ru.gb.family_tree;

import ru.gb.family_tree.model.Service;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.save_print_file.FileHandler;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//  SERVICE
//        Service service = new Service();
//
//          Иванов Иван Петрович",  (1938,10,23)
//        "Иванов Петр Иванович", 1958, 2, 12;
//        Иванова Инна Васильевна", жен, 1960,9,3
//        Иванов Сергей Петрович", муж,1982,5,30)

        View view = new ConsoleUI();
        view.start();
    }
}
