package view;


import model.human.Gender;
import model.human.Human;
import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private boolean work;
    private Menu menu;


    public ConsoleUI() {
        this.presenter = new Presenter(this);
        this.work = true;
        this.menu = new Menu(this);
    }

    public void run() {
        System.out.println("Hello!");
        while (work) {
            System.out.println(menu.menu());
            int choise = Integer.parseInt(prompt());
            if (validationNumbers(choise, menu.getSize()))
                menu.execute(choise);
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void getHuman() {
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
            presenter.addTreeItem(new Human(name, gender, birthDate, father, mother));
        }
        if (parentsKnown == 2) presenter.addTreeItem(new Human(name, gender, birthDate));
        else print("Error switch between 1 or 2");
    }


    private Gender getGender() {
        try {
            int genderChose = Integer.parseInt(prompt("""
                    switch gender\s
                    1. Male
                    2. Female
                    """));

            if (genderChose == 1)
                return Gender.MALE;
            if (genderChose == 2)
                return Gender.FEMALE;

        } catch (NumberFormatException e) {
            print("Enter only numbers (1 or 2)");
        }
        return null;
    }

    public void getById() {
        long id = getHumanId();
        print(presenter.getById(id).toString());
    }

    public void remove() {
        long id = getHumanId();
        presenter.remove(id);
    }

    private long getHumanId() {
        return Long.parseLong(prompt("Enter ID person: \n"));
    }

    public void getHumanListInfo() {
        print(presenter.getHumanListInfo());
    }

    public void finish(){
        print("Good bye!");
        work = false;
    }

    private boolean validationNumbers(int number, int maxValue){
        return number <= maxValue && number > 0;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        print(message);
        return in.nextLine();
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }



}
