import java.io.*;
import java.util.Collections;
import java.util.List;

public class Service implements Writable, Serializable {
    private Family family;
    InAndOut iao = new InAndOut();
    OperationsWithFamily owf;

    public Service(Family family, OperationsWithFamily owf) {
        this.family = family;
        this.owf = owf;
    }

    public void addPerson(Human human){
        family.add(human);
    }

    public Family show(){
        save(family);
        Family saved = read();
        return saved;
    }

    public Human searchMember(){
        iao.print("Enter name: ");
        String name = iao.input();
        return owf.search(name);
    }

    public Gender detectGender(String answer){
        Gender gender;
        if(answer.contains("w")){
            gender = Gender.WOMAN;
        } else {
            gender = Gender.MAN;
        }
        return gender;
    }
    public void createPerson(){
        iao.print("Name: ");
        String name = iao.input();
        iao.print("Gender (w - woman/ m - man): ");
        Gender gender = detectGender(iao.input());
        iao.print("Year birth: ");
        int yearBirth = Integer.parseInt(iao.input());
        iao.print("Fathers name: ");
        Human father = owf.search(iao.input());
        iao.print("Mothers name: ");
        Human mother = owf.search(iao.input());
        addPerson(new Human(name, gender, yearBirth, father, mother));
    }
    public List<Human> findParents(){
        Human child = searchMember();
        List<Human> res = owf.getParents(child);
        return res;
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
            iao.print("Saved");
        } catch (Exception ex) {
            iao.print(ex.getMessage());
        }
    }

    @Override
    public Family read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("family.dat"))) {
            return (Family) ois.readObject();
        } catch (Exception ex) {
            iao.print(ex.getMessage());
        }
        return null;
    }
}
