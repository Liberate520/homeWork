import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> humanList;
    public FamilyTree(){this(new ArrayList<>());}
    public FamilyTree(List<Human> humanList) {this.humanList = humanList;}

    public void addHumanToTree (Human human) {
        if (human == null) {
            System.out.println("Некорректно указаны данные для добавления");
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addMother(human);
            }
        }
    }




    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве содержится ");
        sb.append(humanList.size());
        sb.append(" записей \n");
        for (Human human: humanList){
            sb.append(human.getInfoHuman());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Human getBySurname(String surname){
        for (Human human : humanList){
            if (human.getSurname().equals(surname)){
                return human;
            }
            else System.out.println("С такой фамилией человек не найден");
        }
        return null;
    }
    public Human getByID(int id){
        for (Human human : humanList){
            if (human.getHumanID() == (id)){
                return human;
            }
            else System.out.println("С таким ID человек не найден");
        }
        return null;
    }
}
