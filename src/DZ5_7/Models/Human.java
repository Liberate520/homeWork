package DZ5_7.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private TypeGender gender;
    private List<FamilyCommunication> listCommunication;

    public Human(String name, TypeGender gender) {
        this.name = name;
        this.gender = gender;
        this.listCommunication = new ArrayList<>();
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

    private void addCommunication(FamilyCommunication communication) {
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

    public void delCommunication(Human human) {
        for (FamilyCommunication familyCommunication : human.getListCommunication()) {
            Human hum = familyCommunication.getHuman();
            for (FamilyCommunication familyCommunication2 : hum.getListCommunication()) {
                if (familyCommunication2.getHuman().equals(human)) {
                    familyCommunication.getHuman().getListCommunication().remove(familyCommunication2);
                    break;
                }
            }
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
        String res = "";
        for (FamilyCommunication familyCommunication : listCommunication) {
            res += familyCommunication;
        }
        return name + " (" + gender + ") Родственные связи: " + res;
    }
}
