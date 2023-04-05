import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class FamilyTree implements Serializable {
    private ArrayList<FamilyTreeMemeber> memebers;

    FamilyTree() {
        this.memebers = new ArrayList<FamilyTreeMemeber>();
    }

    public int total() {
        return memebers.size();
    }

    public FamilyTreeMemeber getFirstMemeber() {
        return memebers.get(0);
    }

    public FamilyTreeMemeber getMemeberById(int memeberId) {
        return memebers.get(memeberId);
    }

    public FamilyTreeMemeber[] getAllFamilyMemebers() {
        return memebers.toArray(new FamilyTreeMemeber[0]);
    }

    public FamilyTreeMemeber addChild(String name, String sex, Date birthDay, int[] parentIds) {
        FamilyTreeMemeber[] parents = parentIds != null
                ? new FamilyTreeMemeber[] { memebers.get(parentIds[0]), memebers.get(parentIds[1]) }
                : null;
        var child = new FamilyTreeMemeber(memebers.size(), name, sex, birthDay, parents);
        memebers.add(child);
        return child;
    }

    public FamilyTreeMemeber addChild(String name, String sex, Date birthDay) {
        return addChild(name, sex, birthDay, null);
    }

    public FamilyTreeMemeber addSpouse(String name, Date birthDay, int memberId) throws Exception {
        if (memberId >= memebers.size())
            throw new Exception("Invalid memberId");
        FamilyTreeMemeber member = memebers.get(memberId);
        String sex = member.sex() == "мужской" ? "женский" : "мужской";
        var spouse = new FamilyTreeMemeber(memebers.size(), name, sex, birthDay, null);
        member.spouse(spouse);
        memebers.add(spouse);
        return spouse;
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        for (FamilyTreeMemeber memeber : memebers)
            str.append("\n" + memeber.toString());
        return str.toString();
    }

    public boolean save(IFamilyTreeSaver saver) {
        return saver.save(this);
    }
}