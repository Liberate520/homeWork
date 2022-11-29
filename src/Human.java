package DZ.DZ2;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private TypeGender gender;
    private List<FamilyCommunication> listCommunication;

    private Human(String name, TypeGender gender, List<FamilyCommunication> listCommunication) {
        this.name = name;
        this.gender = gender;
        this.listCommunication = new ArrayList<>();
    }

    public Human(String name, TypeGender gender) {
        this(name, gender, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeGender getGender() {
        return gender;
    }

    public List<FamilyCommunication> getListCommunication() {
        return listCommunication;
    }

    public void addCommunication(FamilyCommunication communication) {
        listCommunication.add(communication);
    }

    public void addCommunication(Human human, TypeCommunication typeCommunication) {
        addCommunication(new FamilyCommunication(human, typeCommunication));
        if (typeCommunication == TypeCommunication.Son && this.getGender() == TypeGender.Male
                || typeCommunication == TypeCommunication.Daughter && this.getGender() == TypeGender.Male) {
            human.addCommunication(new FamilyCommunication(this, TypeCommunication.Father));
        }
        if (typeCommunication == TypeCommunication.Son && this.getGender() == TypeGender.Female
                || typeCommunication == TypeCommunication.Daughter && this.getGender() == TypeGender.Female) {
            human.addCommunication(new FamilyCommunication(this, TypeCommunication.Mother));
        }
    }

    public void showCommunication(TypeCommunication typeCommunication) {
        for (FamilyCommunication communication : listCommunication) {
            if (communication.getTypeCommunication() == typeCommunication) {
                System.out.println(communication.getHuman());
            }
        }
    }

    @Override
    public String toString() {
        return name + " " + gender + " " + listCommunication;
    }
}
