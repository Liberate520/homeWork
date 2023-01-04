import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Mammal> implements Serializable, Iterable<T> {

    private List<T> memberList;
    private Writable writer;

    public FamilyTree(List<T> memberList) {this.memberList = memberList;}

    public FamilyTree() {this(new ArrayList<T>());}

    public List<T> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<T> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        String s = "";
        for (T member: memberList) {
            s += member + "\n";
        }
        return s;
    }

    public void addMember(T member) {memberList.add(member);
    }

    public T getMemberByName(String name){
        for (T member: memberList){
            if (member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

    public void setWriter(Writable writer) {
        this.writer = writer;
    }

    public void save() {
        if (writer != null)
            writer.save(this);
    }

    public void load() {
        if (writer != null) {
            FamilyTree loadTree = writer.load();
            if (loadTree != null)
                this.setMemberList(loadTree.getMemberList());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyIterator(memberList);
    }

    public void sortByName(){
        Collections.sort(getMemberList());
    }

    public void sortByChildrenCountDesc(){
        Collections.sort(getMemberList(), new ComparatorByChildrenCount());
    }
}
