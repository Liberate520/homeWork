package Home;

import Home.familyTree.FamilyTree;
import Home.human.Human;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private FamilyTree activeFamily;
    private List<FamilyTree> famylyList;
    public Service(FamilyTree family) {
        this.activeFamily = family;
        famylyList = new ArrayList<>();
        famylyList.add(family);
    }
    public Service(){
        this(new FamilyTree());
    }
    public void addFamily(FamilyTree family){
        famylyList.add(family);
    }

    public Human addHuman(String name, int age){
        activeFamily.addToFamily(new Human(name, age));
        return null;
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();


//

        for (Human human: activeFamily){
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
    public Human getHuman(String name){
        for (Human human: activeFamily){
            if(name == human.getName()){
                return human;
            }
        }

        return null;
    }

    public void sortByName(){
        activeFamily.sortByName();
    }

    public void sortByAge(){
        activeFamily.sortByAge();
    }
}
