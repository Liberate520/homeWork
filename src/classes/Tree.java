package classes;

import java.util.ArrayList;
import java.util.List;


public class Tree {
    private List<Human> persons = new ArrayList<>();

    public List<Human> getTree(){
        return persons;
    }

    public void addPerson(Human person) {
        persons.add(person);
    }

    //@Override
    public void save(Tree treeToSave, String path) {
        SaveRestore saving = new SaveRestore();
        saving.save(treeToSave, path);
        //throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    //@Override
    public Tree load(String path) {
        SaveRestore loading = new SaveRestore();
        return loading.load(path);
        //throw new UnsupportedOperationException("Unimplemented method 'Load'");
    }


}
