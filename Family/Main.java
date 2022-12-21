package JavaOOP.Family;

import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
   public static final String FILE_PATH= "file.txt";

    public static void main(String[] args) {

        FamilyTree familyTree=new FamilyTree();
        Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("\u001B[35m");
                System.out.println("1 - Добавить нового человека");
                System.out.println("2 - Показать конкретного человека");
                System.out.println("3 - Показать древо для выбранного человека");
                System.out.println("4 - Добавить родсвенные связи между людьми");
                System.out.println("5 - Выберете человека, с которым хотите создать древо");
                System.out.println("6 - Сохранить текущее древо в файл");
                System.out.println("7 - Очистить семейное древо");
                System.out.println("8 - Сохранить текущих членов семейного древа в файл");
                System.out.println("9 - Прочитать данные из файла");
                System.out.println("0 - Выйти из приложения");
                final String next = scanner.next();
                if (next.equals("1")) {
                    familyTree.addPerson(scanner);
                }
                if (next.equals("2")) {
                    familyTree.selectPersonToDisplay(scanner);
                }
                if (next.equals("3")) {
                   familyTree.showTreeForTakenPerson(scanner);
                }
                if (next.equals("4")) {
                    familyTree.addingRelation(scanner);

                }
                if (next.equals("5")) {
                    familyTree.showListOfPersonToSelectNodeOfFamilyTree(scanner);

                }
                if(next.equals("6")){
                    familyTree.saveTreeToFile(familyTree.nodeOfTree,0);
                }
                if(next.equals("7")){
                    familyTree.clearFamilyTree();
                }
                if(next.equals("8")){
                    familyTree.saveCurrentFamilyMembersToFile(scanner);
                }
                if(next.equals("9")){
                    familyTree  = familyTree.readDataFromFile(scanner);
                }
                if (next.equals("0")) {
                    break;
                }
            }
            scanner.close();

    }
    public static FamilyTree readFile()throws IOException {
        FamilyTree familyTree = new FamilyTree();

            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;

            while ((line = br.readLine()) != null) {
                String[] humans = line.split(";");
                if (getCorrectSex(humans[2]) == null) {
                    System.out.println("Incorrect data of person in file!");
                    System.out.println();
                } else {
                    Human p1 = new Human(Integer.parseInt(humans[0]), humans[1], getCorrectSex(humans[2]));
                    familyTree.humans.add(p1);
                }

            }
            fileInputStream.close();
            br.close();
        return familyTree;
    }
    public static Gender getCorrectSex(String gender){
        if(gender.equals("m"))
            return Gender.MAN;
        else if(gender.equals("f"))
            return Gender.WOMAN;
        return null;
    }

}
