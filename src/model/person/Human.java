package model.person;

import java.io.Serializable;

public class Human implements Serializable {
    private static int count;
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;

    public Human(String firstName, String lastName, int age, Sex sex) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Human() {
        this ("NoName", "NoName", 0, Sex.Male);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("ID: " + this.id + "    ");
        output.append("Name: " + this.firstName + " " + this.lastName + "    ");
        output.append("Age: " + this.age + "    ");
        output.append("Sex: " + this.sex + "    " + "\n");
        return output.toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }
}
