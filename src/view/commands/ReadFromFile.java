package view.commands;
import view.View;

import java.io.File;

public class ReadFromFile extends CommandsAbstract{
    String path;

    public ReadFromFile(View view) {
        super(view, 5, "Read from file.");
        this.path = "a";
    }

    @Override
    public void execute() {
        Integer size = this.getView().getPresenter().readFamilyTreeFromFile(getPath());
        System.out.println("Was read " + size + " person.");
    }

    private String getPath() {
        while (!new File(path).exists()) {
            System.out.println("Enter absolute path: ");
            this.path = super.getScanner().nextLine();
        }
        return path;
    }
}
