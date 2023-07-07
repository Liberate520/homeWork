package family_tree;


import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Human {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-dd");
    
    private String name;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender, null, null);
    }

    public Human(String[] args, FamilyTree familyTree){
        this.name = args[0];
        if (args[1].equals("Male")) {
            this.gender = Gender.Male;
        } else {
            this.gender = Gender.Female;
        }
        this.birthDate = LocalDate.parse(args[2], FORMATTER);
        if (args[3].equals("null")) {
            this.deathDate = null;
        } else {
            this.deathDate = LocalDate.parse(args[3], FORMATTER);
        }
        if (args[4].equals("null")) {
            this.mother = null;
        } else {
            this.mother = familyTree.getByName(args[4]);
        }
        if (args[5].equals("null")) {
            this.father = null;
        } else {
            this.father = familyTree.getByName(args[5]);
        }
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void addChildren(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    private void addParents(Human parent1, Human parent2) {
        if (parent1.gender == Gender.Male) {
            father = parent1;
        } else {
            mother = parent1;
        }
        if (parent2.gender == Gender.Male) {
            father = parent2;
        } else {
            mother = parent2;
        }
    }

    public void createRelatings(Human parent1, Human parent2, Human child) {
        child.addParents(parent1, parent2);
        parent1.addChildren(child);
        parent2.addChildren(child);
    }

    private String getAllChildrens() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human child : children) {
            stringBuilder.append(child.name);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String writeChildrensToTxt() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human child : children) {
            stringBuilder.append(" " + child.name);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + birthDate);
        if (deathDate != null) {
            stringBuilder.append(", Дата смерти: " + deathDate);
        }
        if (mother != null) {
            stringBuilder.append(", Мать: " + mother.name);
        }
        if (father != null) {
            stringBuilder.append(", Отец: " + father.name);
        }
        if (!children.isEmpty()) {
            stringBuilder.append("\nСписок детей " + name + ":\n");
            stringBuilder.append(getAllChildrens());
        }
        return stringBuilder.toString();
    }

    public String toTxt(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " " + gender + " " + birthDate);
        if (deathDate != null) {
            stringBuilder.append(" " + deathDate);
        } else {
            stringBuilder.append(" null");
        }
        if (mother != null) {
            stringBuilder.append(" " + mother.name);
        } else {
            stringBuilder.append(" null");
        }
        if (father != null) {
            stringBuilder.append(" " + father.name);
        } else {
            stringBuilder.append(" null");
        }
        if (!children.isEmpty()) {
            stringBuilder.append(writeChildrensToTxt());
        } else {
            stringBuilder.append(" null");
        }
        stringBuilder.append(";");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }
}
