package faminly_tree.view.add_human;
import faminly_tree.view.ConsoleUI;

public class HumanName extends HumanData{
    public HumanName(ConsoleUI console) {
        super(console);
        description = "Имя";
    }

    @Override
    public void execute() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        console.getPresenter().setHumanName(name);
    }
}
