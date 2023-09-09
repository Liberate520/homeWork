package view;


import model.human.Gender;
import model.human.Human;
import model.service.ServiceHuman;
import presenter.Presenter;

import java.util.Scanner;

public class ViewHuman implements View{
    private Presenter presenter;

    public ViewHuman(Presenter presenter) {
        this.presenter = presenter;
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
                case ADD -> presenter.addTreeItem(getHuman());
                case SEARCH -> System.out.println(presenter.getById(getHumanId()));
                case DELETE -> {
                    System.out.println("Delete person");
                    presenter.remove(getHumanId());
                }
                case SHOW -> System.out.println(presenter.getHumanListInfo());
            }


        }
    }

    @Override
    public void print(String text) {

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
            long fatherId = Long.parseLong(prompt("Enter father ID: \n"));
            long motherId = Long.parseLong(prompt("Enter mother ID: \n"));
            Human father = presenter.getById(fatherId);
            Human mother = presenter.getById(motherId);
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


    private int getHumanId() {
        return Integer.parseInt(prompt("Enter ID person: \n"));
    }
}
