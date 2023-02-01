package VIVI.Command;

import VIVI.AddHuman.AddPeopleWithJOptionPane;
import VIVI.AddHuman.IAddHuman;
import Homework_6.Designer_Human;
import VIVI.AddHuman.IAddHumanSimple;

public class AddHumanCommand implements ICommand {

    @Override
    public void execute() {
        IAddHumanSimple iAddHuman = new AddPeopleWithJOptionPane();
        iAddHuman.addHumanSimple();

    }
}
