import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Human {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender sex;
    private ArrayList<Human> children;
    private ArrayList<Human> parents;

    private static int incrementalID = 0;

    public Human(Gender sex){
        this(null, sex);
    }

    public Human(String firstname, Gender sex){
        this(firstname, null, sex);
    }

    public Human(String firstName, String lastName, Gender sex){
        this(firstName, lastName, null, null, sex);
    }

    public Human(LocalDate dateOfBirth, LocalDate dateOfDeath, Gender sex){
        this(null, null, dateOfBirth, dateOfDeath, sex);
    }

    public Human(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender sex) {
        id = setId();
        if (firstName == null && sex == Gender.MALE) this.firstName = "John";
        else if (firstName == null && sex == Gender.FEMALE) this.firstName = "Jane";
        else this.firstName = firstName;

        if (lastName == null) this.lastName = "Doe";
        else this.lastName = lastName;

        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    private int setId() {
        incrementalID++;
        return incrementalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Gender getSex() {
        return sex;
    }    

    public ArrayList<Human> getChildren() {
        return children;
    }

    public ArrayList<Human> getParents() {
        return parents;
    }

    public ArrayList<Human> getSiblings(){
        ArrayList<Human> siblilings = new ArrayList<>();
        for (Human parent : parents) {
            for (Human child : parent.getChildren()) {
                if (getId() != child.getId()) siblilings.add(child);
            }
        }
        return siblilings;
    }

    public void addChild(Human person) {
        if (children == null) children = new ArrayList<>();
        if (!children.contains(person)) children.add(person);
    }
    public void addParent(Human person){
        if (parents == null) parents = new ArrayList<>();
        if (!parents.contains(person)) parents.add(person);
    }

    public boolean isAlive(){
    if (dateOfDeath == null) return true;
    else return false;
    }

    public int getAge(){
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString(){
        StringBuilder strb = new StringBuilder();
        strb.append(id + " ")
            .append(firstName + " ")
            .append(lastName);
        if (sex == Gender.MALE) strb.append(" M    ");
        else strb.append(" F    ");
        if (dateOfBirth != null) {
            strb.append(dateOfBirth);
            if (dateOfDeath != null) strb.append("-" + dateOfDeath);
        }
        if (children != null && !children.isEmpty()){
            strb.append("    children: ");
            for (int i = 0; i < children.size(); i++) {
                strb.append(children.get(i).getId() + " ")
                    .append(children.get(i).getFirstName());
                if (i != children.size()-1) strb.append(", ");
            }
        }
        return strb.toString();
    }
}