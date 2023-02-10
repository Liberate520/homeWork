import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.io.Serializable;

public class FileHandler<T extends People> implements WritableFile, Serializable {

    private Family<T> family;
    private String filePath;
    private Family<T> list;
    private Family<T> familyTree;
    private Family<T> familyTreeView;
    private Family<T> inputOutput;

    public FileHandler (Family<T> family, String filePath) {
        this.filePath = filePath;
        this.family = family;
    }

    public void searchPeople(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        People serch = family.search(name);
        System.out.println(serch);
    }
    // public void createPerson(){
    //     Scanner scan = new Scanner(System.in);
    //     System.out.println("Name: ");
    //     String name = scan.nextLine();
    //     System.out.println("Gender (w - woman/ m - man): ");
    //     String genderStr = scan.nextLine();
    //     Gender gender;
    //     if(genderStr.contains("w")){
    //         gender = Gender.WOMAN;
    //     } else {
    //         gender = Gender.MAN;
    //     }

    //     System.out.println("Year birth: ");
    //     int yearBirth = Integer.parseInt(scan.nextLine());
    //     System.out.println("Fathers name: ");
    //     String fatherStr = scan.nextLine();
    //     People father = family.search(fatherStr);// если нет имени то вернуть пусто или создать Human father
    //     System.out.println(father);
    //     System.out.println("Mothers name: ");
    //     String motherStr = scan.nextLine();
    //     People mother = family.search(motherStr);

    //     addPeople(new People(name, sex, yearBirth, father, mother));
    // }


    // public void addPeople(T people){
    //     family.add(people);
    // }
    
    // public void sortByName() {
    //     Collections.sort(family.getFamMembers());
    // }

    // public void sortByDate() {
    //     Collections.sort(family.getFamMembers(), new HumanComparatorasortByDate());
    // }

    // public void loadFromBin() {
    //     list = inputOutput.loadFromBin(filePath);
    //     familyTreeView.showLoadTree(list);
    // }

    // public int getValueFromView() {
    //     return ViewFamilyTree.getValue();
    // }

    // public static void menu() {
    //     ViewFamilyTree.startView();
    // }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("family-tree.bin"))) {
            outputStream.writeObject(serializable);
            System.out.println("File saved ...");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public Family readFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("family-tree.bin"))) {
            return (Family) inputStream.readObject();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
