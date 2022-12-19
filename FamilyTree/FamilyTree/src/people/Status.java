package people;

public class Status extends Humans{
    private String statusOnePerson;
    private String statusTwoPerson;

    public Status(String onePerson, String statusOnePerson, String twoPerson, String statusTwoPerson) {
        super(onePerson,twoPerson);
        this.statusOnePerson=statusOnePerson;
        this.statusTwoPerson = statusTwoPerson;
    }

    public String getStatusOnePerson() {
        return statusOnePerson;
    }

    public void setStatusOnePerson(String statusOnePerson) {
        this.statusOnePerson = statusOnePerson;
    }

    public String getStatusTwoPerson() {
        return statusTwoPerson;
    }

    public void setStatusTwoPerson(String statusTwoPerson) {
        this.statusTwoPerson = statusTwoPerson;
    }

    @Override
    public String toString() {
        return super.toString() +" : " +  statusOnePerson + "-->" + statusTwoPerson;
    }
}
