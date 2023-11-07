package family_tree;

import family_tree.writer.FileHandler;

import java.io.File;
import java.time.LocalDate;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String nameFile = "tree.txt";
        String path = "src/family_tree/writer/";
        String filePath = path + nameFile;

        if (isFileExists(filePath)){
            FamilyTree tree = load(filePath);

            System.out.println(tree);
            tree.sortByName();
            System.out.println(tree);
            tree.sortByBirth();
            System.out.println(tree);
        }
        else {
            System.out.println("File not exist");
        };

//        FamilyTree tree = familyTree();
//        System.out.println(tree);
//        save(tree, filePath);
    }

    private static void save(FamilyTree tree, String filePath) {
        FileHandler fileHandler = new FileHandler();
        //String filePath = "src/family_tree/writer/tree.txt";
        fileHandler.save(tree,filePath);
    }

    private static FamilyTree load(String filePath) {
        FileHandler fileHandler = new FileHandler();
        //String filePath = "src/family_tree/writer/tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }

    public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.isFile();
    }

    public class CLS {
        public static void main(String... arg) throws IOException, InterruptedException {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
    static FamilyTree familyTree(){
        FamilyTree tree = new FamilyTree();

        Human m1 = new Human("Ivan",Gender.male, LocalDate.of(1970,2,23));
        Human f1 = new Human("Svetlana", Gender.female,LocalDate.of(1975,5,16));
        tree.add(m1);
        tree.add(f1);

        Human m2 = new Human("Pavel",Gender.male, LocalDate.of(1990,7,13),m1,f1);
        Human f2 = new Human("Masha", Gender.female,LocalDate.of(1993,1,31),m1,f1);
        tree.add(m2);
        tree.add(f2);

        Human m3 = new Human("Georgiy",Gender.male, LocalDate.of(1941,4,3),LocalDate.of(1996,8,31),null,null);
        m3.addKid(f1);
        tree.add(m3);

        return tree;
    }

}