package DZ5_7.Models;

import java.io.Serializable;

public class FamilyCommunication implements Serializable {
    private Human human;
    private TypeCommunication typeCommunication;

    public FamilyCommunication(Human human, TypeCommunication typeCommunication) {
        this.human = human;
        this.typeCommunication = typeCommunication;
    }

    public Human getHuman() {
        return human;
    }

    public TypeCommunication getTypeCommunication() {
        return typeCommunication;
    }

    @Override
    public String toString() {
        return human.getName() + " (" + human.getGender() + ", " + typeCommunication + ") ";
    }
}
