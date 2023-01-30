package models;

import java.util.HashMap;
import java.util.Map;

import enums.Gender;

public class FamilyTreeDemoGenerator<T extends Human> {
    private Map<String, T> familyTree;

    @SuppressWarnings("unchecked")
    public FamilyTreeDemoGenerator(Map<String, T> familyTree) {
       this.familyTree = familyTree;

        T a = (T) new Human("Беляева", "Мария", "Александровна", Gender.WOMAN);
        T b = (T) new Human("Беляев", "Владимир", "Кириллович", Gender.MAN);
        T c = (T) new Human("Беляев", "Юрий", "Владмирович", Gender.MAN);
        T d = (T) new Human("Беляева", "Марина", "Владмировна", Gender.WOMAN);

        a.setSpouse(b);

        c.setParentFather(b);
        c.setParentMother(a);

        d.setParentFather(b);
        d.setParentMother(a);

        T e = (T) new Human("Зайцева", "Галина", "Васильевна", Gender.WOMAN);
        T f = (T) new Human("Зйцев", "Николай", "Иванович", Gender.MAN);
        T g = (T) new Human("Зайцева", "Ирина", "Николаевна", Gender.WOMAN);

        e.setSpouse(f);

        g.setParentFather(f);
        g.setParentMother(e);

        c.setSpouse(g);

        T h = (T) new Human("Беляева", "Вероника", "Юрьевна", Gender.WOMAN);

        h.setParentFather(g);
        h.setParentMother(c);

        this.familyTree.put(a.getUuid(), a);
        this.familyTree.put(b.getUuid(), b);
        this.familyTree.put(c.getUuid(), c);
        this.familyTree.put(d.getUuid(), d);
        this.familyTree.put(e.getUuid(), e);
        this.familyTree.put(f.getUuid(), f);
        this.familyTree.put(g.getUuid(), g);
        this.familyTree.put(h.getUuid(), h);
    }

    public Map<String, T> getFamilyTree() {
        return familyTree;
    }

    
}
