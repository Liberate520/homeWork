package familytree;

import java.util.ArrayList;
import java.util.Date;

public class FamilyTreeMemeberFactory implements IMemeberFactory<FamilyTreeMemeber> {

    @Override
    public FamilyTreeMemeber getTreeMemeber(int id, String name, String sex, Date birthDay,ArrayList<FamilyTreeMemeber> parents) {
        return new FamilyTreeMemeber(id, name, sex, birthDay, parents);
    }
    
}
