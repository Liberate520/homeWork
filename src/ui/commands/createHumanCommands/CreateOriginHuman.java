package ui.commands.createHumanCommands;

import human.Family;
import human.Gender;
import human.Human;
import ui.Commands;
import ui.commands.setCommands.SetBirthYear;
import ui.commands.setCommands.SetName;
import ui.commands.setCommands.SetSurname;
public class CreateOriginHuman extends Commands {
    

    public CreateOriginHuman(ui.Console console) {
        super(console);
    }

    @Override
    public boolean execute() {
        String name = new SetName(console).getOption();
        String surname = new SetSurname(console).getOption();
        String birthYear = new SetBirthYear(console).getOption();
        Human<Family> human = new Human<>(name, surname, Gender.Male, Integer.parseInt(birthYear));
        ui.Console.humans.add(human);
        return true;
    }

    @Override
    public String description() {
        return "Создать первородного человека(без родителей)";
    }
    
}
