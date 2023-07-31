import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Serializable> implements Serializable, Iterable<T> {
    private List<T> elements;

    public FamilyTree() {
        elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void addHuman(T human) {
        elements.add(human);
    }

    public T findElementByName(String name) {
        for (T element : elements) {
            if (element instanceof Human) {
                Human human = (Human) element;
                if (human.getFirstName().equals(name) || human.getLastName().equals(name)) {
                    return element;
                }
            }
        }
        return null;
    }

    public T findElementByFullName(String fullName) {
        for (T element : elements) {
            if (element instanceof Human) {
                Human human = (Human) element;
                String fullNameFromHuman = human.getFirstName() + " " + human.getLastName();
                if (fullNameFromHuman.equals(fullName)) {
                    return element;
                }
            }
        }
        return null;
    }

    public List<T> getAllElements() {
        return elements;
    }

    public List<Human> getChildrenOfFather(Human father) {
        List<Human> children = new ArrayList<>();
        for (T element : elements) {
            if (element instanceof Human) {
                Human human = (Human) element;
                if (human.getFather() != null && human.getFather().equals(father)) {
                    children.add(human);
                }
            }
        }
        return children;
    }

    public List<Human> getChildrenOfMother(Human mother) {
        List<Human> children = new ArrayList<>();
        for (T element : elements) {
            if (element instanceof Human) {
                Human human = (Human) element;
                if (human.getMother() != null && human.getMother().equals(mother)) {
                    children.add(human);
                }
            }
        }
        return children;
    }

    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public void sortByFirstName() {
        elements.sort((o1, o2) -> {
            if (o1 instanceof Human && o2 instanceof Human) {
                return ((Human) o1).getFirstName().compareTo(((Human) o2).getFirstName());
            }
            return 0;
        });
    }

    public void sortByBirthDate() {
        elements.sort((o1, o2) -> {
            if (o1 instanceof Human && o2 instanceof Human) {
                return ((Human) o1).getBirthDate().compareTo(((Human) o2).getBirthDate());
            }
            return 0;
        });
    }
}

