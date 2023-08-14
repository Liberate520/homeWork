package FamilyTree.Tree.model.HumanGroup;

import FamilyTree.Tree.model.FileHander.Writable;
import FamilyTree.Tree.model.HumanGroup.Human.Human;

public class Service {

    public HumanGroup<Human> group;


    public Service() {
        group = new HumanGroup<>();
    }


    public String getHumansInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for (Human human : group) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return getHumansInfo();
    }

    public void sortByName() {
        group.sortByName();
    }

    public void sortPatronymic() {
        group.sortPatronymic();
    }

    public void sortDateOfBirth() {
        group.sortDateOfBirth();
    }


    public void saveFam(String path) {
        Writable.save(path);
    }

    public void readFam(Object path) {
        Writable.load(path);
    }

    public String addChildren(HumanGroup humanGroup, String name, String surname, String dateOfBirth) {
        if (humanGroup == null) {
            return "Родитель не найден!";
        } else {
            humanGroup.addChildren(new HumanGroup(group, name, surname, dateOfBirth));
            if (addHuman(name, surname, dateOfBirth) == null) {
                return "Ошибка!";
            } else {
                return "Потомок добавлен успешно!";
            }
        }
    }

    private Object addHuman(String name, String surname, String dateOfBirth) {
        return null;
    }

    public String addParent(HumanGroup humanGroup, String name, String surname, String gender, String dateOfBirth){
        if(humanGroup == null){
            return "Объект не найден!";
        }


        if(gender.equalsIgnoreCase("male")){
            humanGroup.setFather(new HumanGroup(group, name, surname, gender));

        }

        if(gender.equalsIgnoreCase("female")){
            humanGroup.setMother(new HumanGroup(group, name, surname, gender));
        }
        if(addHuman(name, surname, dateOfBirth) == null){
            return "Ошибка!";
        }

        return "Родитель добавлен спешно!";


    }
}
