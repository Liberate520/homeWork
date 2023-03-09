import java.util.ArrayList;

public class Human {
    String name;
    int age;
    ArrayList<Communications> son = new ArrayList<Communications>();


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Communications> getSon() {
        return son;
    }

    public Human (String name){
        this.name = name;

    }

    public Human (String name, int age){
        this.name = name;
        this.age = age;

    }

    public Human (String name, int age, ArrayList<Communications> son){
        this.name = name;
        this.age = age;
        this.son = son;

    }


    public Human (String name, ArrayList<Communications> son){
        this.name = name;
        this.son = son;                
    }


    public void printRelatives (int st){
        ArrayList<Communications> tList = this.getSon();
        System.out.println("Родственники степени " + st + " для " + this.name + ":");
        for (int i = 0; i < tList.size(); i++){
            if (tList.get(i).h2 != this && tList.get(i).degreeKinSheep2 == st) {
                System.out.print("Имя: " + tList.get(i).h2.name + ", ");
                System.out.print("Возраст: " + tList.get(i).h2.age + ", ");
                if(tList.get(i).degreeKinSheep2 == 1){
                    // System.out.println("Степень родства: " + tList.get(i).degreeKinSheep2 + ".");
                    System.out.println("Степень родства: Родители / дети ");                
                }
                if(tList.get(i).degreeKinSheep2 == 2){
                //     System.out.println("Степень родства: " + tList.get(i).degreeKinSheep2 + ".");
                    System.out.println("Степень родства: Дедушка / Бабушка / Внуки / Братья / Сестры");                
                }


            }
        }

    }

    public void addCommunications(Human h2, int st1, int st2){
        this.son.add(new Communications(this, h2, st1, st2));

    }








}