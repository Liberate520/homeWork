package Model;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Human.Gender;
import Model.home_work_class.Human.Human;
import Model.home_work_class.Write.WriteRead;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private FamilyTree<Human> familyTree;
    private WriteRead file;

    public Model(WriteRead file){
        this.familyTree = new FamilyTree<>();
        this.file = file;
    }

    public void addHuman(String name, Gender gender, LocalDate bornDate, LocalDate diedDate){
        Human human = new Human(name, gender, bornDate, diedDate);
        familyTree.addHuman(human);
    }

    public String getHumansListInfo(){
        return familyTree.showHumansList();
    }

    public Human findHumanByName(String name){
        List<Human>humans = familyTree.findHumanByName(name);
        if (!humans.isEmpty()) {return humans.get(0);}
        return new Human("not found", Gender.Male, LocalDate.of(1,1,1));
    }

    public List<Human> getListChildren(List<String> names){
        List<Human> childrenList = new ArrayList<>();
        for (String children: names) {
            Human human = findHumanByName(children);
            if (! human.getName().equals("not found")){
                childrenList.add(human);
            }
        }
        return childrenList;
    }

    public boolean addChildrenToParent(String parent, List<Human> childrenList){
        boolean res = false;
        Human human = findHumanByName(parent);
        if (! human.getName().equals("not found")) {
            human.addChildren(childrenList);
            res = true;
        }
        return res;
    }

    public void sortByName(){familyTree.sortByName();}

    public void sortByAge(){familyTree.sortByAge();}

    public void sortById(){familyTree.sortById();}

    public boolean fileWriter(String path){return file.fileWriter(path, this.familyTree);}

    public  boolean fileReader(String path){
        this.familyTree = file.fileReader(path);
        return this.familyTree.sizeTree() > 0;
    }
}
