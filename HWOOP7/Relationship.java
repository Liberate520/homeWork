public class Relationship<T extends Human>{
    private T Human1;
    private T Human2;
    private Relations relation;
    
    public T getHuman() {
        return Human1;
    }

    public T getHuman2() {
        return Human2;
    }

    public Relations getRelation() {
        return relation;
    }

    public Relationship(T Human1, T Human2, Relations relation) {
        this.Human1 = Human1;
        this.Human2 = Human2;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "LastName: " + (getHuman()).getLastName() + 
                " FirstName: " + (getHuman()).getFirstName() +
                " Gender: " + (getHuman()).getGender() +
                " BirthDate: " + (getHuman()).getBirthDate() +
                " Age: " + (getHuman()).getAge() + 
                " IS " + getRelation() + 
                " LastName: " + (getHuman2()).getLastName() + 
                " FirstName: " + (getHuman2()).getFirstName() +
                " Gender: " + (getHuman2()).getGender() +
                " BirthDate: " + (getHuman2()).getBirthDate() +
                " Age: " + (getHuman2()).getAge();
    }

}
