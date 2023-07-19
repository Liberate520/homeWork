package family_tree;//Продолжаем грейдить наш проект с гениологическим древом. Изменить древо, сделать класс параметизированным,
//        чтобы условно дерево можно было использовать не только для людей,
//        но и сделать родословную для собак(класс собак создавать не надо или создать,
//        но в за пределами пакета проекта). Продумать(только подумать,
//        но можно и попробовать реализовать) класс общения с пользователем,
//        набор команд, для операций над деревом
//Реализовать паттерн MVP в вашем проекте с семейным деревом.
//        Примеры проектов смотри на 4 и 5 семинаре

import family_tree.model.gender.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;
import family_tree.view.consoleUI.ConsoleUi;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Service service = new Service();

//        service.addPerson("FathersMom", LocalDate.of(1901, 1, 1), LocalDate.of(2000,
//                1, 1), Gender.Female);
//        service.addPerson("MothersMom", LocalDate.of(1900, 1, 1), LocalDate.of(1999,
//                1, 1), Gender.Female);
//        service.addPerson("MothersFather", LocalDate.of(1900, 1, 1), Gender.Male);
//        service.getPerson("MothersMom").setPartner(service.getPerson("MothersFather"));
//        service.addPerson("MotherBrother", LocalDate.of(1960, 1, 1), Gender.Male,
//                service.getPerson("grandmotherM"), service.getPerson("grandfatherM"));
//        service.addPerson("Mother", LocalDate.of(1955, 1, 1), Gender.Female,
//                service.getPerson("grandmotherM"), service.getPerson("grandfatherM"));
//        service.addPerson("Father", LocalDate.of(1965, 1, 1), Gender.Male,
//                service.getPerson("grandmotherF"), null);
//        service.getPerson("Mother").setPartner(service.getPerson("Father"));
//        service.addPerson("FirstChild", LocalDate.of(2000, 1, 1), Gender.Female,
//                service.getPerson("mother"), service.getPerson("father"));
//        service.addPerson("SecondChild", LocalDate.of(2001, 1, 1), Gender.Male,
//                service.getPerson("mother"), service.getPerson("father"));

//        service.reviseDependencies();
//
//        service.print();
//        service.sortByAge();
//        service.print();
//        service.sortByName();
//        service.print();
//
//        String path = "src/familyTree.out";
//        service.saveTreeInFile(path);
//        service.readTreeFromFile(path);
//        service.print();

        View view = new ConsoleUi();
        view.start();
    }
}
