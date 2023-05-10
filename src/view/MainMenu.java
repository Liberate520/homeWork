package view;

import view.commands.*;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    private Map<Integer, Command> commands;
    private Console console;

    public MainMenu(Console console) {
        this.console = console;
        this.commands = new HashMap<>();
        fillHashTable();
    }

    private void fillHashTable() {
        Exit exit = new Exit(this.console);
        AddPerson addPerson = new AddPerson(this.console);
        DeletePerson deletePerson = new DeletePerson(this.console);
        GetFamilyTree getFamilyTree = new GetFamilyTree(this.console);
        WriteInFile writeInFile = new WriteInFile(this.console);
        ReadFromFile readFromFile = new ReadFromFile(this.console);
        commands.put(exit.getNumber(), exit);
        commands.put(addPerson.getNumber(), addPerson);
        commands.put(deletePerson.getNumber(), deletePerson);
        commands.put(getFamilyTree.getNumber(), getFamilyTree);
        commands.put(writeInFile.getNumber(), writeInFile);
        commands.put(readFromFile.getNumber(), readFromFile);
    }

    public void printMenu() {
      for (Command command : commands.values()) {
          System.out.println(command.getDescription());
      }
    }

    public void execute(Integer number) {
        this.commands.get(number).execute();
    }

    public int getNumberOfCommands(){
        return this.commands.size();
    }
}
