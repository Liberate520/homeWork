package src;

import java.util.ArrayList;
import java.util.List;

public class Human {
  private String fullName;
  private String gender;
  private Human mother;
  private Human father;
  private List<Human> children;

  private String appeal;

  public Human(String fullName, String gender) {
    this.fullName = fullName;
    this.gender = gender;
    this.children = new ArrayList<>();

    if (this.gender.toLowerCase().equals("мужской"))
      this.appeal = "Его";
    else
      this.appeal = "Её";
  }

  public Human(String fullName, String gender, Human mother, Human father) {
    this(fullName, gender);
    this.mother = mother;
    this.father = father;
    if (father != null)
      father.children.add(this);
    if (mother != null)
      mother.children.add(this);
  }

  public String getFullName() {
    return fullName;
  }

  public String getGender() {
    return gender;
  }

  public String getInfo() {
    String info = String.format("Имя: %s, пол: %s.\n%s родители:\nОтец %s\nМать %s", fullName,
        gender, appeal, father != null ? father : "не найден", mother != null ? mother : "не найдена");

    if (children.isEmpty())
      return info + "\n" + fullName + " не имеет детей";

    return String.format(info + "\n%s дети: %s", appeal, children);
  }

  public String getChildren() {
    if (children.isEmpty())
      return fullName + " не имеет детей";

    return this.children.toString();
  }

  @Override
  public String toString() {
    return String.format("Имя: %s, пол: %s", fullName, gender);
  }

}
