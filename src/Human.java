import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {

    static ArrayList<String> snilss = new ArrayList();
    private String snils;
    private String fam;
    private String name;
    private LocalDate dr;
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    public Human(String snils, String fam, String name, LocalDate dr) {
        //Делаем проверку, вдруг такой снилс уже есть
        for (String val:snilss
             ) {
            if (val.equals(snils)) return;
        }

        this.snils = snils;
        this.fam = fam;
        this.name = name;
        this.dr = dr;
        snilss.add(snils);

    }


    public void AddMother(Human mother){
        this.mother = mother;
    }

    public void AddFather(Human father){
        this.father = father;
    }

    public String GetMother(){
        return mother.toString();
    }

    public String GetFather(){
        return father.toString();
    }

    public void AddChildren(Human child){
        for (Human val:children
        ) {
            if (val.snils.equals(child.snils)) return;
        }
        children.add(child);
    }

    public String GetChildren(){
        StringBuilder str = new StringBuilder();
        for (Human val: children
             ) {
            str.append(val.toString() +"\n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return " СНИЛС -'" + snils + '\'' +
                ", ФАМИЛИЯ -'" + fam + '\'' +
                ", Имя - '" + name + '\'' +
                ", Дата рождения - " + dr ;
    }
}
