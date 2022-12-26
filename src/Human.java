import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Human {
    private String uuid;
    private String name;
    private String lastName;
    private String secondName;
    private Gender gender;
    private Human spouse;
    private Human parentFather;
    private Human parentMother;
    private int generation = 0;
    private List<Human> children;

    public Human(String lastName, String name, String secondName, Gender gender) {
        this.uuid = UUID.randomUUID().toString();
        this.secondName = secondName;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Human(String lastName, String name, String secondName, Gender gender, Human parentFather, Human parentMother) {
        this(lastName, name, secondName, gender);
        this.parentFather = parentFather;
        this.parentMother = parentMother;
    }

    @Override
    public String toString() {
        
        String text = "";
        if (this.children  != null) {
            for (Human hum : this.children) {
                text = text + hum.getFIOtoString() + "\n";
            }
        }

        return this.getFIOtoString() + "\n"
            + "пол: " + (gender == Gender.MAN ? "мужской" : "женский") + "\n"
            + "отец: " + (this.parentFather != null ? this.parentFather.getFIOtoString() : "отсутствует") + "\n"
            + "мать: " + (this.parentMother != null ? this.parentMother.getFIOtoString() : "отсутствует")
            + (text.length() > 0 ? "\nдети:\n" + text : "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setParentFather(Human parentFather) {
        if (this.parentFather != null) {
            List<Human> childParentFather = new ArrayList<>(this.parentFather.getChildren());
            childParentFather.remove(this);
            this.parentFather.setChildren(childParentFather);
        }
        
        this.parentFather = parentFather;
        if (this.generation == 0) {
            this.generation = parentFather.getGeneration() + 1;
        }
        
        List<Human> childNewFather = new ArrayList<>();

        if (parentFather.getChildren() != null) {
            for (Human human : parentFather.getChildren()) {
                childNewFather.add(human);
            }
        }

        childNewFather.add(this);
        parentFather.setChildren(childNewFather);
    }

    public void setParentMother(Human parentMother) {
        if (this.parentMother != null) {
            List<Human> childParentMother = new ArrayList<>(this.parentMother.getChildren());
            childParentMother.remove(this);
            this.parentMother.setChildren(childParentMother);
        }
        
        this.parentMother = parentMother;
        if (this.generation == 0) {
            this.generation = parentFather.getGeneration() + 1;
        }

        List<Human> childNewMother = new ArrayList<>();

        if (parentMother.getChildren() != null) {
            for (Human human : parentMother.getChildren()) {
                childNewMother.add(human);
            }
        }

        childNewMother.add(this);
        parentMother.setChildren(childNewMother);
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSpouse(Human spouse) {
        if (this.spouse == null || !this.spouse.equals(spouse)) {
            this.spouse = spouse;
        }
        
        if (spouse.getSpouse() == null || !spouse.getSpouse().equals(this)) {
            spouse.setSpouse(this);
        }
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }
    
    public String getFIOtoString() {
        return this.lastName + " " + this.name + " " + this.secondName;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getParentFather() {
        return parentFather;
    }

    public Human getParentMother() {
        return parentMother;
    }

    public int getGeneration() {
        return generation;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }


}