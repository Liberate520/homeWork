package Model;

public class Identity {
    public boolean sex;
    public int age;
    public String firstName;
    public String lastName;

    public static boolean male = true;
    public static boolean female = false;

    public Identity (boolean sex, int age, String firstName, String lastName) {
        this.sex = sex;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Identity() { }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
