package homeWork.tree2.backend.familyTree;

import homeWork.tree2.backend.familyTree.comparator.HumanObjectInterfaceComparatorbyId;
import homeWork.tree2.backend.familyTree.comparator.HumanObjectInterfaceComparatorbyName;
import homeWork.tree2.backend.human.HumanObjectInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class FamilyTree<E extends HumanObjectInterface> implements Serializable, Family<E> {
    private ArrayList<E> families;

    public FamilyTree() {
        families = new ArrayList<>();
    }

    public ArrayList<E> familyMembersList() {
        return families;
    }

    public String getFamilies() {
        StringBuilder sb = new StringBuilder();
        for (E person : families) {
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }

    public HumanObjectInterface findPersonByName(FamilyTree family, String name) {
        for (HumanObjectInterface man : families) {
            if (man.getName().equalsIgnoreCase(name)) {
                return man;
            }
        }
        return null;
    }

    public void deleteByName(FamilyTree family, String name) {
        for (HumanObjectInterface person : families) {
            if (person.getName().equalsIgnoreCase(name)) {
                families.remove(person);
                System.out.println("\nПользователь " + person.getName() + " успешно удален!\n");
                break;
            }
        }
        System.out.println("\nТакого человека в базе нет!\n");
    }

    @Override
    public void addPeople(E person) {
        families.add(person);
    }


    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator(families);
    }

    public void sortByName() {
        families.sort(new HumanObjectInterfaceComparatorbyName());
    }

    public void byNamereverse() {
        families.sort(new HumanObjectInterfaceComparatorbyName().reversed());
    }


    public void sortById() {
        families.sort(new HumanObjectInterfaceComparatorbyId());
    }

    public void byIdreverse() {
        families.sort(new HumanObjectInterfaceComparatorbyId().reversed());
    }

    public void delete() {
        this.families.clear();
    }
}