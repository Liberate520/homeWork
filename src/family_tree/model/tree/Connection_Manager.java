package family_tree.model.tree;

import family_tree.model.human.Child_type;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.Parent_Type;

public class Connection_Manager<E extends SentientEntity<E>>{

    public void addParent(E child, E parent, Parent_Type parentType){
        if(!child.getParents().containsKey(parent)) {
            if (parentType.equals(Parent_Type.Foster_Mother)
                    || parentType.equals(Parent_Type.Foster_Father)) {
                child.getParents().put(parent, parentType);
                if(child.getGender().equals(Gender.male)) this.addChild(child, parent, Child_type.Foster_Son);
                else this.addChild(child, parent,  Child_type.Foster_Daughter);
            }
            if ((!child.isHasBioFather()) && (parentType.equals(Parent_Type.Biological_Father))) {
                child.getParents().put(parent, parentType);
                child.setHasBioFather();
                if(child.getGender().equals(Gender.male)) this.addChild(child, parent, Child_type.Biological_Son);
                else this.addChild(child, parent, Child_type.Biological_Daughter);
            }
            if ((!child.isHasBioMother()) && (parentType.equals(Parent_Type.Biological_Mother))) {
                child.getParents().put(parent, parentType);
                child.setHasBioMother();
                if(child.getGender().equals(Gender.male)) this.addChild(child, parent, Child_type.Biological_Son);
                else this.addChild(child, parent, Child_type.Biological_Daughter);
            }
        }
    }
    public void addChild(E child, E parent, Child_type childType){
        if(!parent.getChildren().containsKey(child)) {
            parent.getChildren().put(child, childType);
            if (childType.equals(Child_type.Foster_Son) || childType.equals(Child_type.Foster_Daughter)) {
                if (parent.getGender().equals(Gender.male)) {
                    this.addParent(child, parent, Parent_Type.Foster_Father);
                } else {
                    this.addParent(child, parent, Parent_Type.Foster_Mother);
                }
            } else {
                if (parent.getGender().equals(Gender.male)) {
                    this.addParent(child, parent, Parent_Type.Biological_Father);
                } else {
                    this.addParent(child, parent, Parent_Type.Biological_Mother);
                }
            }
        }
    }

    public boolean wedding(E husband, E wife){
        if(husband.isMarried() || wife.isMarried()){
            return false;
        }
        else {
            husband.setSpouse(wife);
            wife.setSpouse(husband);
            return true;
        }
    }

    public boolean divorce(E husband, E wife){
        if (!husband.isMarried() || !wife.isMarried()) return false;
        else if (husband.getSpouse().equals(wife) && wife.getSpouse().equals(husband)) {
            husband.removeSpouse();
            wife.removeSpouse();
            return true;
        }
        return false;
    }
}
