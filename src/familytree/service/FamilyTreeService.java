package familytree.service;

import java.util.Date;
import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;
import familytree.SortMode;
import familytree.serializer.IFamilyTreeSerializer;

public class FamilyTreeService implements IFamilyTreeService {
    private IFamilyTreeSerializer serializer;
    private FamilyTree<FamilyTreeMemeber> familyTree;

    public FamilyTreeService(IFamilyTreeSerializer serializer) {
        this.serializer = serializer;
        this.familyTree = null;
    }

    public String addMember(String name, String sex, Date birthDay, int[] parentIds) {
        FamilyTreeMemeber[] parents = null;
        if (parentIds != null) {
            parents = new FamilyTreeMemeber[] {
                    familyTree.getMemeberById(parentIds[0] - 1),
                    familyTree.getMemeberById(parentIds[1] - 1)
            };
        }
        FamilyTreeMemeber member = new FamilyTreeMemeber(name, sex, birthDay, parents);
        familyTree.addMember(member);
        serializer.save(familyTree);
        return member.toString();
    }

    public String getMembers(SortMode sortMode, int id, String name) {
        switch (sortMode) {
            case name:
                familyTree.setSortMode(SortMode.name);
                break;
            case birthDay:
                familyTree.setSortMode(SortMode.birthDay);
                break;
            case noSort:
                familyTree.setSortMode(SortMode.noSort);
                break;
        }
        if (id - 1 >= 0)
            familyTree.setFilter(x -> x.id() == id - 1);
        else if (name != null)
            familyTree.setFilter(x -> x.name() == name);
        else
            familyTree.setFilter(null);
        return familyTree.toString();
    }

    public String updateMember(int id, String name, Date deathDay) {
        FamilyTreeMemeber member = familyTree.getMemeberById(id - 1);
        if(name != null)
            member.name(name);
        if(deathDay != null)
            member.deathDay(deathDay);
        serializer.save(familyTree);
        return member.toString();
    }

    public FamilyTree<FamilyTreeMemeber> createFamilyTree() {
        if (familyTree != null)
            return familyTree;
        familyTree = serializer.load();
        if (familyTree == null) {
            createDefaultFamilyTree();
            serializer.save(familyTree);
        }
        return familyTree;
    }

    private FamilyTree<FamilyTreeMemeber> createDefaultFamilyTree() {
        familyTree = new FamilyTree<FamilyTreeMemeber>();
        FamilyTreeMemeber[] ms = new FamilyTreeMemeber[2];
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Николай Лысенко", "мужской", date(5, 2, 40), null));
        ms[1] = familyTree.addMember(new FamilyTreeMemeber("Светлана Петрова", "женский", date(20, 10, 45), null));
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Роман Лысенко", "мужской", date(4, 7, 65), ms));
        ms[1] = familyTree.addMember(new FamilyTreeMemeber("Мария Федорова", "женский", date(6, 3, 72), null));
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Иван Лысенко", "мужской", date(14, 8, 95), ms));
        ms[1] = familyTree.addMember(new FamilyTreeMemeber("Анна Владимирова", "женский", date(26, 6, 99), null));
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Ольга Лысенко", "женский", date(30, 9, 120), ms));
        return familyTree;
    }

    private Date date(int day, int month, int year) {
        return new Date(year, month, day);
    }
}
