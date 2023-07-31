class Person {
    private final String firstName;
    private final String lastName;
    private int age;
    private final String gender;
    private Person child;

    public Person(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        String childString = child == null ? "No child" : child.getFirstName() + " " + child.getLastName();
        return firstName + " " + lastName + " (" + age + ") - " + gender + " - " + childString;
    }
}