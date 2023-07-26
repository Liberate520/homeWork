package FamilyTree.Tree.HumanGroup;

import FamilyTree.Tree.HumanGroup.Human.Human;


public class Service extends Human {
    private int idHuman;
    private HumanGroup group;

    public Service() {
        group = new HumanGroup();
    }

    public void addHuman( Human human) {
        Human Human = new Human(human);
        group.addHuman(human);
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n" + group);


//        Iterator<Human> iterator = group.iterator();
//        while (iterator.hasNext()) {
//            Human human = iterator.next();
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
        for (Human human: group){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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

}
