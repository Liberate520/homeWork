package model.creature.methods;

import model.creature.Gender;
import model.creature.Human;
import model.creature.Interface.PrintInfo;

public class Print implements PrintInfo {
    private long id;
    private String Name;
    private Gender gender;
    private Age age;
    private Human human;
    private Parents parents;
    private Children child;

    public Print(long id, String name, Gender gender, Age age, Human human, Parents parents, Children child) {
        this.id = id;
        Name = name;
        this.gender = gender;
        this.age = age;
        this.human = human;
        this.parents = parents;
        this.child = child;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", name: ");
        stringBuilder.append(Name);
        stringBuilder.append(", gender: ");
        stringBuilder.append(gender);
        stringBuilder.append(", age: ");
        stringBuilder.append(age.getAge());
        stringBuilder.append(", ");
        stringBuilder.append(human.getSpouseInfo());
        stringBuilder.append(", ");
        stringBuilder.append(parents.getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(parents.getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(child.getChildrenInfo());
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }
}
