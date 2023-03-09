package src.UI;

import src.UI.commands.*;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList();
        commands.add(new Quit(console));
        commands.add(new PrintingListOfPersons(console));
        commands.add(new YearsOfTheReignOfPersons(console));
        commands.add(new FindParents(console));
        commands.add(new FindSpouse(console));
        commands.add(new GetPersonByName(console));
        commands.add(new AddPerson(console));
        commands.add(new AddWifeToHusband(console));
        commands.add(new AddChildToMother(console));
        commands.add(new RemotePerson(console));
        commands.add(new Load(console));
        commands.add(new Save(console));
        }

        void execute(int num){
            Option option = commands.get(num);
            option.execute();
        }

        public String printMenu(){
            StringBuilder strMenu = new StringBuilder("\n\t--- COMMAND  MENU ---\nEnter the command number ( 0 - ");
            strMenu.append(commands.size()-1).append(" ):\n\n");
            for (int i = 0; i < commands.size(); i++) {
                strMenu.append(i);
                strMenu.append(": ");
                strMenu.append(commands.get(i).description());
                strMenu.append("\n");
            }
            return strMenu.toString();
        }
    }