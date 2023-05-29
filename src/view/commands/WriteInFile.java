package view.commands;

import view.View;

import java.io.File;

public class WriteInFile extends CommandsAbstract{
    String path;

    public WriteInFile(View view) {
        super(view, 4, "Write in file.");
        path = "a";
    }

    @Override
    public void execute() {
       boolean flag = this.getView().getPresenter().writeFamilyTreeInFile(getPath());
       if (flag) {
           System.out.println("Data was written in file.");
       } else {
           System.out.println("Error.");
       }
    }

    private String getPath() {
        while (!new File(path).exists()) {
            System.out.println("Enter absolute path: ");
            this.path = super.getScanner().nextLine();
        }
        return path;
    }
}
