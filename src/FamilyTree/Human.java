package FamilyTree;

import java.util.Calendar;

public class Human {
    String name;
    String sex;
    Human father;
    Human mother;

    public Human(String name, String sex, Human father, Human mother) {
        this.name = name;
        this.sex = sex;
        this.father = father;
        this.mother = mother;
    }
    public Human(String name, String sex) {
        this(name, sex, null, null);
    }

@Override
    public String toString() {
        return "Имя: " + name + ", Пол: " + sex;// + " (Отец: " + father + ", Мать: " + mother + ")";
    }

}
  /*
  Calendar calendar = Calendar.getInstance();
calendar.set(2018, 11, 31, 59, 59, 59);
        Date happyNewYearDate = calendar.getTime();

   */