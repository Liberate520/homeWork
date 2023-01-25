package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import commands.*;
import presenters.*;

public class ConsoleInterface implements Command {
    private Presenter presenter;
    private List<Option> commandList;
    private Scanner scanner = new Scanner(System.in,"cp866");

    public ConsoleInterface(Presenter presenter) {
        this.presenter = presenter;
        this.commandList = new ArrayList<>();

        this.commandList.add(new CreateNewTree(this));
        this.commandList.add(new CreateTreeFromFile(this));
        this.commandList.add(new AddHuman(this));
        this.commandList.add(new AddMotherToHuman(this));
        this.commandList.add(new AddFatherToHuman(this));
        this.commandList.add(new AddSpouseToHuman(this));
        this.commandList.add(new DeleteHuman(this));
        this.commandList.add(new OutoutHumanByUuid(this));
        this.commandList.add(new DeleteChildToHuman(this));
        this.commandList.add(new FindByFIO(this));
        this.commandList.add(new OutputEntireTree(this));
        this.commandList.add(new EstablishKinshipRelationship(this));
        this.commandList.add(new WriteTreeToFile(this));
    }

    public void menu() {
        System.out.println("Выберите действие:");
        for (int i = 0; i < this.commandList.size(); i++) {
            System.out.println(i + " - " + this.commandList.get(i).description());
        }
        System.out.print("--> ");
        String str;

        str = this.scanner.nextLine();
        try {
            int choice = Integer.parseInt(str);
            if ((choice >= 0) & (choice < this.commandList.size())) {
                this.commandList.get(Integer.parseInt(str)).execute();
            } else {
                System.out.println("Нет команды. Еще раз");
            }
        } catch (NumberFormatException e) {
            System.out.println("Не число. Еще раз.");
        }
    }

    @Override
    public void createNewTree() {
        this.presenter.createNewTree();
    }

    @Override
    public void createTreeFromFile() {
        this.presenter.createTreeFromFile();
    }

    @Override
    public void addHuman() {
        this.presenter.addHuman();
    }

    @Override
    public void deleteHuman() {
        this.presenter.deleteHuman();
    }

    @Override
    public void outoutHumanByUuid() {
        this.presenter.outoutHumanByUuid();
    }

    @Override
    public void deleteChildToHuman() {
        this.presenter.deleteChildToHuman();
    }

    @Override
    public void findByFIO() {
        this.presenter.findByFIO();
    }

    @Override
    public void outputEntireTree() {
        this.presenter.outputEntireTree();
    }

    @Override
    public void writeTreeToFile() {
        this.presenter.writeTreeToFile();
    }

    @Override
    public void addMotherToHuman() {
        this.presenter.addMotherToHuman();
    }

    @Override
    public void addFatherToHuman() {
        this.presenter.addFatherToHuman();
    }

    @Override
    public void addSpouseToHuman() {
        this.presenter.addSpouseToHuman();
    }

    @Override
    public void establishKinshipRelationship() {
        this.presenter.establishKinshipRelationship();
    }

    public void outResult(String text){
        System.out.println(
            ConsoleColors.GREEN
            + "=========== Результат ==========="
            + ConsoleColors.RESET
        );
        System.out.println(
            ConsoleColors.RED
            + text
            + ConsoleColors.RESET
        );
        System.out.println(
            ConsoleColors.GREEN
            + "================================="
            + ConsoleColors.RESET
        );
    }

    public void outStr(String text){
        System.out.print(text);
    }

    public String inputText() {
        Boolean loop = true;
        String str = "";
        while (loop) {
            str = this.scanner.nextLine();
            if (str.length() > 0) {
                loop = false;
            } else {
                System.out.println("Пустое значение. Еще раз.");
            }
        }
        return str;
    }
}
