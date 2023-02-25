// Продолжаем грейдить наш проект с гениологическим древом. Изменить древо, сделать класс параметизированным. 
// Продумать класс общения с пользователем, сделать набор команд, для операций над деревом

import java.util.List;
import java.io.Serializable;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree<Human> familyTree1 = new FamilyTree<>();
        
        Human human1 = new Human("Иван", Gender.male, 1950);
        Human human2 = new Human("Мария", Gender.female, 1949);
        Human human3 = new Human("Анна", Gender.female, 1971, human1, human2);
        Human human4 = new Human("Пётр", Gender.male,1969, human1, human2);
        Human human5 = new Human("Владимир", Gender.male,1976, human1, human2 );
        Human human6 = new Human("Александр", Gender.male, 1970);
        Human human7 = new Human("Николай", Gender.male,1999, human6,human3);
        Human human8 = new Human("Софья", Gender.female, 2005);

        familyTree1.addHuman(human1);
        familyTree1.addHuman(human2);
        familyTree1.addHuman(human3);
        familyTree1.addHuman(human4);
        familyTree1.addHuman(human5);
        familyTree1.addHuman(human6);
        familyTree1.addHuman(human7);
        familyTree1.addHuman(human8);
        // System.out.println(familyTree1.getAllHumanToString());
        // System.out.println(familyTree1.getChildrenToString(human1));
        // System.out.println(familyTree1.getByName("Пётр").getInfo());
        familyTree1.setFileHandler(new FileHandler());
        // familyTree1.read();
        // familyTree1.save();
        // familyTree1.read();

        for (Human human: familyTree1){
            System.out.println(human.getInfo());
        }

        System.out.println("Сортировка по имени: ");

        familyTree1.sortByName();
        for (Human human: familyTree1){
            System.out.println(human.getInfo());
        }


        System.out.println("Сортировка году рождения: ");

        familyTree1.sortByYearBirth();
        for (Human human: familyTree1){
            System.out.println(human.getInfo());
        }
    }
}
