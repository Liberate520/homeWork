package view.commands;

import view.View;

import java.util.Scanner;

public class ReadFromFile extends CommandsAbstract{

    public ReadFromFile(View view) {
        super(view, 5, "Read from file.");
    }

    @Override
    public void execute() {
        this.getView().getPresenter().readFamilyTreeFromFile(getPath());
    }

    private String getPath() {
        System.out.println("Enter absolute path: ");
        return new Scanner(System.in).nextLine();
    }
}
