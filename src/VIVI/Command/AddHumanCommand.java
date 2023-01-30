package VIVI.Command;

import VIVI.AddHuman.AddPeopleWithJOptionPane;
import VIVI.AddHuman.IAddHuman;
import Homework_6.Designer_Human;
import VIVI.AddHuman.IAddHumanSimple;

public class AddHumanCommand implements ICommand {

    @Override
    public void execute() {
//        Designer_Human designer_human = new Designer_Human();
        IAddHumanSimple iAddHuman = new AddPeopleWithJOptionPane();
        iAddHuman.addHumanSimple();

    }
}
