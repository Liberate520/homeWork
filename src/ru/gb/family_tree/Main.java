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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FamilyTree<Human> tree = new FamilyTree();
//        String filePath = "src/ru/gb/family_tree/tree.out";
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save(tree, filePath);

//        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
//        System.out.println(tree);

//        tree.addHuman(new Human("Ivanov Ivan Petrovich", Gender.муж, LocalDate.of(1938, 10, 23), null, null, null));
//        tree.addHuman(new Human("Ivanov Petr Sergeevich", Gender.муж, LocalDate.of(1958, 2, 12), null, tree.getByFullName("Ivanov Ivan Petrovich"), null));
//        tree.addHuman(new Human("Ivanova Inna Vasil'evna", Gender.жен, LocalDate.of(1960, 9, 3), null, null, null));
//        tree.addHuman(new Human("Ivanov Sergey Petrovich", Gender.муж, LocalDate.of(1982, 5, 30), null, tree.getByFullName("Ivanov Petr Sergeevich"), tree.getByFullName("Ivanova Inna Vasil'evna")));
//
//        System.out.println(tree.getInfo());
//        tree.sortByFullName();
//        System.out.println(tree.getInfo());
//        tree.sortByAge();
//        System.out.println(tree.getInfo());
//    }

//  SERVICE
//        Service service = new Service();
//
//        service.addHuman("Иванов Иван Петрович", Gender.муж, LocalDate.of(1938,10,23), null, null, null);
//        service.addHuman("Иванов Петр Сергеевич", Gender.муж, LocalDate.of(1958, 2, 12),null, service.tree.getByFullName("Иванов Иван Петрович"), null);
//        service.addHuman("Иванова инна Васильевна", Gender.жен, LocalDate.of(1960,9,3),null, null, null);
//        service.addHuman("Иванов Сергей Петрович", Gender.муж, LocalDate.of(1982,5,30),null, service.tree.getByFullName("Иванов Петр Сергеевич"), service.tree.getByFullName("Иванова инна Васильевна"));
//
//        System.out.println(service.getInfo());
//        service.sortByFullName();
//        System.out.println(service.getInfo());
//        service.sortByAge();
//        System.out.println(service.getInfo());
//    }

        View view = new ConsoleUI();
        view.start();
    }
}
