package OOP.Less_001.Home_work_less_01.Human;

import java.util.ArrayList;
// import java.time.LocalDate;
// import java.time.LocalTime;
import java.util.List;
import java.lang.StringBuilder;
// import java.text.SimpleDateFormat;


import OOP.Less_001.Home_work_less_01.Gender.*;

public class Human {
    private Human mother;
    private Human father;
    private String firstName;
    private String birthdays;
    private Gender gender;
    private List<Human> children;
   


    public Human(String name, Gender gender) {
        this(name, gender, null, null);

    }

    public Human(String firstName, Gender gender, Human mother, Human father) {
        this.firstName = firstName;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();

    }

    public String getName() {
        return firstName;
    }

    public String getBirthdays(){
        return birthdays;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Gender getGender() {
        return gender;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public String getMotherInfo() {
        String mom;
        if (mother != null) {
            mom = "Mother:" + mother.getName();
        } else {
            mom = "null";
        }
        return mom;
    }

    public String getFatherInfo() {
        String dad;
        if (mother != null) {
            dad = "Father:" + father.getName();
        } else {
            dad = "null";
        }
        return dad;
    }

    public String getChildrenInfo() {
        StringBuilder sbChildren = new StringBuilder();

        if (children.size() != 0) {
            sbChildren.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sbChildren.append(firstName);
            }
        } else {
            sbChildren.append("Null");
        }
        return sbChildren.toString();
    }

    public String getInfoHuman() {
        StringBuilder stringBuilderHuman = new StringBuilder();
        stringBuilderHuman.append("Name:");
        stringBuilderHuman.append(firstName);
        stringBuilderHuman.append(", ");
        // stringBuilderHuman.append(birthdays);
        // stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getFatherInfo());
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getMotherInfo());
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getChildrenInfo());
        return stringBuilderHuman.toString();
    }



// public String  birthdays(int year, int month, int day) {
//     StringBuilder builder = new StringBuilder();
//     SimpleDateFormat format = new SimpleDateFormat(" - dd.MM.yyyy - EEEE");
//     int num = 0;       
//     LocalDate date = LocalDate.of(year, month, day);
//     LocalDate today = LocalDate.now();
//     while(date.isBefore(today)) {
//         builder.append(num).append(format.format(date));
//         date = date.plusYears(1);
//         num++;
//     }

//     return builder.toString();
// }



}

