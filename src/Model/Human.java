package Model;

public abstract class Human {
    private boolean sex;
    private int age;
    private String firstName;
    private String lastName;

    public static boolean male = true;
    public static boolean female = false;

    public Human(boolean sex, int age, String firstName, String lastName) {
        this.sex = sex;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human() {

    }

    public boolean getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Human setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    public Human setAge(int age) {
        this.age = age;
        return this;
    }

    public Human setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Human setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
    public void printData() {
        System.out.format("%s %d %s\n", this.getSex() == Human.male ? "Male" : "Female", this.getAge(), this.toString());
    }
}
