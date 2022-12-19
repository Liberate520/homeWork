package people;

import java.util.List;

public class Humans{
    private String onePerson;
    private String twoPerson;

    public Humans(String onePerson, String twoPerson) {
        this.onePerson = onePerson;
        this.twoPerson = twoPerson;

    }

    public String getOnePerson() {
        return onePerson;
    }

    public void setOnePerson(String onePerson) {
        this.onePerson = onePerson;
    }




    public String getTwoPerson() {
        return twoPerson;
    }

    public void setTwoPerson(String twoPerson) {
        this.twoPerson = twoPerson;
    }



    @Override
    public String toString() {
        return onePerson + "-->"  + twoPerson ;
    }
}

