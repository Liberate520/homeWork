package view;


import human.Gender;
import human.Human;
import service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Service service;

    public View(Service service) {
        this.service = service;
    }

    public void run() {
        Commands cmd = Commands.NONE;
        while (true) {
            try {
                String userCommand = prompt("Введите команду: \n");
                cmd = Commands.valueOf(userCommand.toUpperCase());
            } catch (IllegalStateException e) {
                System.out.println("Unknow command");
                continue;
            }
            if (cmd == Commands.EXIT) return;
            switch (cmd) {
                case ADD -> service.addItemToTree(getHuman());
                case SEARCH -> System.out.println(service.getItemById(getHumanId()));
                case DELETE -> {
                    System.out.println("Delete person");
                    service.removeItem(getHumanId());
                }
                case SHOW -> System.out.println(service.getHumanListInfo());
            }


        }
    }

    private Human getHuman() {
        String name = prompt("Enter name: ");
        Gender gender = getGender();
        String birthDate = prompt("Enter birthdate (format yyyy-mm-dd)");
        int parentsKnown = Integer.parseInt(prompt("""
                Do you know parents?
                1.Yes
                2.No
                """));
        if (parentsKnown == 1) {
            List<Human> parents = getParents();
            Human father = parents.get(0);
            Human mother = parents.get(1);
            return new Human(name, gender, birthDate, father, mother);
        }
        if (parentsKnown == 2) return new Human(name, gender, birthDate);
        System.out.println("Error switch between 1 or 2");
        return null;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private Gender getGender() {
        try {
            int genderChoise = Integer.parseInt(prompt("""
                    switch gender\s
                    1. Male
                    2. Female
                    """));

            if (genderChoise == 1)
                return Gender.MALE;
            if (genderChoise == 2)
                return Gender.FEMALE;

        } catch (NumberFormatException e) {
            System.out.println("Enter only numbers (1 or 2)");
        }
        return null;
    }

    /**
     * TODO
     * 1.функция должна возвращать лист объектов *** интерфейса FamilyTreeItem
     * 2.Валидация отца и матери ( если введут одинаковые числа,
     * если не введут числа, если введут не существующие числа)
     * <p>
     * ПРОБЛЕМА
     * Как инициализоравать отца и мать
     *
     * @return
     */
    private List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        Human father = service.getItemById(Long.parseLong(prompt("Enter father ID: \n")));
        System.out.println(father);
        Human mother = service.getItemById(Long.parseLong(prompt("Enter mother ID: \n")));
        System.out.println(mother);
        parents.add(father);
        parents.add(mother);
        return parents;
    }

    private int getHumanId() {
        return Integer.parseInt(prompt("Enter ID person: \n"));
    }
}
