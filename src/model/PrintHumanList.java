package model;

import java.util.List;

public class PrintHumanList implements Printable{
    @Override
    public String printer(List<Human> listToPrint) {
        String printer = "Family tree contains " + listToPrint.size() + " entities:" + "\n";
        for(Human item : listToPrint){
            printer += item.toString() + "\n";
        }
        return printer;
    }
}
