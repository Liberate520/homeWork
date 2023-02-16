import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree family = new FamilyTree();

        family.add(new Human("Иван", "Иванов"));
        family.add(new Human("Елизавета", "Попова"));
        family.add(new Human("Петр", "Иванов", family.getByName("Иван"), family.getByName("Елизавета")));
        
        System.out.print(family.getInfo());

        FamilyTree family1 = new FamilyTree();
        FileHandler file = new FileHandler();
        file.fileWrite(family);
        file.fileRead(family1);

        System.out.println(family1.getInfo());
        
    }
}
