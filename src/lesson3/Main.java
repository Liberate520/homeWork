package lesson3;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        FamilyTree tree = new FamilyTree();
        ReadWritable fileHandler = new FileHandler("familydata");
        //tree = (FamilyTree) fileHandler.read();
        tree.add(new Human("Vasily", Gender.MALE, new SimpleDateFormat( "yyyy" ).parse( "1991" )));
        tree.add(new Human("Mary", Gender.FEMALE, new SimpleDateFormat( "yyyy" ).parse( "1990" )));
        tree.add(new Human("Christine", Gender.FEMALE, new SimpleDateFormat( "yyyy" ).parse( "2011" ), tree.getByName("Vasily"), tree.getByName("Mary")));
        tree.add(new Human("Semen", Gender.MALE, new SimpleDateFormat( "yyyy" ).parse( "2010" ), tree.getByName("Vasily"), tree.getByName("Mary")));
        fileHandler.write(tree);
        tree.sortByName();
        for(Human human : tree){
            System.out.println(human.getInfo());
        }
        tree.sortByBirthDate();
        System.out.println(tree.getInfo());
    }
}
