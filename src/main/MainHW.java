package main;
import java.io.IOException;
import java.io.Serializable;

import file.DataSave;
import human1.Human;
import tree1.FamilyTree;


public class MainHW implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataSave data = new DataSave();
        FamilyTree familyTree1 = new FamilyTree();
        Serviсe service = new Serviсe(familyTree1);
        
        service.add(new Human(1, "Анна", null, null)); 
        service.add(new Human(2, "Петр", null, null)); 
        service.add(new Human(3, "Миша", familyTree1.getByName("Анна"), familyTree1.getByName("Петр"))); 
        service.add(new Human(4, "Оля", familyTree1.getByName("Анна"), familyTree1.getByName("Петр")));

        System.out.println(familyTree1);
        service.sortByName();
        System.out.println("Отсортированный список по фамилии: ");
        for(Human item : familyTree1) {
            System.out.println(item);
        }
        System.out.println();
        service.sortById();
        System.out.println("Отсортированный список по id: ");
        for(Human item : familyTree1) {
            System.out.println(item);
        }

        data.save(familyTree1,"fileTree.txt");
        data.read("fileTree.txt");
        }
        
}