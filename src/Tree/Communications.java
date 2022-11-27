package Tree;

public class Communications {
    /**
     * Communications Класс хранящий в себе сведения о:
     * people1 - личность для которой устанавливается родственная связь,
     * people2 - личность в отношении которой указывается связь,
     * RelationType - тип родственной связи,
     * Геттеры для всех полей,
     * Переопределен toString для отображения данных об экземпляре определенным образом
     */
    private final Person people1;
    private final Person people2;
    private final Relations relationType;

    public Communications(Person person1, Person person2, Relations relation) {
        this.people1 = person1;
        this.people2 = person2;
        this.relationType = relation;
    }

    public Person getPeople(){
        return this.people1;
    }

    public Person getRelationPeople(){
        return this.people2;
    }

    public Relations getRelationType(){
        return relationType;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %s for %s %s", getPeople().getSurName() +" "+ getPeople().getFirstName(),
                getPeople().getPatronymic(), getRelationType(),getRelationPeople().getSurName()
                        + " " +  getRelationPeople().getFirstName(), getRelationPeople().getPatronymic());
    }
}
