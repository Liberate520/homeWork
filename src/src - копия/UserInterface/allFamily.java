package UserInterface;
import Tree.Family;
import Tree.Human;
import Tree.Serializator;

import java.util.ArrayList;
import java.util.List;

public class allFamily implements Option{
    Serializator ser = new Serializator();




    @Override
    public String description() {
        return "Посмотреть семейное древо";
    }

    @Override
    public void execute() {


        System.out.println("Показываю.........");
        System.out.println(ser.deserialization());





    }
}
