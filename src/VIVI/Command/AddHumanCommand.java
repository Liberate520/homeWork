package VIVI.Command;

import VIVI.AddHuman.AddPeopleWithScanner;
import VIVI.AddHuman.IAddHuman;
import Homework_6.Designer_Human;

public class AddHumanCommand implements ICommand {

    @Override
    public void execute() {
        Designer_Human designer_human = new Designer_Human();
        IAddHuman iAddHuman = new AddPeopleWithScanner();

        iAddHuman.addHuman(designer_human);

    }
}
