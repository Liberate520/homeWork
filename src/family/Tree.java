package family;

import family.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Tree implements Serializable {
    private List<Human> treeMan;

    //Конструктор
    public Tree() {
        this.treeMan=new ArrayList<Human>();
    }


    //Методы
    public void addPeople(List <Human> newpeople){
        for (Human h : newpeople ){
            this.treeMan.add(h);
        }
    }

    public void addHuman(Human Man){
        this.treeMan.add(Man);
        //return this;
    }

    @Override
    public String toString() {
        return outputTree();
    }
    public String outputTree(){
        StringBuilder sb = new StringBuilder();
        int j=0;
        for (Human h : treeMan ){
            j++;
            sb.append(j+" "+h.outputHuman()+"\n");
        }
        return sb.toString();
    }

}
