/**
 * app
 */
public class app {

    public static void main(String[] args) {
        //моя семья        
        Man father = new Man("Дмитрий", "Романов", 42, 182, 80, CONST.Sex.MAN);
        Man mother = new Man("Светлана", "Романова", 38, 160, 58, CONST.Sex.WOMAN);

        Family family = new Family(father);
        family.getMarried(new FamilyMember(mother, CONST.FamilyRelationShip.WIFE));
        Man child = new Man("Илья", "Романов", 3, 60, 10, CONST.Sex.MAN);
        family.addChild(new FamilyMember(child, CONST.FamilyRelationShip.SON));
        child = new Man("Жан", "Романов", 3, 30, 15, CONST.Sex.MAN);
        family.addChild(new FamilyMember(child, CONST.FamilyRelationShip.SON));
        child = new Man("Буч", "Романов", 6, 32, 14, CONST.Sex.MAN);
        family.addChild(new FamilyMember(child, CONST.FamilyRelationShip.SON));
        child = new Man("Мадина", "Романова", 3, 25, 13, CONST.Sex.WOMAN);
        family.addChild(new FamilyMember(child, CONST.FamilyRelationShip.DAUGHTER));
        
        System.out.println(family);
    }
}