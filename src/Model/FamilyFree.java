package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Nimale;
import Comparator.HumanComporatorByAge;
import Comparator.NimaleIterator;

public class FamilyFree<T extends Nimale> implements Iterable<T> {
    private List<T> familyFree;

    public FamilyFree() {
        familyFree = new ArrayList<>();
    }

    public void addFamilyFree(T human) {
        if (!familyFree.contains(human)) {
            familyFree.add(human);
            if (human.getMather() != null) {
                human.getMather().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
        }
    }

    @Override
    public String toString() {
        String res = "ֲ סולüו " + familyFree.size() + " קוכמגוך(א):\n";
        for (int i = 0; i < familyFree.size(); i++) {
            res += (i + 1) + ") " + familyFree.get(i).toString() + "\n";
        }
        return res;
    }

    public T getByName(String nameHuman) {
        for (T human : familyFree) {
            if (human.getName().equalsIgnoreCase(nameHuman)) {
                return human;
            }
        }
        return null;
    }

    public List<T> getFamilyFree() {
        return familyFree;
    }

    @Override
    public Iterator<T> iterator() {
        return new NimaleIterator<T>(familyFree);

    }
}