package src;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;

import javax.swing.GroupLayout.Group;
import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree familyTree = new FamilyTree();
        Service service = new Service(familyTree);
        // Human natalia = new Human("Наталия");
        // Human alexandr = new Human("Александр");
        // Human svetlana = new Human("Светлана");
        // Human sergey = new Human("Сергей");
        // Human nikita = new Human("Никита", sergey, svetlana);
        // Human ksenia = new Human("Ксения", alexandr, natalia);
        // Human mira = new Human("Мирослава", nikita, ksenia);

        service.add("Наталия");
        service.add("Александр");
        service.add("Светлана");
        service.add("Сергей");
        service.add("Никита", familyTree.getByName("Сергей"), familyTree.getByName("Светлана"));
        service.add("Ксения", familyTree.getByName("Александр"), familyTree.getByName("Наталия"));
        service.add("Мирослава", familyTree.getByName("Никита"), familyTree.getByName("Ксения"));

        // FileHandler file = new FileHandler();

        // file.outPut(familyTree);
        // FamilyTree newFamily = file.inPut();

        // newFamily.getInfo();

        
        for (Object human : service.sortByName()) {
            System.out.println(human);
        }
        System.out.println();
        System.out.println();

        for (Object human : service.sortById()) {
            System.out.println(human);
        }

    
    }
}