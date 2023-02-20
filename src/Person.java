import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person implements Serializable, Comparable<Person> {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Sex sex;
    private ArrayList<Person> children;
    private ArrayList<Person> parents;

    private static int incrementalID = 0;

    // =====================================================================================
    // Constructors
    // не знаю уже зачем столько наделал, но удалять жалко

    public Person(Sex sex) {
        this(null, sex);
    }

    public Person(String firstname, Sex sex) {
        this(firstname, null, sex);
    }

    public Person(String firstName, String lastName, Sex sex, LocalDate dateOfBirth){
        this(firstName, lastName, dateOfBirth, null, sex);
    }

    public Person(String firstName, String lastName, Sex sex) {
        this(firstName, lastName, null, null, sex);
    }

    public Person(LocalDate dateOfBirth, LocalDate dateOfDeath, Sex sex) {
        this(null, null, dateOfBirth, dateOfDeath, sex);
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath, Sex sex) {
        id = setId();
        if (firstName == null && sex == Sex.MALE)
            this.firstName = "John";
        else if (firstName == null && sex == Sex.FEMALE)
            this.firstName = "Jane";
        else
            this.firstName = firstName;

        if (lastName == null)
            this.lastName = "Doe";
        else
            this.lastName = lastName;

        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }
    // ==================================================================================
    // Getters and Setters

    public int getId() {
        return id;
    }

    private int setId() {
        // TODO: реализовать хранение максимального id в отдельном файле или в качестве
        // ключа map к FamilyTree
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

    public Sex getSex() {
        return sex;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    // =========================================================================
    public ArrayList<Person> getSiblings() {
        ArrayList<Person> siblilings = new ArrayList<>();
        for (Person parent : parents) {
            for (Person child : parent.getChildren()) {
                if (getId() != child.getId())
                    siblilings.add(child);
            }
        }
        return siblilings;
    }

    public void addChild(Person person) {
        if (children == null)
            children = new ArrayList<>();
        if (!children.contains(person))
            children.add(person);
    }

    public void addParent(Person person) {
        if (parents == null)
            parents = new ArrayList<>();
        if (!parents.contains(person))
            parents.add(person);
    }

    public boolean isAlive() {
        if (dateOfDeath == null)
            return true;
        else
            return false;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        // Пример: 1 John Doe M 1970.01.01-1990.01.01 children: 2 John, 3 Jane
        StringBuilder strb = new StringBuilder();
        // добавляет id, имя и фамилия
        strb.append(id + " ")
                .append(firstName + " ")
                .append(lastName);
        // добавляет пол
        if (sex == Sex.MALE)
            strb.append(" M    ");
        else
            strb.append(" F    ");
        // добавляет дату рождения и смерти
        if (dateOfBirth != null) {
            strb.append(dateOfBirth);
            if (dateOfDeath != null)
                strb.append("-" + dateOfDeath);
        }
        // добавляет id и имя детей
        if (children != null && !children.isEmpty()) {
            strb.append("    children: ");
            for (int i = 0; i < children.size(); i++) {
                strb.append(children.get(i).getId() + " ")
                        .append(children.get(i).getFirstName());
                if (i != children.size() - 1)
                    strb.append(", ");
            }
        }
        return strb.toString();
    }

    @Override
    public int compareTo(Person o) {
        return firstName.compareTo(o.getFirstName());
    }
}
