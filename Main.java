
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Иван", "Иванов", "Николаевич", GenderType.муж ));
        tree.add(new Human("Валентина", "Иванова", "Петровна", GenderType.жен ));
        tree.add(new Human("Мария", "Иванова", "Ивановна", GenderType.жен, tree.getByName("Иван"), tree.getByName("Валентина"))); 
        tree.add(new Human("Ольга", "Иванова", "Ивановна", GenderType.жен, tree.getByName("Иван"), tree.getByName("Валентина"))); 
        // System.out.println(tree.getInfo());

        FileHandler fileHandler = new FileHandler(tree);
        fileHandler.write(tree);
        fileHandler.read();
        
    }
}




