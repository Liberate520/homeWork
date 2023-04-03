import javax.imageio.IIOException;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {

    private String name;
    private String surname;
    private String dateBirth;
    private String dateDeath;
    private String maidenName;

    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> childList;

    private final String nameRegex = "^[\\p{L} .'-]+$";

    public Human(String name, String surname, Gender gender, String dateBirth) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.gender = gender;

        this.father = null;
        this.mother = null;
        this.maidenName = "";
        this.childList = new ArrayList<>();
    }

    public Human() {
        this.name = "unknown";
        this.surname = "unknown";
        this.dateBirth = "unknown";
    }

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.father = null;
        this.mother = null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getDateBirth() {
        return this.dateBirth;
    }

    public String getDateDeath() {
        return dateDeath;
    }

    public List<Human> getChildList() {
        System.out.println(getName() + " " + getSurname() + " дети: ");
        return childList;
    }

//    public String getChild() {
//        System.out.println("*".repeat(30));
//        StringBuilder child = new StringBuilder(getName() + " " + getSurname() + " дети: \n");
//        for (Human human: this.childList) {
//            child.append(human + "\n");
//        }
//        return child.toString();
//    }

    public int getAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateBirth, formatter);
        return Period.between(date, currentDate).getYears();

    }

    public int numChildren() {
        return getChildList().size();
    }

    public String getMaidenName() {
        return this.maidenName;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }


    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.name = name;
        }
    }

    public void setSurname(String surname) {
        if (surname.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.surname = surname;
        }
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setDateBirth(String dateBirth) {
        if (dateBirth.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.dateBirth = dateBirth;
        }
    } public void setDateDeath(String dateDeath) {
        if (dateDeath.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.dateDeath = dateDeath;
        }
    }

    public void setMaidenName(String maidenName) {
        if (maidenName.trim().matches(nameRegex)) {
            if (this.gender == Gender.Male) {
                this.maidenName = maidenName.trim();
            } else {
                throw new IllegalArgumentException("Девичья фамилия для женщин");
            }
        } else if (maidenName.isEmpty()) {
            this.maidenName = "";
        } else {
            throw new IllegalArgumentException("Неверно задана фамилия");
        }

    }

    public void setChildList(List<Human> childList) {
        this.childList = childList;
    }

    public void addChild(Human child) {
        childList = new ArrayList<>();
        this.childList.add(child);
     }

    public String getInfo() {
        System.out.println("*".repeat(30));
        StringBuilder human = new StringBuilder();
        human.append(name).append(" ")
                .append(surname).append(", ")
                .append(getFather()).append(", ")
                .append(getMother()).append(", ")
                .append(getChildList());

        return human.toString();
    }

    public String getChild() {
        System.out.println("*".repeat(30));
        StringBuilder child = new StringBuilder("дети: \n");
        if (childList.size() != 0) {
            child.append(childList.get(0).getName());
            for (Human human: this.childList) {
                child.append(human + "\n"); }
        } else {
            child.append("без детей");
        }
        return child.toString();
    }

    @Override
    public String toString() {
        return this.name +  " " + this.surname + " " +
                "Пол: " + getGender() + " " +
                "Возраст: " + getAge() + " лет " + "\n" + "Отец: " + getFather() + "Мать: " + getMother();
    }
//
//    @Override
//    public void save(Writable serializable) throws IOException {
//        try (FileOutputStream fos = new FileOutputStream("out.txt");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(serializable);
//        }
//        catch (IIOException ex) {
//            ex.printStackTrace(System.out);
//        }
//    }
//
//    @Override
//    public Writable load() throws ClassNotFoundException, InvalidObjectException {
//        try (FileInputStream fis = new FileInputStream("out.txt");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            Writable object = (Human) ois.readObject();
//            return object;
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//        }
//        throw new InvalidObjectException("Object fail");
//    }











}
