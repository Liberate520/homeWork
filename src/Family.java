import java.util.ArrayList;
import java.util.List;

public class Family implements IFamilyMember {
    private Man man;
    private List<FamilyMember> familymembers;

    private Family(Man man, List<FamilyMember> familymembers) {
        this.man = man;
        this.familymembers = familymembers;
    }

    public Family(Man man) {
        this(man, new ArrayList<FamilyMember>());
    }

    public boolean getMarried(Object e) {
        FamilyMember fm = (FamilyMember) e;
        if (fm.getSex() != this.man.getSex()){
            return this.familymembers.add(fm);
        }
        else{
            return false;
        }
    }

    public boolean getDivorce(Object e) {
        FamilyMember fm = (FamilyMember) e;
        CONST.FamilyRelationShip frs = fm.getFrs();
        if ((this.familymembers.contains(fm))
                && ((frs == CONST.FamilyRelationShip.HUSBEND)
                || (frs == CONST.FamilyRelationShip.WIFE))){
            return this.familymembers.remove(fm);    
        }
        else{
            return false;
        }
    }

    public boolean addChild(Object e) {
        FamilyMember fm = (FamilyMember) e;
        CONST.FamilyRelationShip frs = fm.getFrs();
        if ((frs == CONST.FamilyRelationShip.SON) || (frs == CONST.FamilyRelationShip.DAUGHTER)) {
            return this.familymembers.add(fm);
        } else {
            return false;
        }
    }

    public boolean removeFamilyMember(Object e) {
        FamilyMember fm = (FamilyMember) e;
        if (this.familymembers.contains(fm)) {
            return this.familymembers.remove(fm);
        }
        else {
            return false;
        }
        
    }
    
    @Override
    public String toString() {
        String result = this.man.toString() + "\n";

        for (FamilyMember item : this.familymembers) {
            result += item.toString() + "\n";
        }
        return result;
    }
}
