public class Teachers {
    private String name;
    private String surname;
    private String subject;

    public Teachers(String surname, String name, String subject){
        this.surname = surname;
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "surname:" + surname + ", name:" + name + ", subject:" + subject;
    }
}
