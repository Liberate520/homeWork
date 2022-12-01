package Model;

import java.util.ArrayList;
import java.util.List;

public class Grandparent extends Human implements SeniorKinsman<Grandchild> {
    List<Grandchild> grandchildren;

    public Grandparent(boolean sex, int age, String firstName, String lastName, List<Grandchild> grandchildren) {
        super(sex, age, firstName, lastName);
        createRelationship(grandchildren);
    }

    @Override
    public void setSeniorFor(List<Grandchild> grandchildren) {
        for (Grandchild grandchild: grandchildren) {
            if (grandchild.grandparents == null) {
                grandchild.grandparents = new ArrayList<>();
            }
            grandchild.grandparents.add(this);
        }
    }

    @Override
    public void setLinkTo(List<Grandchild> grandchildren) {
        this.grandchildren = grandchildren;
    }
}
