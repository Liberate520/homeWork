public abstract class Human implements Comparable<Human>{
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private Integer age;
    private Relations relation;

    public Human(String firstName, String lastName, String birthDate, String gender, Integer age, Relations relation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = age;
        this.relation = relation;
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

    public Relations getRelation() {
        return relation;
    }

    public void setRelation(Relations relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "LastName: " + getLastName() + 
                " FirstName: " + getFirstName() +
                " Gender: " + getGender() +
                " BirthDate: " + getBirthDate() +
                " Age: " + getAge() + 
                " Relations: " + getRelation();
    }

    @Override
    public int compareTo(Human o) {
        return firstName.compareTo(o.getFirstName());
    }
}
