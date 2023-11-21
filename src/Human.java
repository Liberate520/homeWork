import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother, father;
    private List<Human> children;

    public Human(String firstName, String lastName, LocalDate birthDate, Sex sex, Human mother, Human father, List<Human> children, LocalDate deathDate) {
        this.id = 0; 
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.deathDate = deathDate;
    }
    
    public Human(String firstName, String lastName, LocalDate birthDate, Sex sex, Human mother, Human father, List<Human> children) {
        this(firstName, lastName, birthDate, sex, mother, father, children, null);
    }

    public Human(String firstName, String lastName, LocalDate birthDate, Sex sex, Human mother, Human father) {
        this(firstName, lastName, birthDate, sex, mother, father, new ArrayList<Human>(), null);
    }

    public Human(String firstName, String lastName, LocalDate birthDate, Sex sex) {
        this(firstName, lastName, birthDate, sex, null, null, new ArrayList<Human>(), null);
    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public LocalDate getDeathDate() {
        return this.deathDate;
    }

    public Human getFather() {
        return this.father;
    }

    public Sex getSex() {
        return this.sex;
    }

    public Human getMother() {
        return this.mother;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            this.children.add(child);
            return true;
        }
        return false;
    }

    public boolean setDeathDate(LocalDate deathDate) {
        if (this.deathDate != null) {
            this.deathDate = deathDate;
            return true;
        }
        return false;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean setMother(Human mother) {
        if (this.mother == null) {
            this.mother = mother;
            return true;
        }
        return false;
    }

    public boolean setFather(Human father) {
        if (this.father == null) {
            this.father = father;
            return true;
        }
        return false;
    }

    public int getChildrenAmount() {
        return this.children.size();
    }

    public int getAge() {
        LocalDate compareDate;
        if (this.deathDate == null) compareDate = LocalDate.now();
        else compareDate = this.deathDate;

        return Period.between(this.birthDate, compareDate).getYears();  
    }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        fullName.append(this.firstName).append(" ")
            .append(this.lastName);
        return fullName.toString();
    }

    private String getChildrenNames() {
        StringBuilder childrenNames = new StringBuilder();
        for (Human child : this.children) {
            childrenNames.append(child.getFullName()).append("\n");
        }
        return childrenNames.toString();
    }
    
    private String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ").append(this.id)
        .append("\nfirst name: ").append(this.firstName)
        .append("\nlast name: ").append(this.lastName)
        .append("\nsex: ").append(this.sex)
        .append("\nbirth date: ").append(this.birthDate.toString())
        .append("\ndeath date: ").append(this.deathDate.toString())
        .append("\nmother: ").append(this.mother.getFullName())
        .append("\nfather: ").append(this.father.getFullName())
        .append("\nchildren: ").append(this.getChildrenNames());
        return info.toString();
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human) {
            Human e = (Human) obj;
            return this.id == e.getId();
        }
        return false;
    }
}