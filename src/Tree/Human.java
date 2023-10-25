package Tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Human {
    private String name;
    private LocalDate birthDate;
    private Human parent1, parent2;
    private ArrayList<Human> children  = new ArrayList<Human>();

    private Gender gender;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате yyyy-mm-dd");
        this.birthDate = LocalDate.parse(sc.nextLine());
    }

    public void setParent1(Human parent1){
        this.parent1 = parent1;
    }

    public void setParent2(Human parent2){
        this.parent2 = parent2;
    }

    void addChild(Human child){
        this.children.add(child);
    }

    public ArrayList<Human> getChildren(){
        return children;
    }

    @Override
    public String toString() {
        String tmp = "name: " + name + "\n"+
                "gender: " + gender + "\n"+
                "date of birth: " + birthDate + "\n" + "parents: ";

        if (this.parent1 != null){
            tmp += parent1.name + ", ";
        }else{
            tmp += "--" + ", ";
        }

        if (this.parent2 != null){
            tmp += parent2.name + "\n";
        }else{
            tmp += "--" + "\n";
        }

        tmp += "children: ";

        for (Human item : children) {
            tmp += item.name + " ";
        }
        tmp += "\n";
        return tmp;

    }
}
