package view;

import model.Organisms.Person.OrganismType;
import model.Organisms.Person.Sex;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Presenter presenter;

    public UI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    public void start(){
        while (true) {
            Text.MainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    presenter.printTree();
                    break;
                case 2:
                    Text.inputOrganismType();
                    String organismTypeString = scanner.next();
                    OrganismType organismType = OrganismType.valueOf(organismTypeString);
                    Text.inputName();
                    String name = scanner.next();
                    Text.inputBirthday();
                    LocalDate date = LocalDate.parse(scanner.next());
                    Text.inputSex();
                    Sex sex = Sex.valueOf(scanner.next());
                    presenter.addPerson(organismType, name, date, sex);
                    break;
                case 3:
                    presenter.sortByName();
                    Text.sortingComplete();
                    break;
                case 4:
                    presenter.sortByAge();
                    Text.sortingComplete();
                    break;
                case 5:
                    presenter.writeToFile();
                    break;
                case 6:
                    presenter.readFromFile();
                    break;
                case 7: System.exit(0);
            }
        }
    }


    public void printAnswer(String answer){
        System.out.println(answer);
    }

}
