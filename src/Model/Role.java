package Model;

public abstract class Role<T extends Identity> {
    public T identity;

    public static boolean male = Identity.male;
    public static boolean female = Identity.female;


    public Role(boolean sex, int age, String firstName, String lastName) {
        identity = (T) new Identity(sex, age, firstName, lastName);
    }

    public Role(T identity) {
        this.identity = identity;
    }

    public Role() {
        this.identity = (T) new Identity();
    }

    public boolean getSex() {
        return identity.sex;
    }

    public int getAge() {
        return identity.age;
    }

    public String getFirstName() {
        return identity.getFirstName();
    }

    public String getLastName() {
        return identity.getLastName();
    }


    public Role setSex(boolean sex) {
        identity.sex = sex;
        return this;
    }

    public Role setAge(int age) {
        identity.age = age;
        return this;
    }

    public Role setFirstName(String firstName) {
        identity.firstName = firstName;
        return this;
    }

    public Role setLastName(String lastName) {
        identity.lastName = lastName;
        return this;
    }


    @Override
    public String toString() {
        return identity.toString();
    }
    public void printData() {
        System.out.format("%s %d %s\n", this.getSex() == male ? "Male" : "Female", this.getAge(), this.toString());
    }
}
