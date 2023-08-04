package view;


import model.Organisms.Person.OrganismType;
import model.Organisms.Person.Sex;
import presenter.Presenter;
import view.commands.*;

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
        CommandList commandList = new CommandList();
        while (true){
            int i = 0;
            for(Command command: commandList){
                System.out.println(++i + ". " + command.getDescription());
            }
            int choice = scanner.nextInt();
            commandList.commandList.get(choice-1).start(presenter);
        }
    }
    public void printAnswer(String answer){
        System.out.println(answer);
    } //TODO не понял почему этот метод обязательный

    public String inputName(Scanner scanner){
        Text.inputName();
        return scanner.next();
    }

    public Sex inputSex() {
        Text.inputSex();
        return Sex.valueOf(scanner.next());
    }

    public LocalDate inputBirthday() {
        Text.inputBirthday();
        return LocalDate.parse(scanner.next());
    }

    public OrganismType inputType(Scanner scanner) {
        Text.inputOrganismType();
        String organismTypeString = scanner.next();
        return OrganismType.valueOf(organismTypeString);
    }
    }
