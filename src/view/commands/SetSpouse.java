package view.commands;

import presenter.Presenter;
import view.Text;

import java.util.Scanner;

public class SetSpouse implements Command{
    String description = "Set spouse";
    @Override
    public void start(Presenter presenter) {
        TreePrinter printer = new TreePrinter();
        Scanner scanner = new Scanner(System.in);
        printer.start(presenter);
        Text.setSpouseHusband();
        int husbandIndex = scanner.nextInt();
        printer.start(presenter);
        Text.setSpouseWife();
        int wifeIndex = scanner.nextInt();
        presenter.setSpouse(husbandIndex-1, wifeIndex-1);
    }

    @Override
    public String getDescription() {
        return description;
    }
}
