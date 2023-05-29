import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        boolean found = false;
        for (Human addedHuman : humanList) {
            if (human.getFirstName().equalsIgnoreCase(addedHuman.getFirstName())) {
                if (human.getLastName().equalsIgnoreCase(addedHuman.getLastName())) {
                    if (human.getBirthDate() != addedHuman.getBirthDate()) {
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            humanList.add(human);
        }
    }

    public List<Human> getParents(Human child) {
        List<Human> parents = new ArrayList<>();
        if (child.getMother() != null) parents.add(child.getMother());
        if (child.getFather() != null) parents.add(child.getFather());
        return parents;
    }

    public List<Human> getChildren(Human parent) {
        List<Human> children = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getFather() == parent && human.getFather() != null){
                children.add(human);
            }
            if (human.getMother() == parent && human.getMother() != null){
                children.add(human);
            }
        }
        return children;
    }

    public Human findHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getFirstName().equalsIgnoreCase(name)
                    || human.getLastName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public Human findHumanByBirthDate(String birthDate) {
        for (Human human : humanList) {
            if (human.getBirthDate().getYear() == Integer.parseInt(birthDate)) {
                return human;
            }
        }
        return null;
    }

    public Integer getHumanYearsOld(Human human) {
        LocalDate date = LocalDate.now();
        Integer yearNow = date.getYear();
        Integer monthNow = date.getMonthValue();
        Integer birthYear = human.getBirthDate().getYear();
        Integer birthMonth = human.getBirthDate().getMonthValue();
        if (monthNow < birthMonth) return yearNow - birthYear - 1;
        else return yearNow - birthYear;
    }

    public String getHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
