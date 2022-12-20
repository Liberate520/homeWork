package Seminars_OOP.HW_1;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public List<Human> humenList;

    public FamilyTree(List<Human> humenList) { // метод конструктор
        this.humenList = humenList; // инициализация поля, this обращение к текущему объекту
    }

    public FamilyTree() { // метод конструктор
        this(new ArrayList<>()); // инициализация поля, this обращение к текущему объекту
    }

    // public List<Human> getHumanList() {
    //     return humenList;
    // }

    // public void setHumanList(List<Human> humenList) {
    //     this.humenList = humenList;
    // }

    public void addHuman(Human human) {
        humenList.add(human);
    }

    public List<Human> getHumanByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human Human : humenList) {
            if (Human.getName().equals(name)) {
                res.add(Human);
            }
        }
        return res;
    }

    public List<Human> getAllHuman() {
        List<Human> res = new ArrayList<>();
        for (Human Human : humenList) {
            res.add(Human);
        }
        return res;
    }

}
