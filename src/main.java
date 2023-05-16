import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

public class main {
    private static final Human Юрий = null;
    private static final Human Екатерина = null;
    private static final Human Валерия = null;

    public static void main(String[] args) throws IOException {
        String filePath = "src/tree.txt";
        ReadWrite writeable = (ReadWrite) new FileHandler();
        
        FamilyTree tree = new FamilyTree();

        Human human1 = new Human(Gender.Male, Юрий, null, null, null);
        Human human2 = new Human(Gender.Male, Екатерина, null, null, null);
        Human human3 = new Human(Gender.Male, Валерия, Екатерина, Юрий, null);
    
        writeable.write(tree,filePath);

        System.out.println(tree.getInfo());

    }
}

