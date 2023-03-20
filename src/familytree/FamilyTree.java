package familytree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import familytree.serializer.*;

/**
 * FamilyTree
 */
public class FamilyTree<T extends FamilyTreeMemeber> implements Serializable, Iterable<T> {
    private ArrayList<T> memebers;
    private SortMode sortMode;
    private Predicate<T> filter;
    private IMemeberFactory<T> memeberFactory;

    public FamilyTree(IMemeberFactory<T> memeberFactory) {
        this.memebers = new ArrayList<T>();
        sortMode = SortMode.noSort;
        filter = null;
        this.memeberFactory = memeberFactory;
    }

    public int total() {
        return memebers.size();
    }

    public T getFirstMemeber() {
        return memebers.get(0);
    }

    public T getMemeberById(int memeberId) {
        return memebers.get(memeberId);
    }

    public String getStringMembers(SortMode sortMode, int id, String name) {
        SortMode smode = this.sortMode;
        Predicate<T> filter = this.filter;
        switch (sortMode) {
            case name:
                setSortMode(SortMode.name);
                break;
            case birthDay:
                setSortMode(SortMode.birthDay);
                break;
            case noSort:
                setSortMode(SortMode.noSort);
                break;
        }
        if(id >= 0)
            setFilter(x -> x.id() == id);
        else if(name != null)
            setFilter(x -> x.name() == name);
        String result = this.toString();
        this.sortMode = smode;
        this.filter = filter;
        return result;
    }
    
    // public FamilyTreeMemeber[] getAllFamilyMemebers() {
    // return memebers.toArray(new FamilyTreeMemeber[0]);
    // }

    public T addChild(String name, String sex, Date birthDay, int[] parentIds) {
        ArrayList<T> parents =null;
        if(parentIds != null) {
            parents = new ArrayList<T>();
            parents.add(memebers.get(parentIds[0]));
            parents.add(memebers.get(parentIds[1]));
        }
        T child = memeberFactory.getTreeMemeber(memebers.size(), name, sex, birthDay, parents);
        memebers.add(child);
        return child;
    }

    public T addMember(T member) {
        member.id = memebers.size();
        memebers.add(member);
        return member;
    }

    public T addChild(String name, String sex, Date birthDay) {
        return addChild(name, sex, birthDay, null);
    }

    // public T addSpouse(String name, Date birthDay, int memberId) throws Exception {
    //     if (memberId >= memebers.size())
    //         throw new Exception("Invalid memberId");
    //     FamilyTreeMemeber member = memebers.get(memberId);
    //     String sex = member.sex() == "мужской" ? "женский" : "мужской";
    //     T spouse = memeberFactory.getTreeMemeber(memebers.size(), name, sex, birthDay, null);
    //     member.spouse(spouse);
    //     memebers.add(spouse);
    //     return spouse;
    // }

    @Override
    public String toString() {
        var str = new StringBuilder();
        for (T memeber : this)
            str.append("\n" + memeber.toString());
        return str.toString();
    }

    public boolean save(IFamilyTreeSaver saver) {
        return saver.save(this);
    }

    public void setSortMode(SortMode sortMode) {
        this.sortMode = sortMode;
    }

    public void setFilter(Predicate<T> filter) {
        this.filter = filter;
    }
    
    public Iterator<T> iterator() {
        return new IterSort();
    }

    private class IterSort implements Iterator<T>, Comparator<T> {
        private Iterator<T> iter;

        IterSort() {
            Stream<T> stream = null;
            if (sortMode == SortMode.noSort) {
                stream = memebers.stream();
            } else {
                stream = memebers.stream().sorted(this);
            }
            if(filter != null)
                stream = stream.filter(filter);
            iter = stream.iterator();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }

        public T next() {
            return iter.next();
        }

        public int compare(T o1, T o2) {
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
}