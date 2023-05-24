package Home.model.human.familyTree;

import Home.model.human.Human;
import Home.model.human.comparators.HumanComparatorByAge;
import Home.model.human.comparators.HumantComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E> implements Iterable<E> {
    private List<E> humanList;
    public FamilyTree(){
        humanList = new ArrayList<>();
    }
    public  void addToFamily(E e){
        humanList.add(e);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumantComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    public String getMotherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Mother:").append("\n");
        if (human.getMother() != null) {
            sb.append(human.getMother().getName()).append(", ").append("age: ").append(human.getMother().getAge()).append('\n');
            if (human.getMother().getMother() != null) {
                sb.append(human.getName()).append(" maternal").append(" grandmother:").append("\n");
                sb.append(human.getMother().getMother().getName()).append(", ").append("age: ").append(human.getMother().getMother().getAge()).append('\n');
            }
            if (human.getMother().getFather() != null) {
                sb.append(human.getName()).append(" maternal").append(" grandfather:").append("\n");
                sb.append(human.getMother().getFather().getName()).append(", ").append("age: ").append(human.getMother().getFather().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No mother details available.";
        }
    }

    public String getFatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Father:").append("\n");
        if (human.getFather() != null) {
            sb.append(human.getFather().getName()).append(", ").append("age: ").append(human.getFather().getAge()).append('\n');
            if (human.getFather().getFather() != null) {
                sb.append(human.getName()).append(" paternal").append(" grandfather:").append("\n");
                sb.append(human.getFather().getFather().getName()).append(", ").append("age: ").append(human.getFather().getFather().getAge()).append('\n');
            }
            if (human.getFather().getMother() != null) {
                sb.append(human.getName()).append(" paternal").append(" grandmother:").append("\n");
                sb.append(human.getFather().getMother().getName()).append(", ").append("age: ").append(human.getFather().getMother().getAge()).append('\n');
            }
            return sb.toString();
        } else {
            return "No father details available.";
        }
    }
    public String getGrandfatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        if (human.getFather().getFather() != null) {
            sb.append(human.getName()).append(" paternal").append(" grandfather:").append("\n");
            sb.append(human.getFather().getFather().getName()).append(", ").append("age: ").append(human.getFather().getFather().getAge()).append('\n');
        }
        if (human.getMother().getFather() != null) {
            sb.append(human.getName()).append(" maternal").append(" grandfather:").append("\n");
            sb.append(human.getMother().getFather().getName()).append(", ").append("age: ").append(human.getMother().getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }
    public String getGrandmatherDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        if (human.getMother().getMother() != null) {
            sb.append(human.getName()).append(" maternal").append(" grandmother:").append("\n");
            sb.append(human.getMother().getMother().getName()).append(", ").append("age: ").append(human.getMother().getFather().getAge()).append('\n');
        }
        if (human.getFather().getMother() != null) {
            sb.append(human.getName()).append(" paternal").append(" grandmother:").append("\n");
            sb.append(human.getFather().getMother().getName()).append(", ").append("age: ").append(human.getFather().getFather().getAge()).append('\n');
            return sb.toString();
        }
        else {
            return "No grandfather details available.";
        }
    }

    public String getChildrenDetails(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(human.getName()).append(" Cildrens:").append("\n");
        if (human.getChildrens() != null) {
            for (Human child : human.getChildrens()) {
                sb.append(child.getName()).append(", ").append("age: ").append(child.getAge()).append("\n");
            }
        } else {
            sb.append('\n').append("No children details available.");
        }
        return sb.toString();
    }


    public String getHumanInfo(Human human){
        StringBuilder sb = new StringBuilder();
        sb.append(human.toString());
        if (human.getMother() != null) {
            sb.append(getMotherDetails(human));
        }
        if (human.getFather() != null) {
            sb.append(getFatherDetails(human));
        }
        return sb.toString();
    }
}
