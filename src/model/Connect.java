package model;

public class Connect implements ElementAddConnection{
    @Override
    public void addConnection(TreeElement thisTreeElement, TreeElement treeElement, FamilyConnectionType connectionType) {
        if ((connectionType == FamilyConnectionType.son || connectionType == FamilyConnectionType.daughter)
                &&  thisTreeElement.getGender() == Gender.male) {
            treeElement.getConnectionList().add(new FamilyConnection(thisTreeElement, FamilyConnectionType.father));
        } else if ((connectionType == FamilyConnectionType.son || connectionType == FamilyConnectionType.daughter)
                && thisTreeElement.getGender() == Gender.female) {
            treeElement.getConnectionList().add(new FamilyConnection(thisTreeElement, FamilyConnectionType.mother));
        } else if ((connectionType == FamilyConnectionType.father || connectionType == FamilyConnectionType.mother)
                && thisTreeElement.getGender() == Gender.male) {
            treeElement.getConnectionList().add(new FamilyConnection(thisTreeElement, FamilyConnectionType.son));
        } else if ((connectionType == FamilyConnectionType.father || connectionType == FamilyConnectionType.mother)
                && thisTreeElement.getGender() == Gender.female) {
            treeElement.getConnectionList().add(new FamilyConnection(thisTreeElement, FamilyConnectionType.daughter));
        }
        treeElement.getConnectionList().add(new FamilyConnection(treeElement, connectionType));
    }
}
