package people;

import people.Humans;

public class Kinship extends Humans {
    private String kinship;

    public Kinship(String onePerson, String twoPerson, String kinship) {
        super(onePerson, twoPerson);
        this.kinship = kinship;
    }

    public String getKinship() {
        return kinship;
    }

    public void setKinship(String kinship) {
        this.kinship = kinship;
    }

    @Override
    public String toString() {
        return super.toString() + " " + kinship;
    }
}
