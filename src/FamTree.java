import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamTree {
//    private List<Human> humans;
//    private Map<Human, List<Human>> relationships;
//
//    public FamTree() {
//        this.humans = new ArrayList<>();
//        this.relationships = new HashMap<>();
//
//    }
//    public void addPers(Human person){
//        humans.add(person);
//    }
//    public void addParentChildRelationship(Human parent, Human child) {
//        if (!relationships.containsKey(parent)) {
//            relationships.put(parent, new ArrayList<>());
//        }
//        relationships.get(parent).add(child);
//    }
    private long humId;
    private List<Human> humanList;

    public FamTree() {
        this(new ArrayList<>());
    }
    public FamTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public boolean addHum(Human human){
        if (human == null) {
            return false;
        }

        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humId++);
            addToPerents(human);
            addToChildren(human);
        }
        return true;
    }

    private void addToPerents(Human human){
        Human mother = human.getMother();
        Human father = human.getFather();
        if(mother != null){
            mother.addChildren(human);
        }
        if(father != null){
            father.addChildren(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            addToPerents(human);
        }
    }
    public Human getHumahById(long id){
        for (Human human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
    return null;
    }

    public List<Human> getByFullName(String name, String soname){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if (human.getFirstName().equals(name) && human.getLastName().equals(soname)){
                res.add(human);

            }

        }
        return res;
    }
}
