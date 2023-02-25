package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Person extends BasicEntity {
    private String lastName;
    private LocalDate dateOfDeath;
    private Sex sex;
    private ArrayList<Person> children;
    private ArrayList<Person> parents;

    // ==================================================================================
    // Constructors

    public Person(String firstName, Sex sex, LocalDate dateOfBirth) {
        this(firstName, null, sex, dateOfBirth);
    }

    public Person(String firstName, Sex sex, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this(firstName, null, sex, dateOfBirth, dateOfDeath);
    }

    public Person(String firstName, String lastName, Sex sex, LocalDate dateOfBirth) {
        this(firstName, lastName, sex, dateOfBirth, null);
    }

    public Person(String firstName, String lastName, Sex sex, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        super(firstName, dateOfBirth);
        this.lastName = lastName;
        this.dateOfDeath = dateOfDeath;
        this.sex = sex;
    }

    // ==================================================================================
    // Getters and Setters

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setPaternalLastName() {
        if (lastName == null) {
            for (Person parent : parents) {
                if (parent.getSex() == Sex.MALE) {
                    lastName = parent.getLastName();
                    break;
                }
            }
        }
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
    // ==================================================================================

    private void addChild(Person person) {
        if (children == null)
            children = new ArrayList<>();
        if (!children.contains(person))
            children.add(person);
    }

    public void addParents(Person... people) {
        if (parents == null)
            parents = new ArrayList<>();
        for (Person person : people) {
            if (!parents.contains(person)) {
                parents.add(person);
                person.addChild(this);
            }
        }
        setPaternalLastName();
    }

    public boolean isAlive() {
        if (dateOfDeath == null)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        // Пример: 1 John Doe M 1970.01.01-1990.01.01 children: 2 John, 3 Jane
        StringBuilder strb = new StringBuilder();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        // добавляет id, имя и фамилия
        strb.append(super.getId() + ". ")
            .append(super.getName() + " ");
        if (lastName != null)
            strb.append(lastName + " ");
        // добавляет пол
        if (sex == Sex.MALE)
            strb.append("M    ");
        else
            strb.append("F    ");
        // добавляет дату рождения и смерти
        if (super.getDateOfBirth() != null) {
            strb.append(super.getDateOfBirth().format(dateFormat));
            if (dateOfDeath != null)
                strb.append(" - " + dateOfDeath.format(dateFormat));
        }
        // добавляет id и имя детей
        if (children != null && !children.isEmpty()) {
            strb.append("    children: ");
            for (int i = 0; i < children.size(); i++) {
                strb.append(children.get(i).getId() + ". ")
                        .append(children.get(i).getName());
                if (i != children.size() - 1)
                    strb.append(", ");
            }
        }
        return strb.toString();
    }
}
