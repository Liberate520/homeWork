package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import commands.*;
import presenters.*;

public class ConsoleInterface {
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
        this.commandList.add(new OutputHumanByUuid(this));
        this.commandList.add(new DeleteChildToHuman(this));
        this.commandList.add(new FindByFIO(this));
        this.commandList.add(new OutputEntireTree(this));
        this.commandList.add(new EstablishKinshipRelationship(this));
        this.commandList.add(new WriteTreeToFile(this));
    }

    public void menu() {
        this.outStr("Выберите действие:\n");
        for (int i = 0; i < this.commandList.size(); i++) {
            this.outStr(i + " - " + this.commandList.get(i).description() + "\n");
        }
        this.outStr("--> ");
        String str;

        str = this.scanner.nextLine();
        try {
            int choice = Integer.parseInt(str);
            if ((choice >= 0) & (choice < this.commandList.size())) {
                this.commandList.get(Integer.parseInt(str)).execute();
            } else {
                this.outStr("Нет команды. Еще раз\n");
            }
        } catch (NumberFormatException e) {
            this.outStr("Не число. Еще раз.\n");
        }
    }

    public void createNewTree() {
        this.outResult(this.presenter.createNewTree());
        this.menu();
    }

    public void createTreeFromFile() {
        this.outResult(this.presenter.createTreeFromFile());
        this.menu();
    }

    public void addHuman() {
        this.outStr("Введите Фамилию:\n--> ");
        String lastName = inputText();
        this.outStr("Введите Имя:\n--> ");
        String name = inputText();
        this.outStr("Введите Отчество:\n--> ");
        String secondName = inputText();
        this.outStr("Введите Пол\n0 - женский\n1 - мужской:\n--> ");
        int gender = 0;
        Boolean loop = true;
        while (loop) {
            try {
                gender = Integer.parseInt(inputText());
                if ((gender == 0 || gender == 1)) {
                    loop = false;
                } else {
                    this.outStr("0 или 1. Еще раз.:\n--> ");
                }
            } catch (NumberFormatException e) {
                this.outStr("Не число. Еще раз.");
            }
        }

        String outUuid = this.presenter.addHuman(lastName, name, secondName, gender);
        if (outUuid.length() > 0) {
            this.outResult(outUuid + " -> " + this.presenter.outputHumanByUuid(outUuid) + " создан");

            this.outStr("Uuid супруга/супруги или 0 - если нет:\n--> ");
            String uuid = inputText();

            if (!uuid.equals("0")) {
                this.outResult(this.presenter.addSpouseToHuman(outUuid, uuid));
            }
            
            this.outStr("Uuid отца или 0 - если нет:\n--> ");
            uuid = this.inputText();

            if (!uuid.equals("0")) {
                this.outResult(this.presenter.addFatherToHuman(uuid, outUuid));
            }

            this.outStr("Uuid матери или 0 - если нет:\n--> ");
            uuid = this.inputText();

            if (!uuid.equals("0")) {
                this.presenter.addMotherToHuman(outUuid, uuid);
            }

            this.outResult(this.presenter.outputHumanByUuid(outUuid));
        } else {
            this.outStr("Ошибка создания!");
        }
        this.menu();
    }

    public void deleteHuman() {
        this.outStr("Введите uuid:\n--> ");
        String uuid = this.inputText();
        this.outResult(this.presenter.deleteHuman(uuid));
        this.menu();
    }

    public void outputHumanByUuid() {
        this.outStr("Введите uuid:\n--> ");
        String uuid = inputText();
        this.outResult(this.presenter.outputHumanByUuid(uuid));
        this.menu();
    }

    public void deleteChildToHuman() {
        this.outStr("Введите uuid родителя:\n--> ");
        String uuidHuman = inputText();
        this.outStr("Введите uuid ребенка:\n--> ");
        String uuidChild = inputText();
        this.outResult(this.presenter.deleteChildToHuman(uuidHuman, uuidChild));
        this.menu();
    }

    public void findByFIO() {
        this.outStr("Введите ФИО:\n--> ");
        String fio = inputText();
        this.outResult(this.presenter.findByFIO(fio));
        this.menu();
    }

    public void outputEntireTree() {
        this.outResult(this.presenter.outputEntireTree());
        this.menu();
    }

    public void writeTreeToFile() {
        this.outResult(this.presenter.writeTreeToFile());
        this.menu();
    }

    public void addMotherToHuman() {
        this.outStr("Введите uuid матери:\n--> ");
        String uuidHuman = inputText();
        this.outStr("Введите uuid ребенка:\n--> ");
        String uuidChild = inputText();
        this.outResult(this.presenter.addMotherToHuman(uuidHuman, uuidChild));
        this.menu();
    }

    public void addFatherToHuman() {
        this.outStr("Введите uuid отца:\n--> ");
        String uuidHuman = inputText();
        this.outStr("Введите uuid ребенка:\n--> ");
        String uuidChild = inputText();
        this.outResult(this.presenter.addFatherToHuman(uuidHuman, uuidChild));
        this.menu();
    }

    public void addSpouseToHuman() {
        this.outStr("Введите uuid:\n--> ");
        String uuidFirst = inputText();
        this.outStr("Введите uuid супруга/супруги:\n--> ");
        String uuidSecond = inputText();
        this.outResult(this.presenter.addSpouseToHuman(uuidFirst, uuidSecond));
        this.menu();
    }

    public void establishKinshipRelationship() {
        this.outStr("Введите uuid:\n--> ");
        String uuidFirst = inputText();
        this.outStr("Введите uuid второго человека:\n--> ");
        String uuidSecond = inputText();
        this.outResult(this.presenter.establishKinshipRelationship(uuidFirst, uuidSecond));
        this.menu();
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
