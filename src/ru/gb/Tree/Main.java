package ru.gb.Tree;

import java.time.LocalDate;
import ru.gb.Tree.FileHandler.FileHandler;
import ru.gb.Tree.Human.Gender;
import ru.gb.Tree.Service.Service;


public class Main {
    public static void main(String[] args) {
        
        Service tree = familyTree();
        System.out.println(tree.getServiceInfo());
        tree.sortByName();
        System.out.println(tree.getServiceInfo());
        tree.sortByBirthDate();
        System.out.println(tree.getServiceInfo());
        tree.sortByAge();
        System.out.println(tree.getServiceInfo());

        String filePath = "homeWork\\src\\ru\\gb\\Tree\\FileHandler\\saveFile.out";

        FileHandler save = new FileHandler();
        save.saveFile(tree, filePath);
        System.out.println("");
        System.out.println("Сохраненный файл: \n"+ save.readFile(filePath));
    }

    static Service familyTree(){

        Service service = new Service();
        service.addNewPerson("Наталья", Gender.female, LocalDate.of(1955, 12, 31), LocalDate.of(2018, 4, 21));
        service.addNewPerson("Иван", Gender.male, LocalDate.of(1950, 10, 25), LocalDate.of(2015, 5, 10));
        service.addNewWedding(0,1);

        service.addNewPerson("Алиса", Gender.female, LocalDate.of(1976, 10, 10), null);
        service.addNewPerson("Сергей", Gender.male, LocalDate.of(1975, 6, 21), 0, 1);
        service.addNewChild(0, 3);
        service.addNewChild(1, 3);
        service.addNewWedding(2, 3);
        
        service.addNewPerson("Светлана", Gender.female, LocalDate.of(1998, 1, 24), 2, 3);
        service.addNewChild(3, 4);
        service.addNewChild(2, 4);
       

        service.addNewPerson("Петр", Gender.male, LocalDate.of(2000, 7, 21), 2, 3);
        service.addNewChild(3, 5);
        service.addNewChild(2, 5);

        service.addNewPerson("Анна", Gender.female, LocalDate.of(2021,5,4), 4);
        service.addNewChild(4, 6);
        return service;
    }
}
