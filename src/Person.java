import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person extends DataRepository implements Serialisable {
    private static int generatorID = 1;
    private int id;
    public String firstName;
    public String lastName;
    public String birthDate;
    public String deathDate;
    public Gender gender;
    public Person mother;
    public Person father;
    public List<Person> descendants;


    /**
     * @param firstName   Имя
     * @param lastName    Фамилия
     * @param birthDate   Дата рождения
     * @param deathDate   Дата смерти
     * @param gender      Пол
     */

    public Person(String firstName, String lastName, String birthDate, String deathDate, Gender gender, Person mother, Person father){
        this.id = generatorID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        descendants = new ArrayList<>();
    }

    public Person(String firstName, String lastName, String birthDate, String deathDate, Gender gender) {
        this.id = generatorID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = null;
        this.father = null;
        descendants = new ArrayList<>();
    }

    public boolean addDescendants(Person descendant){
        if (!descendants.contains(descendant)){
            descendants.add(descendant);
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("First name: ");
        sb.append(firstName);
        sb.append(", ");
        sb.append("last name: ");
        sb.append(lastName);
        sb.append("\n");
        sb.append("birth date: ");
        sb.append(birthDate);
        sb.append(", ");
        sb.append("death date: ");
        sb.append(deathDate);
        sb.append("\n");
        sb.append(getFatherInfo());
        sb.append("\n");
        sb.append(getMotherInfo());
        sb.append("\n");
        sb.append(getDescendantInfo());
        sb.append(".");
        sb.append("\n");
        sb.append("\n");
        return sb.toString();
    }

    public String getMotherInfo(){
        String mom = "Mother: ";
        if (mother != null){
            mom += mother.getFirstName();
            mom += " ";
            mom += mother.getLastName();
        }else {
            mom += "uncnown!";
        }
        return mom;
    }

    public String getFatherInfo(){
        String dad = "Father: ";
        if (mother != null){
            dad += father.getFirstName();
            dad += " ";
            dad += father.getLastName();
        }else {
            dad += "uncnown!";
        }
        return dad;
    }

    public String getDescendantInfo(){
        StringBuilder chld = new StringBuilder();
        chld.append("Descendants: ");
        if (descendants.size() != 0){
            chld.append(descendants.get(0).getFirstName());
            chld.append(" ");
            chld.append(descendants.get(0).getLastName());
            for (int i = 1; i < descendants.size(); i++) {
                chld.append(", ");
                chld.append(descendants.get(i).getFirstName());
                chld.append(" ");
                chld.append(descendants.get(i).getLastName());
            }
        }else {
            chld.append("no descendants!");
        }
        return chld.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return Objects.equals(person.getId(), getId());
    }

    @Override
    public String toString() {

            return "Firstname: " + firstName +
                    "\nLastname: " + lastName +
                    "\nbirth date -'" + birthDate + '\'' +
                    "\ndeath date -'" + deathDate + '\'' +
                    "\nID - " + id;

    }
}
