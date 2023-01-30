package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeElement {
    private Gender gender;
    private String name;
    private List<FamilyConnection> connectionList;

    public TreeElement(String name, Gender gender, List<FamilyConnection> connectionList) {
        this.name = name;
        this.gender = gender;
        this.connectionList = connectionList;
    }
    public TreeElement(String name, Gender gender) {
        this(name, gender, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public List<FamilyConnection> getConnectionList() {
        return connectionList;
    }

    public void addConnection(TreeElement treeElement, FamilyConnectionType connectionType) {
        if ((connectionType == FamilyConnectionType.son || connectionType == FamilyConnectionType.daughter)
                &&  this.gender == Gender.male) {
            treeElement.connectionList.add(new FamilyConnection(this, FamilyConnectionType.father));
        } else if ((connectionType == FamilyConnectionType.son || connectionType == FamilyConnectionType.daughter)
                && this.gender == Gender.female) {
            treeElement.connectionList.add(new FamilyConnection(this, FamilyConnectionType.mother));
        } else if ((connectionType == FamilyConnectionType.father || connectionType == FamilyConnectionType.mother)
                && this.gender == Gender.male) {
            treeElement.connectionList.add(new FamilyConnection(this, FamilyConnectionType.son));
        } else if ((connectionType == FamilyConnectionType.father || connectionType == FamilyConnectionType.mother)
                && this.gender == Gender.female) {
            treeElement.connectionList.add(new FamilyConnection(this, FamilyConnectionType.daughter));
        }
        connectionList.add(new FamilyConnection(treeElement, connectionType));
    }

    public void showConnection(FamilyConnectionType connectionType){
        for (var connection : connectionList) {
            if (connection.getConnectionType() == connectionType) System.out.println(connection.getPerson());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof TreeElement treeElement) {
            return getName().equals(treeElement.getName());
        }
        if (o instanceof String str) {
            return getName().equals(str);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, connectionList);
    }

    @Override
    public String toString() {
        return "gender = " + gender +
                ", name = '" + name + '\'' +
                ", connectionList = " + connectionList;
    }
}
