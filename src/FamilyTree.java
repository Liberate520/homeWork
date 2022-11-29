package DZ.DZ2;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements interfaceFamilyTree{
    private List<Human> listHuman;

    private FamilyTree(List<Human> listHuman) {
        this.listHuman = listHuman;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getListHuman() {
        return listHuman;
    }

    public void setListHuman(List<Human> listHuman) {
        this.listHuman = listHuman;
    }

    @Override
    public void addHuman(Human human) {
        listHuman.add(human);
    }

    @Override
    public void findHuman(Human human) {
        System.out.println(listHuman.get(listHuman.indexOf(human)));
    }

    @Override
    public void findHuman(String name) {
        for (Human human : listHuman) {
            if (human.getName().indexOf(name) >= 0){
                System.out.println("Результат поиска: " + human);
            }
        }
    }

    
    
    
    

    @Override
    public String toString() {        
        return  listHuman.toString();        
    }    
}
