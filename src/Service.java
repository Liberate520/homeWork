import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class Service implements Writable, Serializable {
    private Family family;

    public Service(Family family) {
        this.family = family;
    }

    public void addPerson(Human human){
        family.add(human);

    }
    public void searchMember(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        Human serch = family.search(name);
        System.out.println(serch);
    }
    public void createPerson(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scan.nextLine();
        System.out.println("Gender (w - woman/ m - man): ");
        String genderStr = scan.nextLine();
        Gender gender;
        if(genderStr.contains("w")){
            gender = Gender.WOMAN;
        } else {
            gender = Gender.MAN;
        }
        System.out.println("Year birth: ");
        int yearBirth = Integer.parseInt(scan.nextLine());
        System.out.println("Fathers name: ");
        String fatherStr = scan.nextLine();
        Human father = family.search(fatherStr);// если нет имени то вернуть пусто или создать Human father
        System.out.println(father);
        System.out.println("Mothers name: ");
        String motherStr = scan.nextLine();
        Human mother = family.search(motherStr);
        addPerson(new Human(name, gender, yearBirth, father, mother));
    }


    public void sortByName() {
        Collections.sort(family.getMembers());
    }

    public void sortByYearBirth() {
        Collections.sort(family.getMembers(), new HumanComparatorYearBirth());
    }


    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.dat"))) {
            oos.writeObject(serializable);
             System.out.println("Saved");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public Family read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("family.dat"))) {
            return (Family) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
