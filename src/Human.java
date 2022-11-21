import java.util.ArrayList;

public class Human {
    String name;
    int age;
    ArrayList<Сommunications> son = new ArrayList<Сommunications>();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Сommunications> getSon() {
        return son;
    }


    public Human(String name) {
        this.name = name;
    }
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, ArrayList<Сommunications> son) {
        this.name = name;
        this.age = age;
        this.son = son;
    }

    public Human(String name, ArrayList<Сommunications> son) {
        this.name = name;
        this.son = son;
    }

    public void printRelatives(int st){
        ArrayList<Сommunications> tList = this.getSon();
        System.out.println("Родственники степени: " + st + ", для " + this.name + ":");
        for (int i = 0; i < tList.size(); i++){
            if (tList.get(i).h2 != this && tList.get(i).degreeKinship2 == st) {
                System.out.print("Имя: " + tList.get(i).h2.name + ", ");
                System.out.print("Возвраст: " + tList.get(i).h2.age + ", ");
                System.out.println("Степень родства: " + tList.get(i).degreeKinship2 + ".");
            }
        }
    }

    public void addСommunications(Human h2, int st1, int st2){
        this.son.add(new Сommunications(this, h2, 1, 2));
    }

}
