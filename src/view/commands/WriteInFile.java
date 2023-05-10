package view.commands;

import view.View;

import java.util.Scanner;

public class WriteInFile extends CommandsAbstract{

    public WriteInFile(View view) {
        super(view, 4, "Write in file.");
    }

    @Override
    public void execute() {
        this.getView().getPresenter().writeFamilyTreeInFile(getPath());
    }

    private String getPath() {
        System.out.println("Enter absolute path: ");
        return new Scanner(System.in).nextLine();
    }
}
