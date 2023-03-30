import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Human mother, Human father){
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();

  }
  public Human(String name){
        this.name = name;
        this.children = new ArrayList<>();
  }

    @Override
    public String toString() {
        return "name: " + this.name;
    }
    public void addChild(Human child){
        this.children.add(child);
    }
    public String printChildren(){
        if (this.children.isEmpty()) {
            return "None";
        }
        else {
            String allChildren = "";
            for (Human child: this.children
                 ) {
                allChildren += child.toString();

            }
            return  allChildren;
        }
    }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }
}
