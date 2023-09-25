import java.util.ArrayList;
import java.util.List;

public class Human {
    String fstName;
    String lstName;
    String bornDate;
    String deathDate;
    Gender gender;
    List<Human> childrens;
    List<Human> parents;

    public Human(String fstName, String lstName, String bornDate, String deathDate, Gender gender) {
        this.fstName = fstName;
        this.lstName = lstName;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.childrens = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public Human(String fstName, String lstName, String bornDate, Gender gender) {
        this.fstName = fstName;
        this.lstName = lstName;
        this.bornDate = bornDate;
        this.gender = gender;
        this.childrens = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void addChild(Human child) {
        childrens.add(child);
    }

    public void removeChild(Human child) {
        childrens.remove(child);
    }

    public void addParent(Human child) {
        parents.add(child);
    }

    public void removeParent(Human child) {
        parents.remove(child);
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void printChildrens() {
        if(!childrens.isEmpty()){
            for(Human child : childrens){
                System.out.println(child);
            }
        }
        else{
            System.out.println("Отсутствуют");
        }

    }

    public void printParents() {
        if(!parents.isEmpty()) {
            for (Human parent : parents) {
                System.out.println(parent);
            }
        }
        else{
            System.out.println("Отсутствуют");
        }
    }


    public String toString() {
        if(deathDate != null){
            return "Фамилия:" + fstName + ", Имя: " + lstName + ", ДР: "
                    + bornDate +", ДC: " + deathDate + ", Пол: " + gender;
        }
        else{
            return "Фамилия:" + fstName + ", Имя: " + lstName + ", ДР: "
                    + bornDate + ", Пол: " + gender;
        }
    }


}
