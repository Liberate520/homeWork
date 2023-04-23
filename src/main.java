import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

public class main {
    public static void main(String[] args) {
        String filePath = "src/tree.txt";
        Writeable writeable = new FileHandler();
        
        FamilyTree tree = new FamilyTree();

        Human human1 = new Human(Gender.Male, Юрий, null, null, null);
        Human human2 = new Human(Gender.Male, Екатерина, null, null, null);
        Human human3 = new Human(Gender.Male, Валерия, Екатерина, Юрий, null);
    
        writeable.save(tree,filePath);

        System.out.println(tree.getInfo());

    }
}

