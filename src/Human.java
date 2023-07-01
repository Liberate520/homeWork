import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Human {
    private String Name;
    private Human mother, father;
    private List<Human> childrens = new ArrayList<>();    
    private LocalDate dateBirth, dateDeath;
    private Gender gender;
    Human(String Name, LocalDate dateBirth, Gender gender){
        this.Name = Name;
        this.dateBirth = dateBirth;
        this.gender = gender;
    }
    public String getName(){ return Name; }
    public Gender getGender(){ return gender; }
    public Human getMother(){ return mother; }
    public List<Human> getChildrens() { return childrens; }

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

    public void setChild(Human child){
        boolean flag = false;
        if(this.gender == Gender.Male) {
            flag = child.setFather(this);
        }else{
            flag = child.setMother(this);
        }
        if(flag) childrens.add(child);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        result.append(String.format("Имя: %s, ", Name));
        result.append(String.format("Дата рождения: %s, ", dateBirth.toString()));
        result.append(String.format("Пол: %s, ", gender==Gender.Male ? "мужской":"женский"));
        result.append(String.format("Отец: %s, ", (father==null ? "Нет данных" : father.getName())));
        result.append(String.format("Мать: %s, ", (mother==null ? "Нет данных" : mother.getName())));
        StringBuilder namesChildren = new StringBuilder();
        int cnt=0;
        for(Human child : childrens) {
            namesChildren.append(child.getName());
            if(cnt++ < childrens.size()-1) namesChildren.append(',');
        }
        result.append(String.format("Дети: %s}", (childrens.isEmpty() ? "Нет" : namesChildren.toString())));
        return result.toString();
    }
}
