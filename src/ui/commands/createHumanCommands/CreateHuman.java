package ui.commands.createHumanCommands;

import human.Family;
import human.Gender;
import human.Human;
import ui.Commands;
import ui.Console;
import ui.commands.setCommands.SetBirthYear;
import ui.commands.setCommands.SetHuman;
import ui.commands.setCommands.SetName;
import ui.commands.setCommands.SetSurname;
public class CreateHuman extends Commands {
    

    public CreateHuman(ui.Console console) {
        super(console);
    }

    @Override
    public boolean execute() {
        String name = new SetName(console).getOption();
        String surname = new SetSurname(console).getOption();
        String birthYear = new SetBirthYear(console).getOption();
        System.out.println("В качестве родителя ");
        Integer parentIndex1 = new SetHuman(console).getIndex();
        System.out.println("В качестве родителя ");
        Integer parentIndex2 = new SetHuman(console).getIndex();
        Human<Family> human = new Human<>(name, surname, Gender.Male,
             Integer.parseInt(birthYear), Console.humans.get(parentIndex1),
             Console.humans.get(parentIndex2));
        Console.humans.add(human);
        return true;
    }

    @Override
    public String description() {
        return "Создать человека";
    }
    
}
