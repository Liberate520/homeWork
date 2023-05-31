import trees.Conservation;
import trees.FamilyTree;
import trees.Repository;

import java.io.File;
import java.util.Arrays;


import static trees.Trees.ruriks;

/**
 * В проекте с гениалогическим древом подумайте и используйте интерфейсы.
 * Дополнить проект методами записи в файл и чтения из файла. Для этого создать отдельный класс и реализовать в нем
 * нужные методы. Для данного класса сделайте интерфейс, который и используйте в своей программе. Например, в классе
 * дерева в качестве аргумента метода save передавайте не конкретный класс, а объект интерфейса, с помощью которого и
 * будет происходить запись. Пример работы с интерфейсом Serialazable можно найти в материалах к уроку.
 */
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

        Conservation fileHandler = new Repository(String.join(File.separator, Arrays.asList("data", "ruriksTree.bin")));

        ruriks.saveFamilyTree(fileHandler);

        FamilyTree tree = FamilyTree.readFile(fileHandler);
        System.out.println(tree);

    }
}
