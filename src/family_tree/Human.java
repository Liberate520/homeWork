package family_tree;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deadDay;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    Human(String name, LocalDate birthDay, LocalDate deadDay, Human mother, Human father, Gender gender)
    {
        this.name = name;
        this.birthDay = birthDay;
        this.deadDay = deadDay;
        this.mother = mother;
        this.father = father;
        this.gender = gender;
        childrens = new ArrayList<>();   
    }

    public String getName() {
        return name;
    }

    public Human getMother() {
        return mother;
    }

    public Gender getGender() {
        return gender;
    }

    public LifeStatus getLifeStatus() {
        if(deadDay != null)
        {
            return LifeStatus.Dead;
        }
        return LifeStatus.Live;

    }

    public Human getFather() {
        return father;
    }

    public void addChild(Human child)
    {
        childrens.add(child);
    }

    public String getChildrensListInfo()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список детей "+ name +": \n");

        for(Human child: childrens)
        {
            stringBuilder.append(child);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getAge() {
        int age = 0;
        LocalDate date_now = LocalDate.now();
        if(deadDay == null)
        {
            age = date_now.getYear() - birthDay.getYear();
        }
        else
        {
            age = deadDay.getYear() - birthDay.getYear();
        }
        return age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name: " + name + ", age: " + getAge() + ", gender: " + gender + ", Life Status: " + getLifeStatus();
    }
}