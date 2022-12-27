package homeWork.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {     // сериализируемый, сравниваемый
    private String name;    // имя
    private String gender;  // пол
    private Integer age;    // возраст
    private Human father;   // отец
    private Human mother;   // мать
    private List<Human> children;   // список детей. ребёнок класса Human

    // конструктор с родителями и детьми
    public Human(String name, String gender, Integer age, Human father, Human mother) {
        this.name = name;       // имя Human
        this.gender = gender;   // пол Human
        this.age = age;         // возраст Human
        this.father = father;   // отец Human
        this.mother = mother;   // мать Human
        this.children = new ArrayList<>();  // список детей Human
//        запись ребенка у родителей реализована в FamilyTree.addNewMember
//        father.children.add(this);  // у отца прописываем ребёнка (этого Human) -> в поле children (это список) добавляем этого Human
//        mother.children.add(this);  // у матери прописываем ребёнка (этого Human) -> в поле children (это список) добавляем этого Human
    }

    // конструктор только с детьми (верхний уровень дерева). т.е. бабушки и дедушки, у которых родители неизвестны
    public Human(String name, String gender, int age) {
        this(name, gender, age, null, null);     // изменено на вызов другого конструктора
    }

    public Human() {
        this(null, null, null, null, null);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        StringBuilder sbHum = new StringBuilder();
        sbHum.append("Имя ").append(name).append("\n");     // сразу заполняем StringBuilder sbHum
        sbHum.append("Пол ").append(gender).append("\n");
        sbHum.append("Возраст ").append(age).append("\n");
        if (!(father == null)) {
            sbHum.append("Отец ").append(father.getName()).append("\n");
        }
        if (!(mother == null)) {
            sbHum.append("Мать ").append(mother.getName()).append("\n");
        }
        if (children.size() > 0) {      // изменено. теперь без this
            for (Human child : this.children) {
                if (child.getGender().equals("М")) {
                    sbHum.append("Сын ").append(child.getName());
                    sbHum.append("\n");
                } else if (child.getGender().equals("Ж")) {
                    sbHum.append("Дочь ").append(child.getName());
                    sbHum.append("\n");
                }
            }
        }
        return sbHum.toString();
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
                kids.append(child.getGender().equals("М") ? "Сын" : "Дочь").append(" - ").append(child.getName()).append(" ");
            }
        } else {
            kids.append("У ").append(this.getName()).append(" детей нет.");
        }
        return kids.toString();
    }

    /**
     * получить всех сестёр (братьев)
     *
     * @return String
     */
    public String getAllSistersOrBrothers(String gender) {
        StringBuilder sistOrBroth = new StringBuilder();
        if (!(this.father == null)) {
            if (this.father.children.size() > 0) {
                for (Human child : this.father.children) {
//                System.out.println(child==this);
                    if ((child.getGender().equals(gender)) & (child != this)) {
                        sistOrBroth.append(child.getName()).append(" ");
                    }
                }
            }
            if (sistOrBroth.length() == 0) {
                sistOrBroth.append("У ").append(this.getName()).append(gender.equals("Ж") ? " нет сестёр" : " нет братьев");
            }
        } else sistOrBroth.append("У ").append(this.getName()).append(" неизвестны родители.");
        return sistOrBroth.toString();
    }


    /**
     * Сравнение Human. Переопределение compareTo (сравнение по имени)
     *
     * @param o the object to be compared.
     * @return результат сравнения int
     */
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

    /**
     * Добавление ребёнка
     * @param child Human
     */
    public void addChild(Human child){
        this.getChildren().add(child);
    }

}
