package model.allcommands;



import model.treeWork.Human;

import java.util.ArrayList;
import java.util.List;

public class Command {

    String name;
    Human human;

    

    List<Option> commandLlistWork = new ArrayList<>();

    public void creatyCommand() {
        this.commandLlistWork.add(new CreateTreeHuman());
        this.commandLlistWork.add(new ReadFiles());
        this.commandLlistWork.add(new WriteFiles());
        this.commandLlistWork.add(new AddHuman(human));
        this.commandLlistWork.add(new PrintAll());
        this.commandLlistWork.add(new FindByName(name));
        this.commandLlistWork.add(new SortByName());

    }

    public List<Option> getCommandLlistWork() {
        return commandLlistWork;
    }

    public  void printComand() {

       Command test = new Command();
        test.creatyCommand();
        for (int i = 0; i < test.getCommandLlistWork().size(); i++) {
            System.out.println(i + ": " + test.getCommandLlistWork().get(i).discription());

        }
        System.out.println("7:- Выход");

    }

    public  void creatTreeHum() {
        Command test = new Command();
        test.creatyCommand();
        test.getCommandLlistWork().get(0).execute();;
        System.out.println("Древо создано и заполнено по умолчанию ");

    }

    public  void printAll() {
        Command test = new Command();
        test.creatyCommand();
        test.getCommandLlistWork().get(4).execute();;
    }

}
