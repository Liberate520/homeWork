import trees.Conservation;
import trees.FamilyTree;
import trees.FamilyTreeRepository;
import trees.Human;

import java.io.File;
import java.util.Arrays;

import static trees.Trees.ruriks;


public class Main {
    public static void main(String[] args) {

        ruriks.showParents("Рюрик", 879);
        ruriks.showChildren("Рюрик", 879);
        ruriks.showChildren("Игорь", 945);
        ruriks.showChildren("святослав", 972);
        ruriks.showParents("святослав", 972);
        System.out.println(ruriks.getPersonFromTree("Ольга", 969));
        System.out.println(ruriks.getPersonFromTree("игорь", 945));
        ruriks.showParents("Борис", 1078);
        ruriks.showParents("Борис", 1015);

        Conservation fileHandler = new FamilyTreeRepository(String.join(File.separator, Arrays.asList("data", "ruriksTree.bin")));

        ruriks.saveFamilyTree(fileHandler);

        ruriks.readFile(fileHandler);


    }
}
