package src;

import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {

        FamilyTree familyTree = new FamilyTree();
    
        Human natalia = new Human("Наталия");
        Human alexandr = new Human("Александр");
        Human svetlana = new Human("Светлана");
        Human sergey = new Human("Сергей");
        Human nikita = new Human("Никита", sergey, svetlana);
        Human ksenia = new Human("Ксения", alexandr, natalia);
        Human mira = new Human("Мирослава", nikita, ksenia);

        Writable file = new FileHandler();
        // file.load();

        familyTree.addHuman(nikita, ksenia, mira);
        familyTree.addHuman(sergey, svetlana, nikita);
        familyTree.addHuman(alexandr, natalia, ksenia);

        file.save(familyTree.getTree());
        
        System.out.println(ksenia);
        file.read();
    }
}