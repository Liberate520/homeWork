public class Person {

    private Gender gender;
    private String name;
    private Person mother;
    private Person father;
    public Person(String name, Gender gender, Person mother, Person father) {
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.gender = gender;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder(name);
        sb.append(" ").append(gender);
        return sb.toString();
    }
    public Gender getGender() {
        return this.gender;
    }

    public String getName() {
        return this.name;
    }

    public Person getMother() {
        return this.mother;
    }
    public Person getFather() {
        return this.father;
    }
}
