import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private List<Human> humanList;

    public Tree(){
        this(new ArrayList<>());
    }
    public Tree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }



    public Human findHumanName(String name) {
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

//    public List<Human> getChildrenOfHuman(Human human) {
//        List<Human> children = new ArrayList<>();
//        for (Human h : humanList) {
//            if (h.getFather() == human || h.getMother() == human) {
//                children.add(h);
//            }
//
//        }
//        if(children.isEmpty()){
//            children.add(new Human("Нет детей"));
//        }
//
//        return children;
//    }
//
//    public List<Human> getParentsOfHuman(Human human) {
//        List<Human> parents = new ArrayList<>();
//        for (Human h : humanList) {
//            if (h.getChildren().contains(human)) {
//                parents.add(h);
//            }
//
//        }
//        if(parents.isEmpty()){
//            parents.add(new Human("Нет родителей"));
//        }
//        return parents;
//    }
//
//    public String getHumanList() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Human human : humanList) {
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }
//
//    public void setHumanList(List<Human> humanList) {
//        this.humanList = humanList;
//    }

//    @Override
//    public void writeExternal(Human human, String filePath) throws IOException {
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
//        outputStream.writeObject(human);
//        outputStream.close();
//
//    }
//
//    @Override
//    public Human readExternal(String filePath) throws IOException, ClassNotFoundException {
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
//        Human human = (Human) inputStream.readObject();
//        inputStream.close();
//        return human;
//    }


//    @Override
//    public void writeExternal(Human human, String filePath) throws IOException {
//        outputStream.writeObject(human);;
//    }
//
//    @Override
//    public Human readExternal(String filePath) throws IOException, ClassNotFoundException {
//        humanList = (List<Human>) in.readObject();
//    }




}