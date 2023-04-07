package treePackage;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree implements HumanInterface {

    public List<Human> humanList = new ArrayList<>();

   
    // public FamilyTree(List<Human> humanList) {
    //     this.humanList =humanList;
    // }

    

    // метод проверки наличия человека в листе и при его отсутствии добавление
    // человека

    public boolean addNewHuman(Human human, List<Human> list) {

        if (human == null) {

            return false;

        }
        if (!humanList.contains(human)) {

            humanList.add(human);
            if (human.getFather() != null) {

                human.getFather().addChildren(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChildren(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public Human getByFamily(String fam) {
        for (Human human : humanList) {
            if (human.getFamily().equals(fam)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder infoRes = new StringBuilder();
        infoRes.append("В дереве \n");
        infoRes.append(humanList.size() + " ");
        infoRes.append("объекта(ов)\n");
        for (Human human : humanList) {
            infoRes.append(human.getInfo());
        }

        return infoRes.toString();

    }
    
   
    

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    

       
    public List<Human> getHumanList() {
        return humanList;
    }

    
    @Override
    public void addHumanForSort(Human human) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addHumanForSort'");
    }

    


    



    


}