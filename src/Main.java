import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        FamilyTree tree = new FamilyTree();
        String file;
        String[] word;
        String filename = "Family_Tree_In.txt";
        Scanner sc = new Scanner(new File(filename));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (sc.hasNextLine()) {
            file = sc.nextLine();
            word = file.split(",");
            for (int i = 0; i < word.length; i++) {
                word[i] = word[i].trim();
            }
            Human name = new Human();
            name.setId(Integer.parseInt(word[0]));
            name.setName(word[2]);
            Date dateD = format.parse(word[3]);
            name.setBirthday(dateD);
            name.setGender(Gender.valueOf(word[4]));
            name.setSecondParent(word[5]);
            name.setHash(word[0].hashCode() + 3 * word[2].hashCode() + 5 * word[3].hashCode());
            //System.out.println(Arrays.toString(word));
            tree.addHuman(name);
            //System.out.println(tree.toString());
        }
        System.out.println(tree.getInfo());
    }
}