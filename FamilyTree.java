package Java_OOP.homeWork;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private String name;
    private List<Human> family;
    String path = "C:\\Users\\anohi\\OneDrive\\Documents\\Java_project\\Java_OOP\\homeWork\\";
    String fileName = "family.out";
    

    public List<Human> getFamily() {
        return family;
    }

    public FamilyTree(String name, List<Human> family) {
        this.name = name;
        this.family = family;
    }

    public void includeInFamily(Human... humans){
        for (Human h : humans){
            this.family.add(h);
        }
    }

    public List<Human> searchHuman(String name){
        List<Human> h = new ArrayList<>();
        for (Human human : family){
            if (human.getName().equalsIgnoreCase(name))
                h.add(human);
        }
        return h;
    }

	public void save(Writable fh) throws FileNotFoundException, IOException{
        fh.write(path, fileName, this);
	}

    public FamilyTree load(Writable fh) throws FileNotFoundException, IOException, ClassNotFoundException{
        return fh.load(path, fileName);
	}
}
