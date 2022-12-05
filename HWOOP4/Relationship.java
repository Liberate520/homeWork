public class Relationship<T> {
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
        return "LastName: " + ((Human) getHuman()).getLastName() + 
                " FirstName: " + ((Human) getHuman()).getFirstName() +
                " Gender: " + ((Human) getHuman()).getGender() +
                " BirthDate: " + ((Human) getHuman()).getBirthDate() +
                " Age: " + ((Human) getHuman()).getAge() + 
                " IS " + getRelation() + 
                " LastName: " + ((Human) getHuman2()).getLastName() + 
                " FirstName: " + ((Human) getHuman2()).getFirstName() +
                " Gender: " + ((Human) getHuman2()).getGender() +
                " BirthDate: " + ((Human) getHuman2()).getBirthDate() +
                " Age: " + ((Human) getHuman2()).getAge();
    }
}
