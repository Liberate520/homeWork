import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
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
                    Human name = new Human();
                    name.setId(Integer.parseInt(word[0]));
                    name.setName(word[2]);
                    name.setBirthday(LocalDate.parse(word[3]));
                    name.setGender(Gender.valueOf(word[4]));
                    name.setSecondParent(word[5]);
                    for (Human el: name) {

                    }
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