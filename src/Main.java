import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Павел", "Волченко", "Александрович", GenderType.Male ));
        tree.add(new Human("Лейла", "Волченко", "Ансаровна", GenderType.Female ));
        tree.add(new Human("Вечислав", "Волченко", "Павлович", GenderType.Male, tree.getByName("Павел"), tree.getByName("Лейла")));

        System.out.println(tree.getInfo());
        System.out.println("Отсортировано по имени: ");
        tree.sortFamilyTree();
        System.out.println(tree.getInfo());
    }
}



