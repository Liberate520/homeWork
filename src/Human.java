import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Human mother, father;
    private List<Human> child;
    private LocalDate Ld;

    public Human(String name,Gender gender, LocalDate Ld) {
        child = new ArrayList<>();
        this.gender = gender;
        this.name = name;
        this.Ld = Ld;
    }

    public Human(String name, Gender gender, Human mother, Human father, LocalDate ld) {
        child = new ArrayList<>();
        this.name = name;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        Ld = ld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChild() {

        return child;
    }

    public void setChild(List<Human> child) {
        this.child = child;
    }

    public LocalDate getLd() {
        return Ld;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name).append(" ");
        sb.append("Дата рождения: ");
        sb.append(Ld).append(" ");
        sb.append("\n");
        if(!(child.size() == 0)){
            for (Human human : child) {
                if(human.getGender() == Gender.Mail) {
                    sb.append("Сын: ");
                } else {
                    sb.append("Дочь: ");
                }
                sb.append(human.getName() +" Дата рождения:" + human.getLd() + "\n");
            }

        }
        return sb.toString();
    }

    public boolean addChildren(Human human){
        if(!child.contains(human)) {
            child.add(human);
            return true;
        }
        return false;
    }

}
