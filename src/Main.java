import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        String file = "";
        String[] word = new String[]{};
        try {
            Scanner sc = new Scanner(new File("./Family_Tree_In.txt"));
            while (sc.hasNextLine()) {
                file = sc.nextLine();
                word = file.split(",");
                String lst = "";
                for (int i = 0; i < word.length; i++) {
                    word[i] = word[i].trim();
                    lst = lst + word[i] + " ";
                    //System.out.println(i + "  " + word[i]);
                }
                System.out.println(lst);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}