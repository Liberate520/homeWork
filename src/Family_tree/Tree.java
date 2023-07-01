package Family_tree;


import java.util.ArrayList;
import java.util.List;

public class Tree {
    private int memberId;
    private List<Human> family;

    public Tree() {
        this.family = new ArrayList<>();
    }

    public void addFamilyMember(Human member){
        if (!(member == null)
                && !family.contains(member)){
            family.add(member);
            member.setId(memberId++);
        }
    }

    public void getSiblings(Human child)
    {
        List<Human> siblings = new ArrayList<>();
        for (Human parent : child.getParents().keySet()) {
            for (Human sibling : parent.getChildren().keySet()) {
                if(!child.equals(sibling)
                        && !siblings.contains(sibling)) siblings.add(sibling);
            }
        }
        for (Human sibling : siblings) {
            if(sibling.getGender().equals(Gender.female)) System.out.printf("%s - Сестра\n", sibling.getFullName());
            else if(sibling.getGender().equals(Gender.male)) System.out.printf("%s - Брат\n", sibling.getFullName());
        }
    }


    @Override
    public String toString() {
        return treeInfo();
    }
    public String treeInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human member : this.family) {
            sb.append(member.getId()).append(". ").append(member.getFullName()).append("\n");
        }
        return sb.toString();
    }
}
