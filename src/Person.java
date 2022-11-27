
enum Gender {
    Male,Female
}

public abstract class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person(String firstName, String lastName, Gender gender, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }


    @Override
    public String toString() {
        return String.format("name: %s, lastname: %s, gender: %s, age: %s",
        firstName, lastName, gender, age);
    }
}
