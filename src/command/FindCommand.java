package command;

import view.*;

public class FindCommand extends Command{

    public FindCommand(ConsoleUI view, String title, String code) {
        super(view, title, code);
    }

    @Override
    public Boolean execute(String execCode) {
       if (execCode.equals(code)) {
           String name = view.getAnswer("Input member name: ");
           view.getPresenter().onGetMember(name);
           view.print("");
           return true;
       }
       return false;
    }
}
