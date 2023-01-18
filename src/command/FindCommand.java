package command;

import view.*;

public class FindCommand extends Command{

    public FindCommand(ConsoleUI view, String title, String code) {
        super(view, title, code);
    }

    @Override
    public void execute() {
        super.execute();

       view.print("Input member name: ");
       String name = view.getScanner().nextLine();
       view.getPresenter().onGetMember(name);
       view.print("");
    }
}
