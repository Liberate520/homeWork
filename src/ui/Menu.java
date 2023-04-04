package Seminar6.src.ui;

import Seminar6.src.ui.commands.*;

import java.util.ArrayList;
import java.util.List;
public class Menu {
    private final List<Commands> list;
    public Menu() {
        this.list = new ArrayList<>();
    }
    public List<Commands> getList() {
        return list;
    }

    public void menuCommand(ConsoleUi consoleUi){
        list.add(new AddNote(consoleUi));
        list.add(new DeleteNote(consoleUi));
        list.add(new PrintAllNotes(consoleUi));
        list.add(new ChangeNote(consoleUi));
        list.add(new Finish(consoleUi));


    }
    public void print(){
        System.out.println("---------------------------------");
        System.out.println("Меню состоит из следующих пунктов:");
        System.out.println("---------------------------------");
        for (int i = 0;i < list.size();i++){
            System.out.printf("%s) %s\n",i+1,list.get(i));
        }
        System.out.println();
        System.out.println("Введите соответствующий пункт меню");
    }

    public Commands fulFill(int num){
        return list.get(num);
    }

}
