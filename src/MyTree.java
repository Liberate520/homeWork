import java.util.ArrayList;

public class MyTree implements Trees{


    private ArrayList<Nodes> tree = new ArrayList<Nodes>();

    
    
    public void append(Persons parent, Persons child) {

        tree.add(new Nodes(parent, child,Relationships.PARENT));
        tree.add(new Nodes(child, parent,Relationships.CHILDREN));
        
    }

    @Override
    public ArrayList<Nodes> getData() {
        return tree;
    }

   
    
}
