package homeWork.src;

public class Human {
    private String name;
    private int age;
    private String gender;
    private Human parent;

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setParent(Human parent) {
        this.parent = parent;
    }

    public Human getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Пол: " + gender;
    }
}
