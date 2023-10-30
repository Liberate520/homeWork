package HomeWork.familyTree.homeWork22_10_23.src.tree;


import HomeWork.familyTree.homeWork22_10_23.src.human.Human;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class FamilyTree implements Serializable {
    private long idHuman;
    private List<Human> humanList ;


    public FamilyTree(){
        humanList = new ArrayList<>();

    }


    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей : \n");
        for(Human human:humanList){
            stringBuilder.append(human.getId());
            stringBuilder.append(" ");
            stringBuilder.append(human.getSurname());
            stringBuilder.append(human.getName());
            stringBuilder.append(human.getPatronymic());
            stringBuilder.append(human.getAge().getYear());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addHuman(Human human){
       if(!humanList.contains(human)) {
           humanList.add(human);
           human.setId(idHuman++);
       }
    }
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        System.out.println("Our writeObject");
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        System.out.println("Our readObject");
    }


}




