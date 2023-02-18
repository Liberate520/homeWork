package homeWork;
import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Иван", "Иванов", "Николаевич", GenderType.муж ));
        tree.add(new Human("Валентина", "Иванова", "Петровна", GenderType.жен ));
        tree.add(new Human("Александра", "Иванова", "Ивановна", GenderType.жен, tree.getByName("Иван"), tree.getByName("Валентина"))); 
        tree.add(new Human("Ольга", "Иванова", "Ивановна", GenderType.жен, tree.getByName("Иван"), tree.getByName("Валентина"))); 
        // System.out.println(tree.getInfo());

        // FileHandler fileHandler = new FileHandler(tree);
        // fileHandler.write(tree);
        // fileHandler.read();
        
        System.out.println(tree.getInfo());
        System.out.println("Отсортировано по имени: ");
        tree.sortFamilyTree();
        System.out.println(tree.getInfo());
    }
}




