package FamilyTree.Tree.model.HumanGroup;

import FamilyTree.Tree.model.HumanGroup.Human.Human;

public class Service    {

    public HumanGroup<Human> group;


    public Service() {
        group = new HumanGroup<>();
    }

    public void addHuman(Human human) {
        Human Human =  new Human(human);
        group.addHuman(human);
    }
    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for (Human human: group){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    @Override
    public String toString(){
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

    public void addHumans(String name, String patronymic, int dateOfBirth) {
    }
}
