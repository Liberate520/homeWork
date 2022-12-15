package homeWork.src;

import java.util.ArrayList;
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
        this.children = new ArrayList<>();  // список детей Human
//        father.children.add(this);  // у отца прописываем ребёнка (этого Human) -> в поле children (это список) добавляем этого Human
//        mother.children.add(this);  // у матери прописываем ребёнка (этого Human) -> в поле children (это список) добавляем этого Human
    }

    // конструктор только с детьми (верхний уровень дерева). т.е. бабушки и дедушки, у которых родители неизвестны
    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    /**
     * toString Human
     *
     * @return String
     */
    @Override
    public String toString() {
        String humName = "Name " + name + "\n";
        String humGender = "Gender " + gender + "\n";
        String humFather = "";
        String humMother = "";
        StringBuilder kids = new StringBuilder();
        if (!(father == null)) {
            humFather = "Father " + father.getName() + "\n";
        }
        if (!(mother == null)) {
            humMother = "Mother " + mother.getName() + "\n";
        }
        if (this.children.size() > 0) {
//            System.out.printf("Всего детей у %s - %s\n", name, this.children.size());
            for (Human child : this.children) {
                if (child.getGender().equals("M")) {
                    kids.append("Son ").append(child.getName());
                    kids.append("\n");
                } else if (child.getGender().equals("W")) {
                    kids.append("Daughter ").append(child.getName());
                    kids.append("\n");
                }
            }
        }
        return humName + humGender + humFather + humMother + kids.toString();
    }

    /**
     * получить всех детей
     *
     * @return String
     */
    public String getAllChildren() {
        StringBuilder kids = new StringBuilder();
        if (this.children.size() > 0) {
            kids.append("У ").append(this.getName()).append(" есть ");
            for (Human child : this.children) {
                kids.append(child.getGender().equals("M") ? "Son" : "Daughter").append(" - ").append(child.getName()).append(" ");
            }
        } else {
            kids.append("У ").append(this.getName()).append(" детей нет.");
        }
        return kids.toString();
    }

    /**
     * получить всех сестёр
     *
     * @return String
     */
    public String getAllSisters() {
        StringBuilder sisters = new StringBuilder();
        if (this.father.children.size() > 0) {
            for (Human child : this.father.children) {
//                System.out.println(child==this);
                if ((child.getGender().equals("W")) & (child != this)) {
                    sisters.append(child.getName()).append(" ");
                }
            }
        }
        if (sisters.length() == 0) {
            sisters.append("У ").append(this.getName()).append(" нет сестёр.");
        }
        return sisters.toString();
    }


}
