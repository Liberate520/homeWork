package Project_MyFamilyTree;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String filesave = "C:\Users\sc23\Documents\Учеба Разработчик\Практикум\ООП\Project_FamilyTree\FamilyTree.txt";
        Saveable saveable = new FileHendler();
        //FamilyTree humans = (FamilyTree) saveable.readMethod(filesave);

    
        Human human_1 = new Human ("Иванов Сергей Максимович", LocalDate.of(1998, 1, 11), Gender.man);
        Human human_2 = new Human("Иванов Максим Константинович", LocalDate.of(1959, 6, 8), Gender.man);
        Human human_3 = new Human("Иванова Лариса Петровна", LocalDate.of(1961, 9, 16), Gender.woman);
        Human human_4 = new Human("Иванова Ксения Сергеевна", LocalDate.of(2014, 12, 4), Gender.woman);
        Human human_5 = new Human("Иванов Данила Сергеевич", LocalDate.of(2017, 10, 29), Gender.man);
        Human human_6 = new Human("Иванова Ирина Александровна", LocalDate.of(1991, 11, 18), Gender.woman);
    
        human_1.setFather (human_2);
        human_1.setMother (human_3);
        human_4.setFather (human_1);
        human_4.setMother (human_6);
        human_5.setFather (human_1);
        human_5.setMother (human_6);

        
        List<Human> childrens_1 = new ArrayList<>();
        human_1.addChildren (human_4);
        human_1.addChildren (human_5);

        List<Human> childrens_2 = new ArrayList<>();
        human_2.addChildren (human_1);
        human_3.addChildren (human_1);

        FamilyTree humans = new FamilyTree();
        humans.addHuman (human_1);
        humans.addHuman (human_2);
        humans.addHuman (human_3);
        humans.addHuman (human_4);
        humans.addHuman (human_5);
    
        humans.findHuman ("Иванов Сергей Максимович");
    
        System.out.println (humans.getHuman ());

        humans.sortByName();
        humans.sortByAge();

        saveable.saveMethod(humans, filesave);
    }
}
