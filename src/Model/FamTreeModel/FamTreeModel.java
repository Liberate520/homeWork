package Model.FamTreeModel;



import Model.FamTreeModel.Human.ComparatorAge;
import Model.FamTreeModel.Human.ComparatorName;
import Model.FamTreeModel.Human.Member;

import java.io.Serializable;
import java.util.*;

public class FamTreeModel implements Serializable, Iterable {

    private long humId;
    private List<Member> memberList;

    public FamTreeModel() {

        this.humId = 1;
        this.memberList = new ArrayList<>();
    }
    public FamTreeModel(List<Member> memberList) {
        this.memberList = memberList;
    }



    public boolean addMemb(Member member){
        if (member == null) {
            return false;
        }

        if (!memberList.contains(member)){
            memberList.add(member);
            member.setId(humId++);
            addToPerents(member);
            addToChildren(member);
        }
        return true;
    }

    //добавить родительские связи
    private void addToPerents(Member member){
        Member mother = member.getMother();
        Member father = member.getFather();
        if(mother != null){
            mother.addChildren(member);
        }
        if(father != null){
            father.addChildren(member);
        }
    }

    public void addChildrens(long id, Member child){
        for (Member member: memberList)
            if (member.getId() == id) member.addChildren(child);
        if (!memberList.contains(child)) {
            addMemb(child);
            addToPerents(child);


        }
    }
    private void addToChildren(Member member) {
        if (member.getChildren() != null) {
            for (Member child : member.getChildren()) {
                addToPerents(child);
            }
        }
    }
    public Member getMemberById(long id){
        for (Member member: memberList){
            if (member.getId() == id){
                return member;
            }
        }
    return null;
    }

    public List<Member> getByFullName(String name, String soname){
        List<Member> res = new ArrayList<>();
        for (Member member: memberList) {
            if (member.getFirstName().equals(name) && member.getLastName().equals(soname)){
                res.add(member);

            }

        }
        return res;
    }
//    public List<E> getGrandFathers(E member) {
//        ArrayList<E> grandFathers;
//        grandFathers = new ArrayList<>();
//        if (member.getMother() != null) {
//            grandFathers.get(0) = member.getMother().getFather();
//        }
//        if(member.getFather() != null) {
//            grandFathers.get(1) = member.getFather().getFather();
//        }
//        return grandFathers;
//    }
//    public Model.FamTree.member[] getGrandMothers(Model.FamTree.member member) {
//        Model.FamTree.member[] grandMothers = new Model.FamTree.member[2];
//        if (member.getMother() != null) {
//            grandMothers[0] = member.getMother().getMother();
//        }
//        if(member.getFather() != null) {
//            grandMothers[1] = member.getFather().getMother();
//        }
//        return grandMothers;
//    }


@Override
    public String toString(){
    return getTreeInf();
    }

    public String getTreeInf(){
        StringBuilder sb = new StringBuilder();
        sb.append("Family tree ");
        sb.append('\n');
        for (Member member: memberList) {
            sb.append(member.getInfo());
            sb.append('\n');
        }
        return sb.toString();
    }

       public void sortName(){

        memberList.sort(new ComparatorName());

    }

    public void sortAge(){
        memberList.sort(new ComparatorAge());
    }


    @Override
    public Iterator iterator() {
        return new MemberIterator(memberList) ;
    }
}

