package dzseer2.tree;
import dzseer2.human.Gender_sex;
import dzseer2.human.Gender_type;
import dzseer2.human.Human;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Adding_a_person implements Serializable {
    private List<Human> humanList;
    public Adding_a_person() {this.humanList = new ArrayList<>();}
    public List<Human> fillCollection() {
        humanList.add(new Human("Иван ", "Ivanov ",  2000, Gender_sex.мужчина,
                Gender_type.Мама, "Ната ",0 ));
        humanList.add(new Human("Ната ", "Ivanova ", 1977, Gender_sex.женщина,
                null, null,123456));
        humanList.add(new Human("Ольга ", "Ivanova ", 1997, Gender_sex.женщина,
                Gender_type.Мама,  "Ната ",0));
        humanList.add(new Human("Игорь ", "Ivanov ", 1973, Gender_sex.мужчина,
                null, null,123456));
        humanList.add(new Human("Петр ", "Ivanov ", 2002, Gender_sex.мужчина,
                Gender_type.Мама,  "Ната ",0));
        return humanList;
    }

    public List<Human> getHumanList() {return humanList;}
}
