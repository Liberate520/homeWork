package homeWork.src;

import java.util.List;

public class Human {
    private String name;    // имя
    private String gender;  // пол
    private Human father;   // отец
    private Human mother;   // мать
    private List<Human> children;   // список детей. ребёнок класса Human

    // конструктор с родителями и детьми
    public Human(String name, String gender, Human father, Human mother) {
        this.name = name;       // имя Human
        this.gender = gender;   // пол Human
        this.father = father;   // отец Human
        this.mother = mother;   // мать Human
        father.children.add(this);  // у отца прописываем ребёнка (этого Human) -> в поле children (это список) добавляем этого Human
        mother.children.add(this);  // у матери прописываем ребёнка (этого Human) -> в поле children (это список) добавляем этого Human
    }

    // конструктор только с детьми. бабушки и дедушки, у которых родители неизвестны
    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                '}';
    }
}
