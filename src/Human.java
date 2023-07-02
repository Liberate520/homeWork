import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Human {
    private String name;
    private Human mother, father;
    private List<Human> children;
    private LocalDate dateBirth, dateDeath;
    private Gender gender;
    public Human(String name, LocalDate dateBirth, Gender gender){
        children = new ArrayList<>();
        this.name = name;
        this.dateBirth = dateBirth;
        this.gender = gender;
    }
    public String getName(){ return name; }
    public Gender getGender(){ return gender; }
    public Human getMother(){ return mother; }    
    public boolean setMother(Human mother){
        if (this.mother != null || mother.getGender() != Gender.Female) return false;
        this.mother = mother;
        return true;
    }
    public Human getFather(){ return father; }
    public boolean setFather(Human father){
        if (this.father != null || father.getGender() != Gender.Male) return false;
        this.father = father;
        return true;
    }
    public List<Human> getChildren() { return children; }
    public boolean addChild(Human child){
        if(this.gender == Gender.Male) {
            if(!child.setFather(this)) return false;
        }else{
            if(!child.setMother(this)) return false;
        }
        children.add(child);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        result.append(String.format("Имя: %s, ", name));
        result.append(String.format("Дата рождения: %s, ", dateBirth.toString()));
        result.append(String.format("Пол: %s, ", gender==Gender.Male ? "мужской":"женский"));
        result.append(String.format("Отец: %s, ", (father==null ? "Нет данных" : father.getName())));
        result.append(String.format("Мать: %s, ", (mother==null ? "Нет данных" : mother.getName())));
        List<String> childrenNames = new ArrayList<>();
        for(Human child : children)
            childrenNames.add(child.getName());
        result.append(String.format("Дети: %s", (children.isEmpty() ? "Нет" : String.join(",", childrenNames))));
        result.append('}');
        return result.toString();
    }
}
