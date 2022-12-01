package people;

import java.util.ArrayList;
import java.util.List;

public class Humans {
    private String onePerson;
    private String twoPerson;

    public Humans(String onePerson, String twoPerson) {
        this.onePerson = onePerson;
        this.twoPerson = twoPerson;

    }

    /**
     * Метод для добавления одного человека
     * @param onePerson один человек
     */
    public Humans(String onePerson){
        this.onePerson = onePerson;
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


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if(twoPerson==null) return onePerson;
        else if(onePerson==null) return twoPerson;
        else return onePerson + " " + twoPerson;
    }


}

