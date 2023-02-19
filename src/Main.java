import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree family = new FamilyTree();

        family.add(new Human("Иван", "Иванов", 1964, 0, 25));
        family.add(new Human("Елизавета", "Попова", 1966, 5, 2));
        family.add(new Human("Петр", "Иванов", family.getByName("Иван"), family.getByName("Елизавета"), 1998, 6, 15));
        
        System.out.print(family.getInfo());

        FamilyTree family1 = new FamilyTree();
        FileHandler file = new FileHandler();
        file.fileWrite(family);
        file.fileRead(family1);
        
        family1.sortByName();

        for(Human human: family1){
            System.out.println(human);
        }
        
        family1.sortByDate();
        
        for(Human human: family1){
            System.out.println(human);
        }
    }
}
