import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeObject> implements Serializable, Iterable<E>{
    
    private List<E> familyMembers;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> familyMembers){
        this.familyMembers = familyMembers;
    }

    public List<E> getAllMembers(){
        return familyMembers;
    }

    public List<E> getMembersByName(String name){
        List<E> res = new ArrayList<>();
        for (int i = 0; i < familyMembers.size(); i++) {
            if (familyMembers.get(i).getFullName().indexOf(name)>=0){
                res.add(familyMembers.get(i));
            }
        }
        return res;
    }

    // public void addMember(E human, E mother, E father){
    public void addMember(E human){
        if(!familyMembers.contains(human)){
            familyMembers.add(human);
            // if(mother!=null){
            //     human.setMother(mother);
            //     if(!mother.getChildren().contains(human)){
            //         mother.addChild(human);
                // }
            //    }
            // if(father!=null){
            //    human.setFather(father);
            //    if(!father.getChildren().contains(human)){
            //         father.addChild(human);
            //     }
            // }
            }
        }

        @Override
        public Iterator<E> iterator(){
            return new HumanIterator<>(familyMembers); 
        }

        public void sortByName(){
            familyMembers.sort(new HumanComporatorByName<>());
        }

        public void sortByAge(){
            familyMembers.sort(new HumanComporatorByAge<>());
        }

        // public void sort(){
        //     Collections.sort(familyMembers);
        // }
    }
