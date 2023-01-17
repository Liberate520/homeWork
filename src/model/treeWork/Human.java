package model.treeWork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Human extends ElementTree<Human> implements Serializable, Comparable<Human> {
    private String name;
    private String gender;
    private Integer age;

    // вернул суда так как дерево работает с любым объектом с любыми полями, иначе у меня терялись связи
    private Human father;
    private Human mother;

  private List<Human> children = new ArrayList<>();


    public Human(String name, String gender, Integer age, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        father.children.add(this);
        mother.children.add(this);
        }



    public Integer getAge() {
        return age;
    }

    public Human() {
        this.name = null;
        this.gender = null;
        this.age = null;
        this.father = null;
        this.mother = null;
    }

    public Human(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.father = null;
        this.mother = null;

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

    public void setChildList(List<Human> children) {
        this.children = children;}

    public List<Human> getChildList() {
        return children;
    }

    public String getChildren() {
        String res = "";
        for (Human child : children) {
            res += child + "\n";
        }
        return "Дети этого человека\n " + res;
    }

    @Override
    public String toString() {
        return "Имя= " + name +
                ", Пол = " + gender +
                " Возраст = " + age;
    }

    public String printParents() {
        if (father == null || mother == null) {
            return "Нет данных о родителей данного человека";
        } else {
            return "Родители данного человека\n" +
                    "Отец = " + father + "," +
                    "Мать = " + mother;
        }
    }


    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

  //  @Override
   // public void addElement(model.treeWork.Human element) {

//        this.children.add(element);

  //       if (element.getFather() != null) {
  //         element.getFather().getChildList().add(element);
   //      }
    //     if (element.getMother() != null) {
         //    element.getMother().getChildList().add(element);
     //    }
     //    if (element.getChildList().size() > 0) {
       //      for (model.treeWork.Human child : element.getChildList()) {
      //           if (element.getGender().equals("Male")) {
        //             child.setFather(element);
       //          } else if (element.getGender().equals("FeMale")) {
       //              child.setMother(element);
       //         }
      //       }
//    }



  //  }



//

}









