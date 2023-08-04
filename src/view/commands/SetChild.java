package view.commands;

import presenter.Presenter;
import view.Text;

import java.util.Scanner;

public class SetChild implements Command{
    String description = "Set child";
    @Override
    public void start(Presenter presenter) {
        TreePrinter printer = new TreePrinter();
        Scanner scanner = new Scanner(System.in);
        printer.start(presenter);
        Text.setChildParent();
        int parentIndex = scanner.nextInt();
        printer.start(presenter);
        Text.setChildChild();
        int childIndex = scanner.nextInt();
        presenter.setChild(parentIndex-1, childIndex-1);
    }

    @Override
    public String getDescription() {
        return description;
    }
}
