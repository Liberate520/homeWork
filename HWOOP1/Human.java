public abstract class Human {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private Integer age;
    private Integer relationship;

    public Human(String firstName, String lastName, String birthDate, String gender, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = age;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "LastName: " + lastName + 
                " FirstName: " + firstName +
                " Gender: " + gender +
                " BirthDate: " + birthDate +
                " Age: " + age + 
                " Relationship: " + relationship;
    }
}
