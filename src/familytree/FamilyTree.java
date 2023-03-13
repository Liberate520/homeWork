package familytree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import familytree.serializer.*;

/**
 * FamilyTree
 */
public class FamilyTree implements Serializable, Iterable<FamilyTreeMemeber> {
    private ArrayList<FamilyTreeMemeber> memebers;
    private SortMode sortMode;

    public FamilyTree() {
        this.memebers = new ArrayList<FamilyTreeMemeber>();
        sortMode = SortMode.noSort;
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

    // public FamilyTreeMemeber[] getAllFamilyMemebers() {
    // return memebers.toArray(new FamilyTreeMemeber[0]);
    // }

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
        for (FamilyTreeMemeber memeber : this)
            str.append("\n" + memeber.toString());
        return str.toString();
    }

    public boolean save(IFamilyTreeSaver saver) {
        return saver.save(this);
    }

    public void setSortMode(SortMode sortMode) {
        this.sortMode = sortMode;
    }
    
    public Iterator<FamilyTreeMemeber> iterator() {
        return new IterSort();
    }

    private class IterSort implements Iterator<FamilyTreeMemeber>, Comparator<FamilyTreeMemeber> {
        private Iterator<FamilyTreeMemeber> iter;

        IterSort() {
            if (sortMode == SortMode.noSort) {
                iter = memebers.stream().iterator();
            } else {
                iter = memebers.stream().sorted(this).iterator();
            }
        }

        public boolean hasNext() {
            return iter.hasNext();
        }

        public FamilyTreeMemeber next() {
            return iter.next();
        }

        public int compare(FamilyTreeMemeber o1, FamilyTreeMemeber o2) {
            switch (sortMode) {
                case name:
                    return  o1.name().compareTo(o2.name());
                case birthDay:
                    return  o1.birthDay().compareTo(o2.birthDay());
                case noSort:
                    break;
            }
            return 0;
        }
    }

    public enum SortMode {
        name, birthDay, noSort
    }
}