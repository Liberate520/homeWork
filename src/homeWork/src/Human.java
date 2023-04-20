package homeWork.src;

public class Human implements Person {
    private String name;
    private int age;
    private String gender;
    private Human parent;

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setParent(Human parent) {
        this.parent = parent;
    }

    @Override
    public Human getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Пол: " + gender;
    }
}

