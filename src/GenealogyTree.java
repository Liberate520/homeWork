import java.io.*;
import java.util.*;


public class GenealogyTree implements Serializable, Iterable<Human>{
    private List<Human> humans;

    public GenealogyTree() { this(new ArrayList<>()); }

    public GenealogyTree(List<Human> humans) {
        this.humans = humans;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        };
        if (!humans.contains(human)){
            humans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
//        sb.append("В дереве ");
//        sb.append(humans.size());
//        sb.append(" объектов:\n ");
        for (Human human: humans){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }


    public void printTree(String tab, Human human) {
        System.out.println(tab + human.toString());
        List<Human> children = human.getChildrens();
        for (Human child : children) {
            printTree("   ", child); // КОСТЫЛЬ!!!
        }
    }

    public Human getByName(String firstname, String lastName){
        for (Human human: humans){
            if (human.getFirstName() == firstname & human.getLastName() == lastName){
                return human;
            }
        }
        return null;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }
    public void sortByAge(){
        humans.sort(new HumanComparatorByAge());
    }
}