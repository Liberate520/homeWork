// Продолжаем грейдить наш проект с гениологическим древом. Изменить древо, сделать класс параметизированным. 
// Продумать класс общения с пользователем, сделать набор команд, для операций над деревом

import java.util.List;
import java.io.Serializable;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {            

        View view = new Console();
        FamilyTreeService familyTreeService = new FamilyTreeService();
        new Presenter(view, familyTreeService); 
        view.start();
        
        // FamilyTree<Human> familyTree1 = new FamilyTree<>();
        
        // familyTree1.addHuman(new Human("Иван", Gender.male, 1950));
        // familyTree1.addHuman(new Human("Мария", Gender.female, 1949));
        // familyTree1.addHuman(
        //         new Human("Анна", Gender.female, 1971, familyTree1.getByName("Иван"), familyTree1.getByName("Мария")));
        // familyTree1.addHuman(
        //         new Human("Пётр", Gender.male, 1969, familyTree1.getByName("Иван"), familyTree1.getByName("Мария")));
        // familyTree1.addHuman(new Human("Владимир", Gender.male, 1976, familyTree1.getByName("Иван"),
        //         familyTree1.getByName("Мария")));
        // familyTree1.addHuman(new Human("Александр", Gender.male, 1970));
        // familyTree1.addHuman(new Human("Николай", Gender.male, 1999, familyTree1.getByName("Александр"),
        //         familyTree1.getByName("Анна")));
        // familyTree1.addHuman(new Human("Софья", Gender.female, 2005));
       


        
        // System.out.println("Сортировка по имени: ");

        // familyTree1.sortByName();
        // for (Human human: familyTree1){
        // System.out.println(human.getInfo());
        // }

        // System.out.println("Сортировка году рождения: ");

        // familyTree1.sortByYearBirth();
        // for (Human human: familyTree1){
        // System.out.println(human.getInfo());
        // }
    }
}
