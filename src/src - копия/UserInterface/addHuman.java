package UserInterface;

import Tree.Family;
import Tree.Human;
import Tree.Serializator;

import java.util.Scanner;

public class addHuman implements Option{
        Family family = new Family();
        Human hm = new Human();
        Serializator serializator = new Serializator();

        @Override
        public String description() {
                return "Добавить члена семьи";
        }

        @Override
        public void execute() {
                family.addHuman(new Human());
                serializator.serialization(family);
                System.out.println(family);


                System.out.println("Добавлен..................");



        }
}
