
public class Relative {

    private Person person;
    private FamilyStatus status;

    public Relative() {
    }

    public Relative(Person person, FamilyStatus status) {
        this.person = person;
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public FamilyStatus getStatus() {
        return status;
    }

    public void setStatus(FamilyStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Степень родства = " + this.status.getDescription() + ", данные = " + this.person;
    }
}
