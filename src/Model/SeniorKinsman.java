package Model;

import java.util.List;

public interface SeniorKinsman<U> {
    default void createRelationship(List<U> juniorList) {
        setSeniorFor(juniorList);
        setLinkTo(juniorList);
    }
    void setSeniorFor(List<U> juniorList);
    void setLinkTo(List<U> juniorList);
}
