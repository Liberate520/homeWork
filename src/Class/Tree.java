package Class;


import java.util.ArrayList;
import java.util.List;

import Interface.SaveLoad;

public class Tree implements SaveLoad {
    private List<Human> persons = new ArrayList<>();

    public List<Human> getTree(){
        return persons;
    }

    public void addPerson(Human person) {
        persons.add(person);
    }

    @Override
    public void Save(Tree treeToSave, String path) {
        SaveRestore saving = new SaveRestore();
        saving.Save(treeToSave, path);
        //throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    @Override
    public Tree Load(String path) {
        SaveRestore loading = new SaveRestore();
        return loading.Load(path);
        //throw new UnsupportedOperationException("Unimplemented method 'Load'");
    }


}
